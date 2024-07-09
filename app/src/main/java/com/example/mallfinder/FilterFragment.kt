
package com.example.mallfinder

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.mallfinder.databinding.FragmentFilterBinding
import com.example.mallfinder.filter.shopfilterRV.shopfilterAdapter
import com.example.mallfinder.repository.ShopRepositoryBeta

class FilterFragment : Fragment(R.layout.fragment_filter) {
    private var binding: FragmentFilterBinding? = null

    private var adapter: shopfilterAdapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentFilterBinding.bind(view)

        initAdapter()
    }


    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    private fun initAdapter(){
        binding?.run{
            adapter = shopfilterAdapter(
                list = ShopRepositoryBeta.shops,
                glide = Glide.with(this@FilterFragment),
                onClick = {
                    // TO DO : filter logic
                }
            )
            rvShopFilter.adapter = adapter
            rvShopFilter.layoutManager = LinearLayoutManager(requireContext())
        }

    }
}
