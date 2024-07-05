package com.example.mallfinder.bottomnavigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import com.example.mallfinder.R
import com.example.mallfinder.databinding.FragmentShopsListBinding

// Экран 5
// Фрагмент элемента BottomNavigation "Магазины"
class ShopsListFragment : Fragment(R.layout.fragment_shops_list) {

    private var binding: FragmentShopsListBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentShopsListBinding.bind(view)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}