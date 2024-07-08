package com.example.mallfinder.filter.shopfilterRV

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import com.example.mallfinder.data.Shop
import com.example.mallfinder.databinding.ItemShopfilterBinding

class shopfilterAdapter(
    private val list: MutableMap<String,Shop>,
    private val glide: RequestManager,
    private val onClick: () -> Unit,
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
        onClick = onClick
    )

//    override fun onBindViewHolder(holder: shopfilterHolder, position: Int) {
//        holder.onBind(list[position])
//    }

    override fun getItemCount(): Int = list.size
}
