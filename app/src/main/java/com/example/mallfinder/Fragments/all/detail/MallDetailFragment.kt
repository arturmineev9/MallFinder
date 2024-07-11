package com.example.mallfinder.Fragments.all.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.mallfinder.Fragments.all.mallDetailRV.ShopAdapter
import com.example.mallfinder.R
import com.example.mallfinder.data.MallRepository
import com.example.mallfinder.databinding.FragmentMallDetailBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MallDetailFragment : Fragment(R.layout.fragment_mall_detail) {

    private var binding: FragmentMallDetailBinding? = null
    private var adapter : ShopAdapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMallDetailBinding.bind(view)

        val bottomNavigationView = activity?.findViewById<BottomNavigationView>(R.id.bottomNavigation)
        bottomNavigationView?.visibility = View.GONE

        val mallName = requireArguments().getString(ARG_NAME)
        val mall = mallName?.let { MallRepository.getMallById(it) }
        mall?.let {
            binding?.run {
                Glide.with(this@MallDetailFragment).load(it.url).into(mallImage)
                tvMallName.text = mall.name
                mallAddress.text = mall.address
                mallDescription.text = mall.description
                mallWorkhours.text = mall.work_hours
            }
        }

        initAdapter()

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

    private fun initAdapter(){
        adapter = MallRepository.malls[requireArguments().getString(ARG_NAME)]?.let { it ->
            ShopAdapter(
                list = it.shop_list,
                glide = Glide.with(this),
                onClick = {
                    findNavController().navigate(
                        resId = R.id.action_mallDetailFragment_to_shopDetailFragment,
                        args = ShopDetailFragment.bundle(
                            shopName = it.name
                        )
                    )
                }
            )
        }
        binding?.run{
            rvShop.adapter = adapter
            rvShop.layoutManager = LinearLayoutManager(requireContext())
        }
    }


}