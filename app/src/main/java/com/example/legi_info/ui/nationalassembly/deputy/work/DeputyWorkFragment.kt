package com.example.legi_info.ui.nationalassembly.deputy.work

import android.os.Bundle
import android.view.View
import android.viewbinding.library.fragment.viewBinding
import androidx.fragment.app.Fragment
import com.example.legi_info.R
import com.example.legi_info.databinding.FragmentDeputyWorkBinding

class DeputyWorkFragment : Fragment(R.layout.fragment_deputy_work) {

    private val binding by viewBinding<FragmentDeputyWorkBinding>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    companion object {
        @JvmStatic
        fun newInstance() = DeputyWorkFragment()
    }
}