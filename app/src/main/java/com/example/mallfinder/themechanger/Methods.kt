package com.example.mallfinder.themechanger

import com.example.mallfinder.R

class Methods {

    fun setColorTheme() {
        when (ThemeColor.color)
        {
            0xffF44e336.toInt() -> ThemeColor.theme = R.style.AppTheme_red
        }
    }
}