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
    personRepository: PersonRepository,
    tombRepository: TombRepository
) : BaseViewModel() {


    private var _changedCamera = MutableStateFlow<PersonEntity>(PersonEntity())
    val changedCamera: StateFlow<PersonEntity> = _changedCamera


    private val personData: Flow<List<PersonEntity>> = personRepository.getPersonAll()
    private val tombData: Flow<List<TombEntity>> = tombRepository.getTombAll()

    val allInfo: StateFlow<uiInfo> =
        combine(
            personData,
            tombData
        ){ p, t ->
            uiInfo(p, t)
        }.stateIn(
            initialValue = uiInfo(listOf(), listOf()),
            started = SharingStarted.WhileSubscribed(5000),
            scope = viewModelScope,
        )

    // 통일된 하나의 stateflow 만들어야합니다~~
    // 지금은 안해놓음 result success, error 만들고 success 일떄 하는 걸로
    //

    fun updateMap(person: PersonEntity){
        _changedCamera.value = person
    }


}

data class uiInfo (
    val persons : List<PersonEntity>,
    val tomb : List<TombEntity>
)