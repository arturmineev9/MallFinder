package com.example.mallfinder.Fragments.all.mallList

import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.RequestManager
import com.example.mallfinder.data.Mall
import com.example.mallfinder.data.Shop
import com.example.mallfinder.databinding.ItemMallBinding
import com.example.mallfinder.databinding.ItemShopBinding

class MallHolder(
    private val binding : ItemMallBinding,
    private val glide : RequestManager,
    private val onClick : (Mall) -> Unit,
) : ViewHolder(binding.root) {

    fun onBind(mall: Mall){
        binding.run{
            tvMall.text = mall.name
            tvStreet.text = mall.address

            glide
                .load(mall.url)
                .into(ivImage)
            root.setOnClickListener{
                onClick.invoke(mall)
            }

        }
    }
}