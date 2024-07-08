package com.example.mallfinder.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import com.bumptech.glide.Glide
import com.example.mallfinder.R
import com.example.mallfinder.databinding.FragmentShopDetailBinding
import com.example.mallfinder.repository.ShopRepository

// Экран 3
// Фрагмент, в котором описывается конкретный магазин
class ShopDetailFragment : Fragment(R.layout.fragment_shop_detail) {

    private var binding: FragmentShopDetailBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentShopDetailBinding.bind(view)

        val shopID = requireArguments().getInt(ARG_ID)
        val shop = ShopRepository.getItemById(shopID)
        shop?.let {
            binding?.run {
                Glide.with(this@ShopDetailFragment).load(it.shopURL).into(shopImage)
                shopName.text = shop.shopName
                shopCategory.text = shop.shopCategory
                shopLink.text = shop.shopLink
                shopInfo.text = shop.shopInfo
            }
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    companion object {
        private const val ARG_ID = "ARG_ID"
        fun bundle(theoryID: Int): Bundle = Bundle().apply {
            putInt(ARG_ID, theoryID)
        }
    }

}