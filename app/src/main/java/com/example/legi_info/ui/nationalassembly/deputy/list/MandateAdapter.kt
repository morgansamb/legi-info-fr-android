package com.example.legi_info.ui.nationalassembly.deputy.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.legi_info.databinding.CardMandateBinding
import com.orhanobut.logger.Logger

class MandateAdapter(
    private val mandates: List<String>
): RecyclerView.Adapter<MandateAdapter.MandateHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MandateHolder {
        val binding = CardMandateBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )

        return MandateHolder(binding)
    }

    override fun onBindViewHolder(holder: MandateHolder, position: Int) {
        holder.bind(mandate = mandates[position])
    }

    override fun getItemCount() = mandates.size

    inner class MandateHolder(
        private val mandateBinding: CardMandateBinding
    ): RecyclerView.ViewHolder(mandateBinding.root) {
        fun bind(mandate: String) {
            val mandateSplit = mandate.split("/")
            try {
                mandateBinding.office.text = mandateSplit[1].trim()
                mandateBinding.state.text = mandateSplit[0].trim()
                mandateBinding.status.text = mandateSplit[2].trim().capitalize()
            } catch (e: Exception) {
                Logger.e(e.message.orEmpty())
            }
        }
    }
}
