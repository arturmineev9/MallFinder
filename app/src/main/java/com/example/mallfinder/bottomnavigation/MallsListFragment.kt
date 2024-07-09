package com.example.mallfinder.bottomnavigation

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.findNavController
import com.example.mallfinder.R
import com.example.mallfinder.databinding.FragmentMallsListBinding

// Экран 1
// Фрагмент элемента BottomNavigation "ТЦ"

class MallsListFragment : Fragment(R.layout.fragment_malls_list) {

    private var binding: FragmentMallsListBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMallsListBinding.bind(view)

        binding?.run {
            ivFilter.setOnClickListener{
                findNavController().navigate(R.id.action_mallFragment_to_filterFragment)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}