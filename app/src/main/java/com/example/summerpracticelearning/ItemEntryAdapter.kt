package com.example.summerpracticelearning

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import com.example.summerpracticelearning.databinding.ItemItemEntryBinding

class ItemEntryAdapter(
    private var list: List<ItemEntry>,
    private val glide: RequestManager,
    private val onItemClick: (ItemEntry) -> Unit,
) : RecyclerView.Adapter<ItemEntryItem>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ItemEntryItem = ItemEntryItem(
        binding = ItemItemEntryBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false,
        ),
        glide = glide,
        onItemClick = onItemClick,
    )

    override fun onBindViewHolder(holder: ItemEntryItem, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun updateDataset(newList: List<ItemEntry>) {
        list = newList
        notifyDataSetChanged()
    }
}