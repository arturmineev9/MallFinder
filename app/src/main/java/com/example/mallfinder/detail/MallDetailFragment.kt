package com.example.mallfinder.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import com.example.mallfinder.R
import com.example.mallfinder.databinding.FragmentMallDetailBinding

// Экран 2
// Фрагмент, в котором описывается конкретный ТЦ
class MallDetailFragment : Fragment(R.layout.fragment_mall_detail) {

    private var binding: FragmentMallDetailBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMallDetailBinding.bind(view)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}