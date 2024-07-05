package com.example.mallfinder

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mallfinder.databinding.FragmentMallBinding

// Фрагмент элемента BottomNavigation "ТЦ"
class MallFragment : Fragment(R.layout.fragment_mall) {

    private var binding: FragmentMallBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMallBinding.bind(view)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}