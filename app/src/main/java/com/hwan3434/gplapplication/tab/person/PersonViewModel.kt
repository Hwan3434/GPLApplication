package com.hwan3434.gplapplication.tab.person

import androidx.lifecycle.SavedStateHandle
import com.hwan3434.gplapplication.appbase.mvvm.BaseViewModel
import com.hwan3434.gplapplication.domain.db.base.table.entity.PersonEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class PersonViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
) : BaseViewModel() {


    private var _viewPerson = MutableStateFlow<PersonEntity>(PersonEntity())
    val viewPerson : StateFlow<PersonEntity> = _viewPerson

    private var _viewFather = MutableStateFlow<PersonEntity>(PersonEntity())
    val viewFather : StateFlow<PersonEntity> = _viewFather

    private var _viewMather = MutableStateFlow<PersonEntity>(PersonEntity())
    val viewMather : StateFlow<PersonEntity> = _viewMather

    private var _viewSpouse = MutableStateFlow<PersonEntity>(PersonEntity())
    val viewSpouse : StateFlow<PersonEntity> = _viewSpouse


    private var _viewSon = MutableStateFlow<List<PersonEntity>>(listOf())
    val viewSon : StateFlow<List<PersonEntity>> = _viewSon

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