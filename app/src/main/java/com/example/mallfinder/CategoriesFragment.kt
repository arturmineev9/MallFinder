package com.example.mallfinder

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mallfinder.databinding.FragmentCategoriesBinding
import com.example.mallfinder.databinding.FragmentMallBinding

// Фрагмент элемента BottomNavigation "Категории"
class CategoriesFragment : Fragment(R.layout.fragment_categories) {

    private var binding: FragmentCategoriesBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentCategoriesBinding.bind(view)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}