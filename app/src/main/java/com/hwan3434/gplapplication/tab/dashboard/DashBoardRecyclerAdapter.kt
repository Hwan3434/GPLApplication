package com.hwan3434.gplapplication.tab.dashboard

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.findViewTreeLifecycleOwner
import androidx.recyclerview.widget.ListAdapter
import com.hwan3434.gplapplication.databinding.DashboardRecyclerAliveItemBinding
import com.hwan3434.gplapplication.databinding.DashboardRecyclerDeadItemBinding
import com.hwan3434.gplapplication.databinding.DashboardRecyclerUnknowItemBinding
import com.hwan3434.gplapplication.model.Person

class DashBoardRecyclerAdapter constructor(

) : ListAdapter<Person, DashBoardHolder>(DashBoardDiff()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DashBoardHolder {

        when(viewType){
            0 -> {
                val binding = DashboardRecyclerAliveItemBinding.inflate(LayoutInflater.from(parent.context), parent,false)
                binding.lifecycleOwner = parent.findViewTreeLifecycleOwner()
                return DashBordersHolders.aliveHolder(binding)
            }
            1 -> {
                val binding = DashboardRecyclerDeadItemBinding.inflate(LayoutInflater.from(parent.context), parent,false)
                binding.lifecycleOwner = parent.findViewTreeLifecycleOwner()
                return DashBordersHolders.deadHolder(binding)
            }
            else -> {
                val binding = DashboardRecyclerUnknowItemBinding.inflate(LayoutInflater.from(parent.context), parent,false)
                binding.lifecycleOwner = parent.findViewTreeLifecycleOwner()
                return DashBordersHolders.Unknown(binding)
            }
        }
    }

    override fun onBindViewHolder(holder: DashBoardHolder, position: Int) {


    }


}