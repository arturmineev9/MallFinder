package com.example.mallfinder.bottomnavigation

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.mallfinder.R
import com.example.mallfinder.databinding.FragmentMallsListBinding
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.mallfinder.data.MallRepository
import com.example.mallfinder.databinding.FragmentFilterBinding
import com.example.mallfinder.detail.MallDetailFragment
import com.example.mallfinder.mallList.CategoryFilterViewModel
import com.example.mallfinder.mallList.MallAdapter

// Экран 1
// Фрагмент элемента BottomNavigation "ТЦ"

class MallsListFragment : Fragment(R.layout.fragment_malls_list) {

    private var binding: FragmentMallsListBinding? = null
    private val filterViewModel: CategoryFilterViewModel by activityViewModels()
    private var malls = MallRepository.malls.values.toList()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMallsListBinding.bind(view)
        binding?.run {
            ivFilter.setOnClickListener {
                findNavController().navigate(R.id.action_mallFragment_to_filterFragment)
            }
        }
        initAdapter()

        binding?.etSearch?.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                val filteredList = malls.filter {
                    it.name.contains(s.toString(), ignoreCase = true) == true
                }
                adapter?.filterList(filteredList)
            }

            override fun afterTextChanged(s: Editable?) {}
        })

        filterViewModel.selectedCategories.observe(viewLifecycleOwner, Observer { categories ->
            adapter?.filterByCategories(categories)
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    private fun initAdapter() {
        adapter = MallAdapter(
            list = MallRepository.malls.values.toList(),
            glide = Glide.with(this),
            onClick = {
                findNavController().navigate(
                    resId = R.id.action_mallFragment_to_mallDetailFragment,
                    args = MallDetailFragment.bundle(
                        mallName = it.name
                    )
                )
            }
        )
        binding?.run {
            rvMall.adapter = adapter
            rvMall.layoutManager = LinearLayoutManager(requireContext())
        }
    }
}