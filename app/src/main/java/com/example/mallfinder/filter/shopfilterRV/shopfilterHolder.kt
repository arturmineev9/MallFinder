package com.example.mallfinder.filter.shopfilterRV

import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.RequestManager
import com.example.mallfinder.data.Shop
import com.example.mallfinder.databinding.ItemShopfilterBinding
import com.example.mallfinder.repository.ShopBeta

class shopfilterHolder(
    private val binding: ItemShopfilterBinding,
    private val glide: RequestManager,
    private val onClick: () -> Unit,
): ViewHolder(binding.root) {

    fun onBind(shop: ShopBeta){
        binding.run {
            tvShopName.text = shop.shopName
            root.setOnClickListener{
                onClick.invoke()
            }
        }
    }
}
