package com.example.mallfinder.Fragments.all.categoriesfilterRV

import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.RequestManager
import com.example.mallfinder.data.Category
import com.example.mallfinder.databinding.ItemCategoriesfilterBinding

class categoriesfilterHolder(
    private val binding: ItemCategoriesfilterBinding,
    private val glide: RequestManager,
    private val onClick: () -> Unit,
): ViewHolder(binding.root) {
    fun onBind(category: Category){
        binding.run {
            tvCategoryName.text = category.name

            root.setOnClickListener{
                onClick.invoke()
            }
            glide
                .load(category.icon)
                .into(ivCategory)
            cbCategory.isChecked = category.isSelected
            binding.cbCategory.setOnCheckedChangeListener{ _, isChecked ->
                category.isSelected = binding.cbCategory.isChecked
            }
        }
    }
}