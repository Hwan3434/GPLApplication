package com.hwan3434.gplapplication.tab.dashboard.list

import android.view.LayoutInflater
import android.view.ViewGroup
import com.hwan3434.gplapplication.appbase.log.logd
import com.hwan3434.gplapplication.data.table.entity.PersonEntity
import com.hwan3434.gplapplication.databinding.DashboardRecyclerAliveItemBinding
import com.hwan3434.gplapplication.databinding.DashboardRecyclerDeadItemBinding


enum class DashBoardViewType {

    ALIVE {
        override fun createHolder(parent: ViewGroup, lis: DashBoardRecyclerAdapter.OnPersonClickListsner): BaseDashBoardHolder {
            val binding = DashboardRecyclerAliveItemBinding.inflate(LayoutInflater.from(parent.context), parent,false)
            return DashBordersHolders.AliveHolder(binding, lis)
        }
    },
    DEAD {
        override fun createHolder(parent: ViewGroup, lis: DashBoardRecyclerAdapter.OnPersonClickListsner): BaseDashBoardHolder {
            val binding = DashboardRecyclerDeadItemBinding.inflate(LayoutInflater.from(parent.context), parent,false)
            return DashBordersHolders.DeadHolder(binding, lis)
        }
    };

    abstract fun createHolder(parent: ViewGroup, lis: DashBoardRecyclerAdapter.OnPersonClickListsner): BaseDashBoardHolder

    companion object {
        fun getViewType(isAlive : Boolean) : Int {
            return if(isAlive) ALIVE.ordinal else DEAD.ordinal
        }
    }


}

object DashBordersHolders {

    class AliveHolder constructor(
        val binding : DashboardRecyclerAliveItemBinding,
        private val lis : DashBoardRecyclerAdapter.OnPersonClickListsner
    ) : BaseDashBoardHolder(binding.root) {
        override fun bind(entity: PersonEntity) {
            binding.entity = entity
            binding.aliveLayout.setOnClickListener {
                lis.onPersonClick(entity)
            }
        }
    }

    class DeadHolder constructor(
        val binding : DashboardRecyclerDeadItemBinding,
        private val lis : DashBoardRecyclerAdapter.OnPersonClickListsner
    ) : BaseDashBoardHolder(binding.root){
        override fun bind(entity: PersonEntity) {
            binding.entity = entity
            binding.deathLayout.setOnClickListener {
                lis.onPersonClick(entity)
            }
        }
    }

}