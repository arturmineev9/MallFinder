package com.example.mallfinder.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import com.example.mallfinder.R
import com.example.mallfinder.databinding.FragmentShopDetailBinding

// Экран 3
// Фрагмент, в котором описывается конкретный магазин
class ShopDetailFragment : Fragment(R.layout.fragment_shop_detail) {

    private var binding: FragmentShopDetailBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentShopDetailBinding.bind(view)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}