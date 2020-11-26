package com.example.legi_info.ui.nationalassembly.deputy.list

import android.os.Bundle
import android.view.View
import android.viewbinding.library.fragment.viewBinding
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.legi_info.R
import com.example.legi_info.databinding.FragmentSearchRecyclerBinding
import com.example.legi_info.extension.gone
import com.example.legi_info.extension.hideKeyboard
import com.example.legi_info.extension.visible
import com.example.legi_info.ui.base.ListState
import com.example.legi_info.ui.nationalassembly.hub.NAHubFragment
import com.example.legi_info.ui.nationalassembly.hub.NAHubFragmentDirections
import com.orhanobut.logger.Logger
import org.koin.android.viewmodel.ext.android.viewModel



class DeputyListFragment : Fragment(R.layout.fragment_search_recycler) {

    private val binding by viewBinding<FragmentSearchRecyclerBinding>()
    private val deputyViewModel by viewModel<DeputyListViewModel>()
    private val adapter by lazy { DeputyAdapter() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        deputyViewModel.state.observe(viewLifecycleOwner, { state ->
            when (state) {
                is ListState.Success -> {
                    binding.progressBar.gone()
                    adapter.addAll(state.data)
                }
                is ListState.Error -> {
                    binding.progressBar.gone()
                    Logger.e("ERROR")
                }
                ListState.Loading -> binding.progressBar.visible()
            }
        })

        adapter.setOnClickListener { deputy ->
            val action = NAHubFragmentDirections.actionNaHubFragmentToDeputyDetailFragment(deputy)
            findNavController().navigate(action)
        }

        binding.recycler.apply {
            adapter = this@DeputyListFragment.adapter
            setOnTouchListener { _, _ ->
                binding.searchInput.hideKeyboard()
                false
            }
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = DeputyListFragment()
    }
}
