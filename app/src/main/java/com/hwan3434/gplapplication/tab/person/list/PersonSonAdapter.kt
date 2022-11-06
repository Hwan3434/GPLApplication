package com.hwan3434.gplapplication.tab.person.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.hwan3434.gplapplication.data.table.entity.PersonEntity
import com.hwan3434.gplapplication.databinding.DashboardRecyclerDeadItemBinding
import com.hwan3434.gplapplication.databinding.PersonRecyclerSonBinding
import com.hwan3434.gplapplication.tab.dashboard.list.DashBordersHolders

class PersonSonAdapter(
    private val lis: OnSonClickListsner
) : ListAdapter<PersonEntity, PersonSonAdapter.SonViewHolder>(PersonSonDiff()) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SonViewHolder {
        val binding = PersonRecyclerSonBinding.inflate(LayoutInflater.from(parent.context), parent,false)
        return SonViewHolder(binding, lis)
    }

    override fun onBindViewHolder(holder: SonViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    fun insertData(data : List<PersonEntity>){
        submitList(data)
    }

    inner class SonViewHolder(
        private val binding: PersonRecyclerSonBinding,
        private val lis: OnSonClickListsner
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(person: PersonEntity){
            binding.entity = person
            binding.sonView.setOnClickListener {
                lis.onSonClick(person)
            }
        }
    }

    interface OnSonClickListsner {

        fun onSonClick(person: PersonEntity)

    }


}