package com.example.mallfinder.bottomnavigation

import android.content.pm.PackageManager
import android.location.Location
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.mallfinder.R
import com.example.mallfinder.databinding.FragmentMapBinding
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
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
    private lateinit var fusedLocationClient: FusedLocationProviderClient

    companion object {
        private const val LOCATION_PERMISSION_REQUEST_CODE = 1
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMapBinding.bind(view)

        fusedLocationClient = LocationServices.getFusedLocationProviderClient(requireActivity())
        val mapFragment = childFragmentManager.findFragmentById(R.id.mallMap) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mallMap = googleMap

        if (ContextCompat.checkSelfPermission(requireContext(),
                android.Manifest.permission.ACCESS_FINE_LOCATION)
            == PackageManager.PERMISSION_GRANTED) {
            enableMyLocation()
        } else {
            requestLocationPermission()
        }

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

    //Getting self location
    private fun enableMyLocation() {
        if (ActivityCompat.checkSelfPermission(requireContext(), android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(requireContext(), android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return
        }
        mallMap.isMyLocationEnabled = true
        fusedLocationClient.lastLocation.addOnSuccessListener { location: Location? ->
            location?.let {
                val currentLatLng = LatLng(it.latitude, it.longitude)
            }
        }
    }

    private fun requestLocationPermission() {
        ActivityCompat.requestPermissions(requireActivity(), arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION), LOCATION_PERMISSION_REQUEST_CODE)
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        if (requestCode == LOCATION_PERMISSION_REQUEST_CODE) {
            if ((grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
                enableMyLocation()
            }
        }
    }



}


