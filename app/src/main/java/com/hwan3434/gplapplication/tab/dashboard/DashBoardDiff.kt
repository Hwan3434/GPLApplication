package com.hwan3434.gplapplication.tab.dashboard

import androidx.recyclerview.widget.DiffUtil
import com.hwan3434.gplapplication.data.table.entity.PersonEntity
import com.hwan3434.gplapplication.model.Person

class DashBoardDiff : DiffUtil.ItemCallback<PersonEntity>() {

    override fun areItemsTheSame(oldItem: PersonEntity, newItem: PersonEntity): Boolean {
        return false
    }

    override fun areContentsTheSame(oldItem: PersonEntity, newItem: PersonEntity): Boolean {
        return false
    }

}