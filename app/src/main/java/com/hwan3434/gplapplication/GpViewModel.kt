package com.hwan3434.gplapplication

import androidx.lifecycle.*
import com.hwan3434.gplapplication.appbase.mvvm.BaseViewModel
import com.hwan3434.gplapplication.domain.db.base.table.entity.PersonEntity
import com.hwan3434.gplapplication.domain.db.base.table.entity.TombEntity
import com.hwan3434.gplapplication.domain.repository.PersonRepository
import com.hwan3434.gplapplication.domain.repository.TombRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@HiltViewModel
class GpViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val personRepository: PersonRepository,
    private val tombRepository: TombRepository
) : BaseViewModel() {


    private var _changedCamera = MutableStateFlow<PersonEntity>(PersonEntity())
    val changedCamera: StateFlow<PersonEntity> = _changedCamera


    val personData: StateFlow<List<PersonEntity>> = personRepository.getPersonAll()
        .stateIn(
            initialValue = listOf(),
            started = SharingStarted.WhileSubscribed(5000),
            scope = viewModelScope,
        )

    val tombData: StateFlow<List<TombEntity>> = tombRepository.getTombAll()
        .stateIn(
            initialValue = listOf(),
            started = SharingStarted.WhileSubscribed(5000),
            scope = viewModelScope,
        )

    fun updateMap(person: PersonEntity){
        _changedCamera.value = person
    }


}