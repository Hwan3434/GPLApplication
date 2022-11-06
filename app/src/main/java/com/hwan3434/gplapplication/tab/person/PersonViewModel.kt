package com.hwan3434.gplapplication.tab.person

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import com.google.firebase.firestore.FirebaseFirestore
import com.hwan3434.gplapplication.appbase.mvvm.BaseViewModel
import com.hwan3434.gplapplication.data.table.entity.PersonEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PersonViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
) : BaseViewModel() {


    private var _viewPerson = MutableLiveData<PersonEntity>()
    val viewPerson : LiveData<PersonEntity> = _viewPerson

    private var _viewFather = MutableLiveData<PersonEntity>()
    val viewFather : LiveData<PersonEntity> = _viewFather

    private var _viewMather = MutableLiveData<PersonEntity>()
    val viewMather : LiveData<PersonEntity> = _viewMather

    private var _viewSpouse = MutableLiveData<PersonEntity>()
    val viewSpouse : LiveData<PersonEntity> = _viewSpouse


    private var _viewSon = MutableLiveData<List<PersonEntity>>()
    val viewSon : LiveData<List<PersonEntity>> = _viewSon

    fun updateViewModelPerson(person: PersonEntity){
        _viewPerson.value = person
    }
    fun updateViewModelSpouse(person: PersonEntity){
        _viewSpouse.value = person
    }
    fun updateViewModelFather(person: PersonEntity){
        _viewFather.value = person
    }
    fun updateViewModelMather(person: PersonEntity){
        _viewMather.value = person
    }
    fun updateViewModelSon(person: List<PersonEntity>){
        _viewSon.value = person
    }
}