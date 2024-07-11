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

// Экран 6
// Фрагмент элемента BottomNavigation "Инфо"
class InfoFragment : Fragment(R.layout.fragment_info) {

    private var binding: FragmentInfoBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentInfoBinding.bind(view)
        binding!!.buttonColor.setOnClickListener {
            // Kotlin Code
            MaterialColorPickerDialog
                .Builder(requireContext())                            // Pass Activity Instance
                .setTitle("Выбор цвета")                // Default "Choose Color"
                .setColorShape(ColorShape.CIRCLE)    // Default ColorShape.CIRCLE
                .setColorSwatch(ColorSwatch._300)    // Default ColorSwatch._500
                .setDefaultColor(R.color.dark_blue_main)        // Pass Default Color
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