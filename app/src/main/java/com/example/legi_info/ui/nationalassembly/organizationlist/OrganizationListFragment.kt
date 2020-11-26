package com.example.legi_info.ui.nationalassembly.organizationlist

import android.os.Bundle
import android.view.View
import android.viewbinding.library.fragment.viewBinding
import androidx.fragment.app.Fragment
import com.example.legi_info.R
import com.example.legi_info.databinding.FragmentRecyclerBinding
import com.example.legi_info.ui.base.ListState
import com.orhanobut.logger.Logger
import org.koin.android.viewmodel.ext.android.viewModel

class OrganizationListFragment : Fragment(R.layout.fragment_recycler) {

    private val binding by viewBinding<FragmentRecyclerBinding>()
    private val organizationListViewModel by viewModel<OrganizationListViewModel>()
    private val organizationAdapter by lazy { OrganizationAdapter() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.recycler.adapter = organizationAdapter

        organizationListViewModel.state.observe(viewLifecycleOwner, { state ->
            when (state) {
                is ListState.Success -> organizationAdapter.addAll(state.data)
                is ListState.Error -> Logger.e("ERROR")
                ListState.Loading -> Logger.i("Loading deputies")
            }
        })
    }

    companion object {
        @JvmStatic
        fun newInstance() = OrganizationListFragment()
    }
}
