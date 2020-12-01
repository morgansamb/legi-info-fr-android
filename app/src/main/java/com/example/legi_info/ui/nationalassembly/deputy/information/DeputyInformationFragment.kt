package com.example.legi_info.ui.nationalassembly.deputy.information

import android.os.Bundle
import android.view.View
import android.viewbinding.library.fragment.viewBinding
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.example.domain.model.Deputy
import com.example.legi_info.R
import com.example.legi_info.databinding.FragmentDeputyInformationBinding
import com.example.legi_info.extension.gone
import com.example.legi_info.extension.yearDiff
import com.example.legi_info.ui.nationalassembly.deputy.list.MandateAdapter
import org.threeten.bp.LocalDate
import org.threeten.bp.format.DateTimeFormatter
import org.threeten.bp.format.FormatStyle

private const val ARG_DEPUTY = "deputy"

class DeputyInformationFragment private constructor(): Fragment(R.layout.fragment_deputy_information) {

    private val binding by viewBinding<FragmentDeputyInformationBinding>()
    private lateinit var deputy: Deputy

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val args = requireArguments()
        deputy = args.getSerializable(ARG_DEPUTY) as Deputy
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val localBirthDate = LocalDate.parse(
            deputy.birthDate,
            DateTimeFormatter.ofPattern("yyyy-MM-dd")
        )

        binding.age.text = "${localBirthDate.yearDiff()} ${getString(R.string.age)}"

        val localFormatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT)
        binding.birthDate.text = localBirthDate.format(localFormatter)

        binding.jobTitle.text = deputy.job
        binding.numDistrict.text = deputy.districtNum.toString()
        binding.departmentName.text = deputy.districtName
        binding.groupName.text = deputy.organization
        binding.groupStatus.text = deputy.orgStatus.capitalize()

        if (deputy.otherMandates.isNotEmpty()) {
            val mandateAdapter = MandateAdapter(deputy.otherMandates)
            binding.mandatesRecycler.adapter = mandateAdapter
        } else {
            binding.mandatesRecycler.gone()
            binding.otherMandates.gone()
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(deputy: Deputy) =
            DeputyInformationFragment().apply {
                arguments = bundleOf(
                    ARG_DEPUTY to deputy
                )
            }
    }
}
