package com.example.legi_info.ui.nationalassembly.deputy.detail

import android.os.Bundle
import android.view.View
import android.viewbinding.library.fragment.viewBinding
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.viewpager2.adapter.FragmentStateAdapter
import coil.load
import com.example.domain.model.Deputy
import com.example.legi_info.R
import com.example.legi_info.databinding.FragmentDeputyDetailBinding
import com.example.legi_info.extension.gone
import com.example.legi_info.extension.visible
import com.example.legi_info.ui.nationalassembly.deputy.activity.DeputyActivityFragment
import com.example.legi_info.ui.nationalassembly.deputy.information.DeputyInformationFragment
import com.example.legi_info.ui.nationalassembly.deputy.work.DeputyWorkFragment
import com.google.android.material.tabs.TabLayoutMediator
import org.koin.android.viewmodel.ext.android.viewModel

class DeputyDetailFragment : Fragment(R.layout.fragment_deputy_detail) {

    private val binding by viewBinding<FragmentDeputyDetailBinding>()
    private val args by navArgs<DeputyDetailFragmentArgs>()
    private val deputyDetailViewModel by viewModel<DeputyDetailViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState == null) deputyDetailViewModel.loadInformation(args.deputy.slug)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.toolbarTitle.text = args.deputy.fullName

        binding.backIcon.setOnClickListener {
            findNavController().popBackStack()
        }

        binding.image.load(
                "https://www.nosdeputes.fr/depute/photo/${args.deputy.slug}/240"
            )

        deputyDetailViewModel.state.observe(viewLifecycleOwner, { state ->
            when(state) {
                is DeputyDetailState.Success -> {
                    binding.progressBar.gone()
                    setupTabLayout(state.deputy)
                }
                is DeputyDetailState.Error -> TODO()
                DeputyDetailState.Loading -> binding.progressBar.visible()
            }
        })
    }

    private fun setupTabLayout(deputy: Deputy) {
        val detailDeputyAdapter = DetailDeputyAdapter(this, deputy)
        binding.pager.adapter = detailDeputyAdapter
        TabLayoutMediator(binding.tabs, binding.pager) { tab, position ->
            tab.text = when(position) {
                0 -> getString(R.string.information)
                1 -> getString(R.string.activity)
                2 -> getString(R.string.works)
                else -> throw IllegalArgumentException("Illegal position")
            }
        }.attach()
    }

    companion object {
        @JvmStatic
        fun newInstance() = DeputyDetailFragment()
    }
}

class DetailDeputyAdapter(
    fragment: Fragment,
    private val deputy: Deputy
): FragmentStateAdapter(fragment) {
    override fun getItemCount() = 3

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0 -> DeputyInformationFragment.newInstance(deputy)
            1 -> DeputyActivityFragment.newInstance(deputy)
            2 -> DeputyWorkFragment.newInstance()
            else -> throw IllegalArgumentException("Illegal position")
        }
    }
}
