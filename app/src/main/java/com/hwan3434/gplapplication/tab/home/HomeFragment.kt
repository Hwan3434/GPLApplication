package com.hwan3434.gplapplication.tab.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import com.hwan3434.gplapplication.GpViewModel
import com.hwan3434.gplapplication.R
import com.hwan3434.gplapplication.appbase.mvvm.BaseFragment
import com.hwan3434.gplapplication.databinding.FragmentHomeBinding
import com.hwan3434.gplapplication.domain.db.base.table.entity.PersonEntity
import com.hwan3434.gplapplication.domain.db.base.table.entity.TombEntity
import com.naver.maps.geometry.LatLng
import com.naver.maps.map.CameraPosition
import com.naver.maps.map.NaverMap
import com.naver.maps.map.OnMapReadyCallback
import com.naver.maps.map.overlay.InfoWindow
import com.naver.maps.map.overlay.Marker
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding, GpViewModel>(
    R.layout.fragment_home,
), OnMapReadyCallback{

    override val viewModel: GpViewModel by activityViewModels()
    private val markerList = mutableListOf<Marker>()

    override fun initStartView(savedInstanceState: Bundle?) {
        binding.naverMapview.getMapAsync(this)
    }

    override fun initDataBinding() {

    }

    override fun initAfterBinding() {

    }

    override fun onMapReady(naverMap: NaverMap) {

        binding.fabBtn.setOnClickListener {
            when(naverMap.mapType){
                NaverMap.MapType.Satellite ->{
                    naverMap.mapType = NaverMap.MapType.Basic
                }
                NaverMap.MapType.Basic -> {
                    naverMap.mapType = NaverMap.MapType.Satellite
                }
                else -> {
                    naverMap.mapType = NaverMap.MapType.Satellite
                }
            }
        }

        naverMap.cameraPosition = CameraPosition(
            LatLng(36.612331, 128.349262),
            14.0
        )
        naverMap.mapType = NaverMap.MapType.Satellite


        lifecycleScope.launchWhenStarted {
            viewModel.tombData.collectLatest {
                setMarker(naverMap, it)
            }
        }

        lifecycleScope.launchWhenStarted {
            viewModel.changedCamera.collectLatest { person ->

                markerList.forEach{ m ->
                    m.infoWindow?.close()

                    val tombKey = m.tag as Int
                    if(tombKey == person.tombKey){
                        m.performClick()
                    }

                }
                if(viewModel.tombData.value.isNotEmpty()){

                    val tomb = viewModel.tombData.value.first{ tomb ->
                        tomb.tombKey == person.tombKey
                    }

                    naverMap.cameraPosition = CameraPosition(
                        LatLng(tomb.location.latitude, tomb.location.longitude),
                        16.0
                    )

                }


            }
        }

    }

    private fun setMarker(naverMap: NaverMap, tombs: List<TombEntity>) {

        for (tomb in tombs){
            val marker = createMarker(tomb)
            marker.map = naverMap
            markerList.add(marker)
        }

        naverMap.setOnMapClickListener { pointF, latLng ->
            markerList.forEach{
                it.infoWindow?.close()
            }
        }
    }


    private fun createMarker(tomb: TombEntity) : Marker{
        val marker = Marker()
        marker.position = LatLng(tomb.location.latitude, tomb.location.longitude)
        val infoWindow = createInfoWindow()

        marker.tag = tomb.tombKey

        marker.setOnClickListener {
            if (marker.infoWindow == null) {
                // 현재 마커에 정보 창이 열려있지 않을 경우 엶
                infoWindow.open(marker)
            } else {
                // 이미 현재 마커에 정보 창이 열려있을 경우 닫음
                infoWindow.close()
            }
            true
        }
        return marker
    }

    private fun createInfoWindow() : InfoWindow{

        val infoWindow = InfoWindow()
        infoWindow.setOnClickListener { it ->
            var tombKey = (it as InfoWindow).marker?.tag as Int

            var selectedPerson : PersonEntity? = null
            for (person in viewModel.personData.value){
                if(tombKey == person.tombKey){
                    selectedPerson = person
                    break
                }
            }

            selectedPerson?.let { p ->
                openPersonView(p)
            }
            true
        }
        infoWindow.adapter = object : InfoWindow.DefaultTextAdapter(context!!) {
            override fun getText(infoWindow: InfoWindow): CharSequence {

                val tombKey: Int = infoWindow.marker?.tag as Int
                var text = ""
                for (person in viewModel.personData.value){
                    if(tombKey == person.tombKey){
                        text += person.getMapTitle()+" "
                    }
                }
                return text
            }
        }
        return infoWindow
    }

    // fragment lifecycle on navermap
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.naverMapview.onCreate(savedInstanceState)
    }

    override fun onStart() {
        super.onStart()
        binding.naverMapview.onStart()
    }

    override fun onResume() {
        super.onResume()
        binding.naverMapview.onResume()
    }

    override fun onPause() {
        super.onPause()
        binding.naverMapview.onPause()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        binding.naverMapview.onSaveInstanceState(outState)
    }

    override fun onStop() {
        super.onStop()
        binding.naverMapview.onStop()
    }

    override fun onDestroy() {
        super.onDestroy()
        binding.naverMapview.onDestroy()
    }

    override fun onLowMemory() {
        super.onLowMemory()
        binding.naverMapview.onLowMemory()
    }



}