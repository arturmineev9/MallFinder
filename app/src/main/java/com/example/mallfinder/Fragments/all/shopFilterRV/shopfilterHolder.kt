package com.example.mallfinder.Fragments.all.shopFilterRV

import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.RequestManager
import com.example.mallfinder.data.Shop
import com.example.mallfinder.databinding.ItemShopfilterBinding

class shopfilterHolder(
    private val binding: ItemShopfilterBinding,
    private val glide: RequestManager,
): ViewHolder(binding.root) {

    fun onBind(shop: Shop){
        binding.run {
            tvShopName.text = shop.name
            cbShop.isChecked = shop.isSelected
            binding.cbShop.setOnCheckedChangeListener{ _, isChecked ->
                shop.isSelected = binding.cbShop.isChecked
            }
        }
    }
}
