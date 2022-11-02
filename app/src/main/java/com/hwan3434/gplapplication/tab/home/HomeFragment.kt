package com.hwan3434.gplapplication.tab.home

import android.os.Bundle
import androidx.fragment.app.activityViewModels
import com.google.firebase.firestore.FirebaseFirestore
import com.hwan3434.gplapplication.GpActivity
import com.hwan3434.gplapplication.GpViewModel
import com.hwan3434.gplapplication.R
import com.hwan3434.gplapplication.appbase.mvvm.BaseFragment
import com.hwan3434.gplapplication.data.table.entity.PersonEntity
import com.hwan3434.gplapplication.databinding.FragmentHomeBinding
import com.naver.maps.geometry.LatLng
import com.naver.maps.map.CameraUpdate
import com.naver.maps.map.util.FusedLocationSource
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding, GpViewModel>(
    R.layout.fragment_home
) {

    override val viewModel: GpViewModel by activityViewModels()

    override fun initStartView(savedInstanceState: Bundle?) {

        binding.naverMapview.getMapAsync {

            it.apply {
                maxZoom = 18.0
                moveCamera(CameraUpdate.scrollTo(LatLng(37.497801, 127.027591)))
            }

        }


    }

    override fun initDataBinding() {
        viewModel.tomb.observe(viewLifecycleOwner) {

        }
    }

    override fun initAfterBinding() {
    }



}