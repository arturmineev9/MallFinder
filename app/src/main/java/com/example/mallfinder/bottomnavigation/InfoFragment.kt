package com.example.mallfinder.bottomnavigation

import android.annotation.SuppressLint
import android.annotation.TargetApi
import android.content.Context
import android.graphics.Color
import android.graphics.Paint
import android.graphics.drawable.ShapeDrawable
import android.graphics.drawable.shapes.OvalShape
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Toast
import com.example.mallfinder.R
import com.example.mallfinder.databinding.FragmentInfoBinding
import com.example.mallfinder.themechanger.Methods
import com.example.mallfinder.themechanger.ThemeColor
import com.github.dhaval2404.colorpicker.ColorPickerDialog
import com.github.dhaval2404.colorpicker.MaterialColorPickerDialog
import com.github.dhaval2404.colorpicker.model.ColorShape
import com.github.dhaval2404.colorpicker.model.ColorSwatch
import com.google.android.material.snackbar.Snackbar

// Экран 6
// Фрагмент элемента BottomNavigation "Инфо"
class InfoFragment : Fragment(R.layout.fragment_info) {

    private var binding: FragmentInfoBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentInfoBinding.bind(view)

        val methods = Methods()
        binding!!.buttonColor.setOnClickListener {
            // Kotlin Code
            MaterialColorPickerDialog
                .Builder(requireContext())                            // Pass Activity Instance
                .setTitle("Pick Theme")                // Default "Choose Color"
                .setColorShape(ColorShape.CIRCLE)    // Default ColorShape.CIRCLE
                .setColorSwatch(ColorSwatch._300)    // Default ColorSwatch._500
                .setDefaultColor(R.color.red_colorPrimary)        // Pass Default Color
                .setColorListener { color, colorHex ->
                    binding!!.buttonColor.setBackgroundColor(color)

                    Toast.makeText(requireContext(), "${color}, ${colorHex}", Toast.LENGTH_SHORT).show()
                }
                .show()

        }

    }


    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    private fun setAppTheme(theme: Int) {
        val sharedPreferences = requireContext().getSharedPreferences("AppPreferences", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putInt("APP_THEME", theme)
        editor.apply()

        requireActivity().recreate()
    }

}