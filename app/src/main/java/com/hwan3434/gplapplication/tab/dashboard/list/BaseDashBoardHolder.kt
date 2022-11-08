package com.hwan3434.gplapplication.tab.dashboard.list

import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.hwan3434.gplapplication.domain.db.base.table.entity.PersonEntity

abstract class BaseDashBoardHolder(rootView: View): RecyclerView.ViewHolder(rootView) {

    var searchText: MutableLiveData<String> = MutableLiveData()

    abstract fun bind(entity: PersonEntity)

}