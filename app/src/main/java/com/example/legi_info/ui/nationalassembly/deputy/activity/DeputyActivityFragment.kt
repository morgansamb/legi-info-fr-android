package com.example.legi_info.ui.nationalassembly.deputy.activity

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.viewbinding.library.fragment.viewBinding
import com.example.legi_info.R
import com.example.legi_info.databinding.FragmentDeputyActivityBinding

class DeputyActivityFragment : Fragment(R.layout.fragment_deputy_activity) {

    private val binding by viewBinding<FragmentDeputyActivityBinding>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    companion object {
        @JvmStatic
        fun newInstance() = DeputyActivityFragment()
    }
}