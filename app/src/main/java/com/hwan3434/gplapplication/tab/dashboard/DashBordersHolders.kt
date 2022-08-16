package com.hwan3434.gplapplication.tab.dashboard

import com.hwan3434.gplapplication.data.table.entity.PersonEntity
import com.hwan3434.gplapplication.databinding.DashboardRecyclerAliveItemBinding
import com.hwan3434.gplapplication.databinding.DashboardRecyclerDeadItemBinding
import com.hwan3434.gplapplication.databinding.DashboardRecyclerUnknowItemBinding
import com.hwan3434.gplapplication.model.AlivePerson
import com.hwan3434.gplapplication.model.DeadPerson
import com.hwan3434.gplapplication.model.Person

object DashBordersHolders {

    class AliveHolder constructor(
        val binding : DashboardRecyclerAliveItemBinding,
        val lis : DashBoardRecyclerAdapter.OnPersonClickListsner
    ) : DashBoardHolder(binding.root) {
        override fun bind(entity: PersonEntity) {
        }
    }

    class DeadHolder constructor(
        val binding : DashboardRecyclerDeadItemBinding,
        val lis : DashBoardRecyclerAdapter.OnPersonClickListsner
    ) : DashBoardHolder(binding.root){
        override fun bind(entity: PersonEntity) {
        }
    }

    class Unknown constructor(
        val binding : DashboardRecyclerUnknowItemBinding
    ) : DashBoardHolder(binding.root){
        override fun bind(entity: PersonEntity) {
        }
    }

}