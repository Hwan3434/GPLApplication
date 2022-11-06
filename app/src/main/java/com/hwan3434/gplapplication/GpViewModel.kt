package com.hwan3434.gplapplication

import androidx.lifecycle.*
import com.google.firebase.firestore.FirebaseFirestore
import com.hwan3434.gplapplication.appbase.log.logd
import com.hwan3434.gplapplication.appbase.mvvm.BaseViewModel
import com.hwan3434.gplapplication.data.table.entity.PersonEntity
import com.hwan3434.gplapplication.data.table.entity.TombEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.combine
import javax.inject.Inject

@HiltViewModel
class GpViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val firestore : FirebaseFirestore
) : BaseViewModel() {


    private var _changedCamera = MutableLiveData<PersonEntity>()
    val changedCamera : LiveData<PersonEntity> = _changedCamera

    private var _personData = MutableLiveData<List<PersonEntity>>()
    val personData : LiveData<List<PersonEntity>> = _personData

    private var _tombData = MutableLiveData<List<TombEntity>>()
    val tombData : LiveData<List<TombEntity>> = _tombData

    fun get(){

        firestore.collection("Person")
            .get()
            .addOnSuccessListener {
                var temp = mutableListOf<PersonEntity>()
                for (doc in it){
                    val p: PersonEntity = doc.toObject(PersonEntity::class.java)
                    temp.add(p)
                }
                _personData.value = temp
            }.addOnFailureListener {
                logd("실패 : $it")
            }

        firestore.collection("Tomb")
            .get()
            .addOnSuccessListener {
                var temp = mutableListOf<TombEntity>()
                for (doc in it){
                    val t: TombEntity = doc.toObject(TombEntity::class.java)
                    temp.add(t)
                }
                _tombData.value = temp
            }
            .addOnFailureListener {
                logd("실패 2 : $it")
            }

    }

    fun updateMap(person: PersonEntity){
        _changedCamera.value = person
    }





}