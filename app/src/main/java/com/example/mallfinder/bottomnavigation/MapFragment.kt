package com.example.mallfinder.bottomnavigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import com.example.mallfinder.R
import com.example.mallfinder.databinding.FragmentMapBinding
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

// Экран 4
// Фрагмент элемента BottomNavigation "Карта"
class MapFragment : Fragment(R.layout.fragment_map), OnMapReadyCallback {

    private var binding: FragmentMapBinding? = null
    private lateinit var mallMap : GoogleMap


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMapBinding.bind(view)


        val mapFragment = childFragmentManager.findFragmentById(R.id.mallMap) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mallMap = googleMap
        initMap()
    }

    fun initMap(){
        mallMap.isBuildingsEnabled = true
        mallMap.isIndoorEnabled = true
        val kazanCoordinates = Pair(55.7887, 49.1221)
        var startPoint = LatLng(kazanCoordinates.first, kazanCoordinates.second)
        mallMap.moveCamera(CameraUpdateFactory.newLatLngZoom(startPoint, 11.5f))
    }

    fun initMarkers(){ //когда будет готов MallRepository реализую функцию
//        MallsRepository.malls.forEach(
//            action =  {
//                    mall->
//                mallMap.addMarker(MarkerOptions().position(LatLng(mall.cords.first, mall.cords.second)))
//            }
//        )
        TODO("MallRepository isn't ready yet")
    }
}


