package com.example.legi_info.ui.nationalassembly.filelist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.data.model.local.FileEntity
import com.example.legi_info.databinding.CardFileBinding

typealias FileClickListener = (FileEntity) -> Unit

class FileAdapter: RecyclerView.Adapter<FileAdapter.FileHolder>() {

    private val files = mutableListOf<FileEntity>()
    private var clickListener: FileClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FileHolder {
        val binding = CardFileBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )

        return FileHolder(binding)
    }

    override fun onBindViewHolder(holder: FileHolder, position: Int) {
        holder.bind(file = files[position])
    }

    override fun getItemCount() = files.size

    fun addAll(files: List<FileEntity>) {
        this.files.addAll(files)
        notifyDataSetChanged()
    }

    fun setOnClickListener(clickListener: FileClickListener) {
        this.clickListener = clickListener
    }

    inner class FileHolder(
        private val cardFileBinding: CardFileBinding
    ): RecyclerView.ViewHolder(cardFileBinding.root) {
        fun bind(file: FileEntity) {
            cardFileBinding.title.text = file.title
        }
    }
}
