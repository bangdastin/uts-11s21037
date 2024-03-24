package com.ifs21037.dinopedia

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ifs21037.dinopedia.databinding.ItemRowDino2Binding

class ListDinoAdapter2(private val listDino: ArrayList<Dino2>) :
    RecyclerView.Adapter<ListDinoAdapter2.ListViewHolder>() {

    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val binding = ItemRowDino2Binding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val dino2 = listDino[position]
        holder.bind(dino2)
        holder.itemView.setOnClickListener { onItemClickCallback.onItemClicked(dino2) }
    }

    override fun getItemCount(): Int = listDino.size

    inner class ListViewHolder(private val binding: ItemRowDino2Binding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(dino2: Dino2) {
            binding.ivItemDino.setImageResource(dino2.dinoss)
            binding.tvItemDino2.text = dino2.nama
        }
    }

    interface OnItemClickCallback { fun onItemClicked(data: Dino2)
    }
}
