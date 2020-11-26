package com.example.legi_info.ui.nationalassembly.deputy.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.data.model.local.DeputyEntity
import com.example.legi_info.databinding.CardDeputyBinding

typealias DeputyClickListener = (DeputyEntity) -> Unit

class DeputyAdapter: RecyclerView.Adapter<DeputyAdapter.DeputyHolder>() {

    private val deputies = mutableListOf<DeputyEntity>()
    private var clickListener: DeputyClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DeputyHolder {
        val binding = CardDeputyBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )

        return DeputyHolder(binding)
    }

    override fun onBindViewHolder(holder: DeputyHolder, position: Int) {
        holder.bind(deputy = deputies[position])
    }

    override fun getItemCount() = deputies.size

    fun addAll(deputies: List<DeputyEntity>) {
        this.deputies.addAll(deputies)
        notifyDataSetChanged()
    }

    fun setOnClickListener(clickListener: DeputyClickListener) {
        this.clickListener = clickListener
    }

    inner class DeputyHolder(
        private val deputyBinding: CardDeputyBinding
    ): RecyclerView.ViewHolder(deputyBinding.root) {
        fun bind(deputy: DeputyEntity) {
            deputyBinding.card.setOnClickListener {
                clickListener?.invoke(deputy)
            }
            deputyBinding.fullName.text = deputy.fullName
            deputyBinding.image
                .load("https://www.nosdeputes.fr/depute/photo/${deputy.slug}/240")
        }
    }
}
