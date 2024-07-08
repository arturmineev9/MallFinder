package com.example.mallfinder.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import com.bumptech.glide.Glide
import com.example.mallfinder.R
import com.example.mallfinder.data.ShopRepository
import com.example.mallfinder.databinding.FragmentShopDetailBinding

// Экран 3
// Фрагмент, в котором описывается конкретный магазин
class ShopDetailFragment : Fragment(R.layout.fragment_shop_detail) {

    private var binding: FragmentShopDetailBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentShopDetailBinding.bind(view)

        val shopName = requireArguments().getString(ARG_NAME)
        val shop = shopName?.let { ShopRepository.getShopByName(it) }
        shop?.let {
            binding?.run {
                Glide.with(this@ShopDetailFragment).load(it.url).into(shopImage)
                tvShopName.text = shop.name
                shopCategory.text = shop.category
                shopLink.text = shop.website
                shopInfo.text = shop.description
            }
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    companion object {
        private const val ARG_NAME = "ARG_NAME"
        fun bundle(shopName: String): Bundle = Bundle().apply {
            putString(ARG_NAME, shopName)
        }
    }

}