package com.hwan3434.gplapplication.tab.dashboard

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.hwan3434.gplapplication.appbase.mvvm.BaseViewModel

class DashboardViewModel : BaseViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is dashboard Fragment"
    }
    val text: LiveData<String> = _text
}