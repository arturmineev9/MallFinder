package com.example.mallfinder.bottomnavigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import com.example.mallfinder.R
import com.example.mallfinder.databinding.FragmentMapBinding

// Экран 4
// Фрагмент элемента BottomNavigation "Категории"
class MapFragment : Fragment(R.layout.fragment_map) {

    private var binding: FragmentMapBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMapBinding.bind(view)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}


