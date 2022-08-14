package com.hwan3434.gplapplication.tab.dashboard

import com.hwan3434.gplapplication.databinding.DashboardRecyclerAliveItemBinding
import com.hwan3434.gplapplication.databinding.DashboardRecyclerDeadItemBinding
import com.hwan3434.gplapplication.databinding.DashboardRecyclerUnknowItemBinding
import com.hwan3434.gplapplication.model.AlivePerson
import com.hwan3434.gplapplication.model.DeadPerson
import com.hwan3434.gplapplication.model.Person

object DashBordersHolders {

    class aliveHolder constructor(
        val binding : DashboardRecyclerAliveItemBinding
    ) : DashBoardHolder(binding.root) {
        override fun bind(entity: Person) {
            if(entity is AlivePerson){

            }
        }
    }

    class deadHolder constructor(
        val binding : DashboardRecyclerDeadItemBinding
    ) : DashBoardHolder(binding.root){
        override fun bind(entity: Person) {
            if(entity is DeadPerson){

            }
        }
    }

    class Unknown constructor(
        val binding : DashboardRecyclerUnknowItemBinding
    ) : DashBoardHolder(binding.root){
        override fun bind(entity: Person) {
        }
    }

}