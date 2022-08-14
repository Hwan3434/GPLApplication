package com.hwan3434.gplapplication.tab.dashboard

import androidx.recyclerview.widget.DiffUtil
import com.hwan3434.gplapplication.model.Person

class DashBoardDiff : DiffUtil.ItemCallback<Person>() {

    override fun areItemsTheSame(oldItem: Person, newItem: Person): Boolean {
        return false
    }

    override fun areContentsTheSame(oldItem: Person, newItem: Person): Boolean {
        return false
    }

}