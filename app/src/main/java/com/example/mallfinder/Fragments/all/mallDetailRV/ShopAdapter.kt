package com.example.mallfinder.Fragments.all.mallDetailRV

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import com.example.mallfinder.data.Shop
import com.example.mallfinder.databinding.ItemShopBinding

class ShopAdapter(
    private var list: List<Shop?>,
    private val glide: RequestManager,
    private val onClick: (Shop) -> Unit,
) : RecyclerView.Adapter<ShopHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShopHolder {
        return ShopHolder(
            ItemShopBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ),
            glide= glide,
            onClick = onClick,
        )
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ShopHolder, position: Int) {
        list[position]?.let { holder.onBind(it) }
    }
}