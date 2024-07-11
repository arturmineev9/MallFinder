package com.example.mallfinder.Fragments.all.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import com.bumptech.glide.Glide
import com.example.mallfinder.R
import com.example.mallfinder.data.ShopRepository
import com.example.mallfinder.databinding.FragmentShopDetailBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class ShopDetailFragment : Fragment(R.layout.fragment_shop_detail) {

    private var binding: FragmentShopDetailBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentShopDetailBinding.bind(view)

        val bottomNavigationView = activity?.findViewById<BottomNavigationView>(R.id.bottomNavigation)
        bottomNavigationView?.visibility = View.GONE

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