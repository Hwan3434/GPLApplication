package com.hwan3434.gplapplication.tab.dashboard

import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.hwan3434.gplapplication.model.Person

abstract class DashBoardHolder(rootView: View): RecyclerView.ViewHolder(rootView) {

    var searchText: MutableLiveData<String> = MutableLiveData()

    abstract fun bind(entity: Person)

}