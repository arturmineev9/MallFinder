
package com.example.mallfinder.Fragments.all

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.mallfinder.Fragments.all.categoriesfilterRV.categoriesfilterAdapter
import com.example.mallfinder.data.CategoryRepository
import com.example.mallfinder.data.ShopRepository
import com.example.mallfinder.databinding.FragmentFilterBinding
import com.example.mallfinder.Fragments.all.shopFilterRV.shopfilterAdapter
import com.example.mallfinder.Fragments.all.mallList.CategoryFilterViewModel
import com.example.mallfinder.Fragments.all.mallList.ShopFilterViewModel
import com.example.mallfinder.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class FilterFragment : Fragment(R.layout.fragment_filter) {
    private var binding: FragmentFilterBinding? = null
    private var shopadapter: shopfilterAdapter? = null
    private var categoryadapter: categoriesfilterAdapter? = null
    private val categoryFilterViewModel: CategoryFilterViewModel by activityViewModels()
    private val shopFilterViewModel: ShopFilterViewModel by activityViewModels()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentFilterBinding.bind(view)

        val bottomNavigationView = activity?.findViewById<BottomNavigationView>(R.id.bottomNavigation)
        bottomNavigationView?.visibility = View.GONE

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

            findNavController().navigate(resId = R.id.action_filterFragment_to_mallFragment)
        }
    }



    override fun onDestroyView() {
        super.onDestroyView()
        val bottomNavigationView = activity?.findViewById<BottomNavigationView>(R.id.bottomNavigation)
        bottomNavigationView?.visibility = View.VISIBLE
        binding = null
    }

    private fun initAdapter(){
        binding?.run{
            shopadapter = shopfilterAdapter(
                list = ShopRepository.shops.values.toList(),
                glide = Glide.with(this@FilterFragment),
            )
            rvShopFilter.adapter = shopadapter
            rvShopFilter.layoutManager = LinearLayoutManager(requireContext())
        }

        binding?.run{
            categoryadapter = categoriesfilterAdapter(
                list = CategoryRepository.getAllCategories().values.toList(),
                glide = Glide.with(this@FilterFragment),
            )
            rvCategoryFilter.adapter = categoryadapter
            rvCategoryFilter.layoutManager = LinearLayoutManager(requireContext())
        }

    }
}
