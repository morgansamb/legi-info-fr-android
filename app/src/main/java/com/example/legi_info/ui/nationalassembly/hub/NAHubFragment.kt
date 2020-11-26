package com.example.legi_info.ui.nationalassembly.hub

import android.os.Bundle
import android.view.View
import android.viewbinding.library.fragment.viewBinding
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.legi_info.R
import com.example.legi_info.databinding.FragmentNAHubBinding
import com.example.legi_info.ui.nationalassembly.deputy.list.DeputyListFragment
import com.example.legi_info.ui.nationalassembly.filelist.FileListFragment
import com.example.legi_info.ui.nationalassembly.organizationlist.OrganizationListFragment
import com.google.android.material.tabs.TabLayoutMediator

class NAHubFragment : Fragment(R.layout.fragment_n_a_hub) {

    private val binding by viewBinding<FragmentNAHubBinding>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val hubNAAdapter = HubNAAdapter(this)
        binding.pager.adapter = hubNAAdapter
        TabLayoutMediator(binding.tabLayout, binding.pager) { tab, position ->
            tab.text = when (position) {
                0 -> getString(R.string.groups)
                1 -> getString(R.string.parliamentarians)
                2 -> getString(R.string.files)
                else -> throw IllegalArgumentException("position not recognized")
            }
        }.attach()
    }

    companion object {
        @JvmStatic
        fun newInstance() = NAHubFragment()
    }
}

class HubNAAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

    override fun getItemCount() = 3

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0 -> OrganizationListFragment.newInstance()
            1 -> DeputyListFragment.newInstance()
            2 -> FileListFragment.newInstance()
            else -> throw IllegalArgumentException("position not recognized")
        }
    }
}
