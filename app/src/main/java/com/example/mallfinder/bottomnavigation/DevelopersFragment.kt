package com.example.mallfinder.bottomnavigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import com.example.mallfinder.R
import com.example.mallfinder.databinding.FragmentDevelopersBinding


// Экран 1
// Фрагмент элемента BottomNavigation "ТЦ"

class DevelopersFragment : Fragment(R.layout.fragment_developers) {

    private var binding: FragmentDevelopersBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentDevelopersBinding.bind(view)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}