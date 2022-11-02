package com.hwan3434.gplapplication.tab.dashboard

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.hwan3434.gplapplication.data.table.entity.PersonEntity
import com.hwan3434.gplapplication.model.Person

class DashBoardRecyclerAdapter constructor(
    val lis : OnPersonClickListsner
) : ListAdapter<PersonEntity, BaseDashBoardHolder>(DashBoardDiff()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseDashBoardHolder {
        return DashBoardViewType.values()[viewType].createHolder(parent, lis)
    }

    override fun onBindViewHolder(holder: BaseDashBoardHolder, position: Int) {
        holder.bind(getItem(position))
    }

    override fun getItemViewType(position: Int): Int {
        return DashBoardViewType.getViewType(getItem(position).alive)
    }

    fun insertData(data : List<PersonEntity>){
        submitList(data)
    }

    interface OnPersonClickListsner{

        fun onPersonClick(person : PersonEntity)

    }

}