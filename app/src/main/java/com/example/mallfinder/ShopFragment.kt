package com.example.mallfinder

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mallfinder.databinding.FragmentCategoriesBinding
import com.example.mallfinder.databinding.FragmentShopBinding

// Фрагмент элемента BottomNavigation "Магазины"
class ShopFragment : Fragment(R.layout.fragment_shop) {

    private var binding: FragmentShopBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentShopBinding.bind(view)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}