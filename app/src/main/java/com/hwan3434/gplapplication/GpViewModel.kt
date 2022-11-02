package com.hwan3434.gplapplication

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import com.google.firebase.firestore.FirebaseFirestore
import com.hwan3434.gplapplication.appbase.log.logd
import com.hwan3434.gplapplication.appbase.mvvm.BaseViewModel
import com.hwan3434.gplapplication.data.table.entity.PersonEntity
import com.hwan3434.gplapplication.data.table.entity.TombEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class GpViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val firestore : FirebaseFirestore
) : BaseViewModel() {

    private var _personData = MutableLiveData<List<PersonEntity>>()
    val person : LiveData<List<PersonEntity>> = _personData

    private var _tombData = MutableLiveData<List<TombEntity>>()
    val tomb = _tombData

    fun get(){
        firestore.collection("Person")
            .get()
            .addOnSuccessListener {
                var temp = mutableListOf<PersonEntity>()
                for (doc in it){
                    logd("person : ${doc.data}")
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
                for (doc in it){
                    logd("tomb : ${doc.data}")
                }
            }
            .addOnFailureListener {
                logd("실패 2 : $it")
            }


    }


}