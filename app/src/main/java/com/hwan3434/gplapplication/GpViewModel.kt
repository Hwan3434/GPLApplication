package com.hwan3434.gplapplication

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.hwan3434.gplapplication.appbase.mvvm.BaseViewModel
import com.hwan3434.gplapplication.data.table.datainterface.PersonInterface
import com.hwan3434.gplapplication.model.Person
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class GpViewModel @Inject constructor(
    private val personRepo: PersonInterface
) : BaseViewModel() {

    private var _person: LiveData<List<Person>> = MutableLiveData()
    var person: LiveData<List<Person>> = _person

}