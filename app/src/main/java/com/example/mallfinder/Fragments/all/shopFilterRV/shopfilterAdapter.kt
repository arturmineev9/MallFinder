package com.example.mallfinder.Fragments.all.shopFilterRV

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import com.example.mallfinder.data.Shop
import com.example.mallfinder.databinding.ItemShopfilterBinding

class shopfilterAdapter(
    private var list: List<Shop>,
    private val glide: RequestManager,
) : RecyclerView.Adapter<shopfilterHolder>(){

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): shopfilterHolder = shopfilterHolder (
        binding = ItemShopfilterBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ),
        glide = glide,
    )

    override fun onBindViewHolder(holder: shopfilterHolder, position: Int) {
        holder.onBind(list[position])
    }

    fun resetSelection() {
        for (shop in list) {
            shop.isSelected = false
        }
        notifyDataSetChanged()
    }


    override fun getItemCount(): Int = list.size
}
