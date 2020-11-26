package com.example.legi_info.ui.nationalassembly.filelist

import android.os.Bundle
import android.view.View
import android.viewbinding.library.fragment.viewBinding
import androidx.fragment.app.Fragment
import com.example.legi_info.R
import com.example.legi_info.databinding.FragmentSearchRecyclerBinding
import com.example.legi_info.ui.base.ListState
import com.orhanobut.logger.Logger
import org.koin.android.viewmodel.ext.android.viewModel

class FileListFragment : Fragment(R.layout.fragment_search_recycler) {

    private val binding by viewBinding<FragmentSearchRecyclerBinding>()
    private val fileListViewModel by viewModel<FileListViewModel>()
    private val fileAdapter by lazy { FileAdapter() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.recycler.adapter = fileAdapter

        fileListViewModel.state.observe(viewLifecycleOwner, { state ->
            when (state) {
                is ListState.Success -> fileAdapter.addAll(state.data)
                is ListState.Error -> Logger.e("error")
                ListState.Loading -> Logger.i("loading")
            }
        })
    }

    companion object {
        @JvmStatic
        fun newInstance() = FileListFragment()
    }
}