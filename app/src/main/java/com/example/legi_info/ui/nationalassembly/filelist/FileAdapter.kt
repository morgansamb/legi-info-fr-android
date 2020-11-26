package com.example.legi_info.ui.nationalassembly.filelist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.data.model.remote.File
import com.example.legi_info.databinding.CardFileBinding

class FileAdapter: RecyclerView.Adapter<FileAdapter.FileHolder>() {

    private val files = mutableListOf<File>()

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

    fun addAll(files: List<File>) {
        this.files.addAll(files)
        notifyDataSetChanged()
    }

    inner class FileHolder(
        private val cardFileBinding: CardFileBinding
    ): RecyclerView.ViewHolder(cardFileBinding.root) {
        fun bind(file: File) {
            cardFileBinding.title.text = file.content.title
        }
    }
}
