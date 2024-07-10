package com.example.mallfinder

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.mallfinder.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var binding: ActivityMainBinding? = null
    private var controller: NavController? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        setCustomTheme()
        super.onCreate(savedInstanceState)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        binding = ActivityMainBinding.inflate(layoutInflater).also {
            setContentView(it.root)
        }

        controller = (supportFragmentManager.findFragmentById(R.id.container) as NavHostFragment)
            .navController

        controller?.let { navController ->
            binding?.bottomNavigation?.setupWithNavController(navController)
        }
    }

    private fun setCustomTheme() {
        val sharedPreferences = getSharedPreferences("AppPreferences", Context.MODE_PRIVATE)
        var theme = sharedPreferences.getInt("APP_THEME", R.style.AppTheme_red)
        when (theme) {
            -1739917 -> theme = R.style.AppTheme_red
            -1023342 -> theme = R.style.AppTheme_pink
            -4560696 -> theme = R.style.AppTheme_purple
            -6982195 -> theme = R.style.AppTheme_dark_purple
            -8812853 -> theme = R.style.AppTheme_dark_blue
            -10177034 -> theme = R.style.AppTheme_blue
            -11549705 -> theme = R.style.AppTheme_cyan
            -11677471 -> theme = R.style.AppTheme_cloud
            -11684180 -> theme = R.style.AppTheme_emerald
            -8271996 -> theme = R.style.AppTheme_dark_green
            -5319295 -> theme = R.style.AppTheme_green
            -2300043 -> theme = R.style.AppTheme_grass
            -3722 -> theme = R.style.AppTheme_yellow
            -10929 -> theme = R.style.AppTheme_dark_yellow
            -18611 -> theme = R.style.AppTheme_orange
            -30107 -> theme = R.style.AppTheme_dark_orange
            -6190977 -> theme = R.style.AppTheme_brown
            -2039584 -> theme = R.style.AppTheme_gray
            -7297874 -> theme = R.style.AppTheme_dark_gray

        }
        setTheme(theme)
    }


    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}