package com.example.mallfinder.Fragments.all.bottomNavigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import com.example.mallfinder.R
import com.example.mallfinder.databinding.FragmentDevelopersBinding
import com.google.android.material.bottomnavigation.BottomNavigationView


class DevelopersFragment : Fragment(R.layout.fragment_developers) {

    private var binding: FragmentDevelopersBinding? = null


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentDevelopersBinding.bind(view)

        val bottomNavigationView = activity?.findViewById<BottomNavigationView>(R.id.bottomNavigation)
        bottomNavigationView?.visibility = View.GONE

    }

    override fun onDestroyView() {
        super.onDestroyView()
        val bottomNavigationView = activity?.findViewById<BottomNavigationView>(R.id.bottomNavigation)
        bottomNavigationView?.visibility = View.VISIBLE
        binding = null

    }
}