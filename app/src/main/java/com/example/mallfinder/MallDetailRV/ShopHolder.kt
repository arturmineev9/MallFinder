package com.example.mallfinder.MallDetailRV

import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.RequestManager
import com.example.mallfinder.data.Shop
import com.example.mallfinder.databinding.ItemShopBinding


class ShopHolder(
    private val binding : ItemShopBinding,
    private val glide : RequestManager,
    private val onClick : (Shop) -> Unit,
) : ViewHolder(binding.root) {
    
    fun onBind(shop: Shop){
        binding.run{
            tvShop.text = shop.name
            tvCategory.text = shop.category

            glide
                .load(shop.url)
                .into(ivImage)
            root.setOnClickListener{
                onClick.invoke(shop)
            }

        }
    }
}