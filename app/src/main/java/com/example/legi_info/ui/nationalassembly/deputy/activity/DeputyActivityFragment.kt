package com.example.legi_info.ui.nationalassembly.deputy.activity

import android.os.Bundle
import android.view.View
import android.viewbinding.library.fragment.viewBinding
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.example.domain.model.Deputy
import com.example.legi_info.R
import com.example.legi_info.databinding.FragmentDeputyActivityBinding

private const val ARG_DEPUTY = "deputy"

class DeputyActivityFragment private constructor(): Fragment(R.layout.fragment_deputy_activity) {

    private val binding by viewBinding<FragmentDeputyActivityBinding>()
    private lateinit var deputy: Deputy

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val args = requireArguments()
        deputy = args.getSerializable(ARG_DEPUTY) as Deputy
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.anAttendance.text = "${deputy.weekAttendance} ${getString(R.string.weeks)}"
        binding.anIntervention.text = deputy.hemicycleIntervention.toString()
        binding.anShortIntervention.text = deputy.hemicycleShortIntervention.toString()
        binding.anPropAmendment.text = deputy.amendmentProposed.toString()
        binding.anSignedAmendment.text = deputy.amendmentSigned.toString()
        binding.anAdoptedAmendment.text = deputy.amendmentAdopted.toString()
        binding.reports.text = deputy.report.toString()
        binding.propWritten.text = deputy.writtenProposal.toString()
        binding.propSigned.text = deputy.signedProposal.toString()
        binding.questionWritten.text = deputy.writtenQuestion.toString()
        binding.questionOral.text = deputy.oralQuestion.toString()
        binding.committeeAttendance.text = deputy.committeeAttendance.toString()
        binding.committeeIntervention.text = deputy.committeeIntervention.toString()
    }

    companion object {
        @JvmStatic
        fun newInstance(deputy: Deputy) =
            DeputyActivityFragment().apply {
                arguments = bundleOf(
                    ARG_DEPUTY to deputy
                )
            }
    }
}