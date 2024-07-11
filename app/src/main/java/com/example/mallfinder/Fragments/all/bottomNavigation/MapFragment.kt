package com.example.mallfinder.Fragments.all.bottomNavigation

import android.content.pm.PackageManager
import android.location.Location
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.RelativeLayout
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.navigation.fragment.findNavController
import com.example.mallfinder.R
import com.example.mallfinder.data.MallRepository
import com.example.mallfinder.databinding.FragmentMapBinding
import com.example.mallfinder.Fragments.all.detail.MallDetailFragment
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.material.bottomnavigation.BottomNavigationView

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

        //zoom buttons
        binding?.ibZoomIn?.setOnClickListener{
            mallMap.animateCamera(CameraUpdateFactory.zoomIn())
        }

        val bottomNavigationView = activity?.findViewById<BottomNavigationView>(R.id.bottomNavigation)
        bottomNavigationView?.visibility = View.VISIBLE

        binding?.ibZoomOut?.setOnClickListener{
            mallMap.animateCamera(CameraUpdateFactory.zoomOut())
        }

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
        myLocationButtonPositioning()
        initMarkers()

        mallMap.setOnMarkerClickListener { marker ->
            findNavController().navigate(
                resId = R.id.action_mapFragment_to_mallDetailFragment,
                args = marker.title?.let { MallDetailFragment.bundle(it) }
            )
            true
        }
    }

    fun initMap(){
        mallMap.isBuildingsEnabled = true
        mallMap.isIndoorEnabled = true
        val kazanCoordinates = Pair(55.7887, 49.1221)
        var startPoint = LatLng(kazanCoordinates.first, kazanCoordinates.second)
        mallMap.moveCamera(CameraUpdateFactory.newLatLngZoom(startPoint, 11.5f))
    }

    fun initMarkers(){
        MallRepository.malls.forEach(
            action =  {
                    mall->
                mallMap.addMarker(MarkerOptions()
                    .position(LatLng(mall.value.coordinates.first, mall.value.coordinates.second))
                    .title(mall.key))
            }
        )
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

    //positioning MyLocationEnabled buttons
    private fun myLocationButtonPositioning(){
        val locationButton = (childFragmentManager.findFragmentById(R.id.mallMap)?. //finding element
        view?.findViewById<View>(Integer.parseInt("1"))?.parent as View) //finding button by id
            .findViewById<View>(Integer.parseInt("2"))

        val rlp =  locationButton.layoutParams as RelativeLayout.LayoutParams //setting layout params
        rlp.addRule(RelativeLayout.ALIGN_PARENT_TOP, 0)
        rlp.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM, RelativeLayout.TRUE)
        rlp.setMargins(0, 0, 30, 30)
    }



}


