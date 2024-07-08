package com.example.mallfinder.bottomnavigation

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Toast
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
            ivFilter.setOnClickListener {
                val dialog = AlertDialog.Builder(context)
                dialog.setTitle("Фильтр")
                dialog.setPositiveButton("Применить Фильтр", DialogInterface.OnClickListener { dialog, which ->
                    dialog.dismiss()
                })
                dialog.setNegativeButton("Очистить Фильтр", DialogInterface.OnClickListener{
                        dialog, which ->
                    dialog.dismiss()
                })
                dialog.show()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }


}