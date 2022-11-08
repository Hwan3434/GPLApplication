package com.hwan3434.gplapplication.tab.person.list

import androidx.recyclerview.widget.DiffUtil
import com.hwan3434.gplapplication.domain.db.base.table.entity.PersonEntity

class PersonSonDiff : DiffUtil.ItemCallback<PersonEntity>() {

    override fun areItemsTheSame(oldItem: PersonEntity, newItem: PersonEntity): Boolean {
        return oldItem.generator == newItem.generator
    }

    override fun areContentsTheSame(oldItem: PersonEntity, newItem: PersonEntity): Boolean {
        return oldItem.generator == newItem.generator
    }

}