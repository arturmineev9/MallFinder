
package com.example.mallfinder

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.mallfinder.categoriesfilterRV.categoriesfilterAdapter
import com.example.mallfinder.data.Category
import com.example.mallfinder.data.CategoryRepository
import com.example.mallfinder.data.Shop
import com.example.mallfinder.data.ShopRepository
import com.example.mallfinder.databinding.FragmentFilterBinding
import com.example.mallfinder.filter.shopfilterRV.shopfilterAdapter
import com.example.mallfinder.mallList.CategoryFilterViewModel
import com.example.mallfinder.mallList.ShopFilterViewModel

class FilterFragment : Fragment(R.layout.fragment_filter) {
    private var binding: FragmentFilterBinding? = null
    private var shopadapter: shopfilterAdapter? = null
    private var categoryadapter: categoriesfilterAdapter? = null
    private val categoryFilterViewModel: CategoryFilterViewModel by activityViewModels()
    private val shopFilterViewModel: ShopFilterViewModel by activityViewModels()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentFilterBinding.bind(view)

        initAdapter()

        binding!!.btnClearFilter.setOnClickListener{
            categoryadapter?.resetSelection()
            shopadapter?.resetSelection()
            val selectedCategories = CategoryRepository.getAllCategories().values.toList()
            val selectedShops = ShopRepository.getAllShops().values.toList()
            categoryFilterViewModel.selectedCategories.value = selectedCategories
            shopFilterViewModel.selectedShops.value = selectedShops
        }

        binding?.btnUseFilter?.setOnClickListener(){
            val selectedCategories = CategoryRepository.getAllCategories().values.toList().filter {
                category ->  category.isSelected
            } ?: listOf()
            categoryFilterViewModel.selectedCategories.value = selectedCategories
            val selectedShops = ShopRepository.getAllShops().values.toList().filter {
                shop ->  shop.isSelected
            } ?: listOf()
            shopFilterViewModel.selectedShops.value = selectedShops
        }
    }



    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    private fun initAdapter(){
        binding?.run{
            shopadapter = shopfilterAdapter(
                list = ShopRepository.shops.values.toList(),
                glide = Glide.with(this@FilterFragment),
                onClick = {
                    // TO DO : filter logic
                }
            )
            rvShopFilter.adapter = shopadapter
            rvShopFilter.layoutManager = LinearLayoutManager(requireContext())
        }

        binding?.run{
            categoryadapter = categoriesfilterAdapter(
                list = CategoryRepository.getAllCategories().values.toList(),
                glide = Glide.with(this@FilterFragment),
                onClick = {
                    // TO DO : filter logic
                }
            )
            rvCategoryFilter.adapter = categoryadapter
            rvCategoryFilter.layoutManager = LinearLayoutManager(requireContext())
        }

    }
}
