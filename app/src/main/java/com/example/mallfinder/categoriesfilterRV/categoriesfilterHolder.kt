package com.example.mallfinder.categoriesfilterRV

import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.RequestManager
import com.example.mallfinder.databinding.ItemCategoriesfilterBinding
import com.example.mallfinder.repository.CategoryBeta

class categoriesfilterHolder(
    private val binding: ItemCategoriesfilterBinding,
    private val glide: RequestManager,
    private val onClick: () -> Unit,
): ViewHolder(binding.root) {

    fun onBind(category: CategoryBeta){
        binding.run {
            tvCategoryName.text = category.name
            root.setOnClickListener{
                onClick.invoke()
            }
        }
    }
}