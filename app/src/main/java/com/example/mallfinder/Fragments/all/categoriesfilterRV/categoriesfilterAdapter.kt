package com.example.mallfinder.Fragments.all.categoriesfilterRV

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import com.example.mallfinder.data.Category
import com.example.mallfinder.data.CategoryRepository
import com.example.mallfinder.databinding.ItemCategoriesfilterBinding

class categoriesfilterAdapter(
    private var list: List<Category>,
    private val glide: RequestManager,
) : RecyclerView.Adapter<categoriesfilterHolder>(){
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): categoriesfilterHolder = categoriesfilterHolder (
        binding = ItemCategoriesfilterBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ),
        glide = glide,
    )


    override fun onBindViewHolder(holder: categoriesfilterHolder, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int = list.size

    fun resetSelection() {
        for (category in list) {
            category.isSelected = false
        }
        list = CategoryRepository.getAllCategories().values.toList()
        notifyDataSetChanged()
    }

}