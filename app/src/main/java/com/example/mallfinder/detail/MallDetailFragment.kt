package com.example.mallfinder.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import com.bumptech.glide.Glide
import com.example.mallfinder.R
import com.example.mallfinder.data.MallRepository
import com.example.mallfinder.data.ShopRepository
import com.example.mallfinder.databinding.FragmentMallDetailBinding
import com.example.mallfinder.databinding.FragmentShopDetailBinding

// Экран 2
// Фрагмент, в котором описывается конкретный ТЦ
class MallDetailFragment : Fragment(R.layout.fragment_mall_detail) {

    private var binding: FragmentMallDetailBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMallDetailBinding.bind(view)

        val mallName = requireArguments().getString(ARG_NAME)
        val mall = mallName?.let { MallRepository.getMallById(it) }
        mall?.let {
            binding?.run {
                Glide.with(this@MallDetailFragment).load(it.url).into(mallImage)
                tvMallName.text = mall.name
                mallDescription.text = mall.description
                mallWorkhours.text = mall.work_hours
            }
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    companion object {
        private const val ARG_NAME = "ARG_NAME"
        fun bundle(mallName: String): Bundle = Bundle().apply {
            putString(ARG_NAME, mallName)
        }
    }

}