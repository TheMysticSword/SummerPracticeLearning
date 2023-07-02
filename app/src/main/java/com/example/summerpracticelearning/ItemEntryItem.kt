package com.example.summerpracticelearning

import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.RequestManager
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.example.summerpracticelearning.databinding.ItemItemEntryBinding

class ItemEntryItem(
    private val binding: ItemItemEntryBinding,
    private val glide: RequestManager,
    private val onItemClick: (ItemEntry) -> Unit,
) : ViewHolder(binding.root) {
    private val options: RequestOptions = RequestOptions
        .diskCacheStrategyOf(DiskCacheStrategy.NONE)

    fun onBind(itemEntry: ItemEntry) {
        binding.run {
            tvItemName.text = itemEntry.name
            tvItemDesc.text = itemEntry.desc

            glide
                .load(itemEntry.url)
                .placeholder(R.drawable.ic_baseline_settings_24)
                .error(R.drawable.bolt_48px)
                .apply(options)
                .into(ivIcon)

            root.setOnClickListener {
                onItemClick(itemEntry)
            }
        }
    }
}