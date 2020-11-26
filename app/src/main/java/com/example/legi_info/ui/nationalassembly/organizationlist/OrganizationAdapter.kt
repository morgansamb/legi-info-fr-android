package com.example.legi_info.ui.nationalassembly.organizationlist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.data.model.local.OrganizationEntity
import com.example.data.model.remote.Organization
import com.example.legi_info.R
import com.example.legi_info.databinding.CardOrganizationBinding

class OrganizationAdapter: RecyclerView.Adapter<OrganizationAdapter.OrganizationHolder>() {

    private val organizations = mutableListOf<OrganizationEntity>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrganizationHolder {
        val binding = CardOrganizationBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )

        return OrganizationHolder(binding)
    }

    override fun onBindViewHolder(holder: OrganizationHolder, position: Int) {
        holder.bind(organization = organizations[position])
    }

    override fun getItemCount() = organizations.size

    fun addAll(organizations: List<OrganizationEntity>) {
        this.organizations.addAll(organizations)
        notifyDataSetChanged()
    }

    inner class OrganizationHolder(
        private val cardOrganizationBinding: CardOrganizationBinding
    ): RecyclerView.ViewHolder(cardOrganizationBinding.root) {
        fun bind(organization: OrganizationEntity) {
            cardOrganizationBinding.name.text = organization.name

            when (organization.acronym) {
                "AE" -> cardOrganizationBinding.image.load(R.drawable.ic_groupe_agir)
                "GDR" -> cardOrganizationBinding.image.load(R.drawable.ic_groupe_gdr)
                "LFI" -> cardOrganizationBinding.image.load(R.drawable.ic_groupe_lfi)
                "LREM" -> cardOrganizationBinding.image.load(R.drawable.ic_groupe_larem)
                "LR" -> cardOrganizationBinding.image.load(R.drawable.ic_groupe_lr)
                "MODEM" -> cardOrganizationBinding.image.load(R.drawable.ic_groupe_modem)
                "SOC" -> cardOrganizationBinding.image.load(R.drawable.ic_groupe_soc)
                "UDI" -> cardOrganizationBinding.image.load(R.drawable.ic_groupe_udi)
                else -> cardOrganizationBinding.image.load(R.drawable.ic_no_image)
            }
        }
    }
}
