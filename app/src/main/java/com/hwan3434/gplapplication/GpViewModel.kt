package com.hwan3434.gplapplication

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.asFlow
import androidx.lifecycle.asLiveData
import com.hwan3434.gplapplication.appbase.log.logd
import com.hwan3434.gplapplication.appbase.mvvm.BaseViewModel
import com.hwan3434.gplapplication.data.table.datainterface.PersonInterface
import com.hwan3434.gplapplication.data.table.entity.PersonEntity
import com.hwan3434.gplapplication.model.Person
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GpViewModel @Inject constructor(
    private val personRepo: PersonInterface
) : BaseViewModel() {

    var personData : LiveData<List<PersonEntity>> = personRepo.getFamilyPerson().asLiveData()

    @OptIn(DelicateCoroutinesApi::class)
    fun insert(person : PersonEntity) = GlobalScope.launch(Dispatchers.IO){
            personRepo.insert(person)
    }

}