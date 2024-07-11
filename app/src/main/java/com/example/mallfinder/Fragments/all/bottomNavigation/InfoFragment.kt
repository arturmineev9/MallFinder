package com.example.mallfinder.Fragments.all.bottomNavigation

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.findNavController
import com.example.mallfinder.R
import com.example.mallfinder.databinding.FragmentInfoBinding
import com.github.dhaval2404.colorpicker.MaterialColorPickerDialog
import com.github.dhaval2404.colorpicker.model.ColorShape
import com.github.dhaval2404.colorpicker.model.ColorSwatch


class InfoFragment : Fragment(R.layout.fragment_info) {

    private var binding: FragmentInfoBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentInfoBinding.bind(view)
        binding!!.buttonColor.setOnClickListener {
            MaterialColorPickerDialog
                .Builder(requireContext())
                .setTitle("Выбор цвета")
                .setColors(arrayListOf("#E57373", "#f06292", "#ba68c8", "#9575cd", "#7986cb", "#64b5f6", "#4fc3f7", "#4dd0e1", "#4db6ac", "#81c784", "#aed581", "#dce775", "#ffd54f", "#ffb74d", "#ff8a65", "#a1887f", "#90a4ae"))
                .setColorShape(ColorShape.CIRCLE)
                .setColorSwatch(ColorSwatch._300)
                .setDefaultColor(R.color.dark_blue_main)
                .setColorListener { color, colorHex ->
                    binding!!.buttonColor.setBackgroundColor(color)
                    binding!!.aboutDevelopers.setBackgroundColor(color)
                    setAppTheme(color)
                }
                .show()


        }

        binding!!.aboutDevelopers.setOnClickListener {
            findNavController().navigate(R.id.action_infoFragment_to_developersFragment)
        }

    }


    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    private fun setAppTheme(theme: Int) {
        val sharedPreferences =
            requireContext().getSharedPreferences("AppPreferences", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putInt("APP_THEME", theme)
        editor.apply()

        requireActivity().recreate()
    }

}