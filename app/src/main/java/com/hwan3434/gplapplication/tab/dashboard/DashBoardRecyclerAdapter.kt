package com.hwan3434.gplapplication.tab.dashboard

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.findViewTreeLifecycleOwner
import androidx.recyclerview.widget.ListAdapter
import com.hwan3434.gplapplication.appbase.log.logd
import com.hwan3434.gplapplication.data.table.entity.PersonEntity
import com.hwan3434.gplapplication.databinding.DashboardRecyclerAliveItemBinding
import com.hwan3434.gplapplication.databinding.DashboardRecyclerDeadItemBinding
import com.hwan3434.gplapplication.databinding.DashboardRecyclerUnknowItemBinding
import com.hwan3434.gplapplication.model.Person

class DashBoardRecyclerAdapter constructor(
    val lis : OnPersonClickListsner
) : ListAdapter<PersonEntity, DashBoardHolder>(DashBoardDiff()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DashBoardHolder {

        logd("view Type : $viewType" );

        when(viewType){
            0 -> {
                val binding = DashboardRecyclerAliveItemBinding.inflate(LayoutInflater.from(parent.context), parent,false)
                binding.lifecycleOwner = parent.findViewTreeLifecycleOwner()
                return DashBordersHolders.AliveHolder(binding, lis)
            }
            1 -> {
                val binding = DashboardRecyclerDeadItemBinding.inflate(LayoutInflater.from(parent.context), parent,false)
                binding.lifecycleOwner = parent.findViewTreeLifecycleOwner()
                return DashBordersHolders.DeadHolder(binding, lis)
            }
            else -> {
                val binding = DashboardRecyclerUnknowItemBinding.inflate(LayoutInflater.from(parent.context), parent,false)
                binding.lifecycleOwner = parent.findViewTreeLifecycleOwner()
                return DashBordersHolders.Unknown(binding)
            }
        }
    }

    override fun onBindViewHolder(holder: DashBoardHolder, position: Int) {
        holder.bind(getItem(position))
    }

    override fun getItemViewType(position: Int): Int {
        return if(getItem(position).alive) 0 else 1
    }

    fun insertData(data : List<PersonEntity>){
        submitList(data)
    }

    interface OnPersonClickListsner{

        fun onPersonClick(person : Person)

    }

}