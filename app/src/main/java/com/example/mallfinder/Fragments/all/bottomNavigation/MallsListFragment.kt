package com.example.mallfinder.Fragments.all.bottomNavigation

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.mallfinder.R
import com.example.mallfinder.databinding.FragmentMallsListBinding
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.mallfinder.data.MallRepository
import com.example.mallfinder.Fragments.all.detail.MallDetailFragment
import com.example.mallfinder.Fragments.all.mallList.CategoryFilterViewModel
import com.example.mallfinder.Fragments.all.mallList.MallAdapter
import com.example.mallfinder.Fragments.all.mallList.ShopFilterViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView

// Экран 1
// Фрагмент элемента BottomNavigation "ТЦ"

class MallsListFragment : Fragment(R.layout.fragment_malls_list) {

    private var binding: FragmentMallsListBinding? = null
    private val categoryFilterViewModel: CategoryFilterViewModel by activityViewModels()
    private val shopFilterViewModel: ShopFilterViewModel by activityViewModels()
    private var malls = MallRepository.malls.values.toList()
    private var adapter: MallAdapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMallsListBinding.bind(view)
        binding?.run {
            ivFilter.setOnClickListener {
                findNavController().navigate(R.id.action_mallFragment_to_filterFragment)
            }
        }
        initAdapter()

        val bottomNavigationView = activity?.findViewById<BottomNavigationView>(R.id.bottomNavigation)
        bottomNavigationView?.visibility = View.VISIBLE

        binding?.etSearch?.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                val filteredList = malls.filter {
                    it.name.contains(s.toString(), ignoreCase = true) == true
                }
                adapter?.filterList(filteredList)
            }

            override fun afterTextChanged(s: Editable?) {}
        })

        categoryFilterViewModel.selectedCategories.observe(viewLifecycleOwner, Observer { categories ->
            adapter?.filterByCategories(categories)
        })

        shopFilterViewModel.selectedShops.observe(viewLifecycleOwner) { shops ->
            adapter?.filterByShops(shops)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    private fun initAdapter() {
        adapter = MallAdapter(
            list = MallRepository.malls.values.toList(),
            glide = Glide.with(this),
            onClick = {
                findNavController().navigate(
                    resId = R.id.action_mallFragment_to_mallDetailFragment,
                    args = MallDetailFragment.bundle(
                        mallName = it.name
                    )
                )
            }
        )
        binding?.run {
            rvMall.adapter = adapter
            rvMall.layoutManager = LinearLayoutManager(requireContext())
        }
    }
}