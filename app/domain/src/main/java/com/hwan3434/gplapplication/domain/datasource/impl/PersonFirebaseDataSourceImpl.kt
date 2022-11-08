package com.hwan3434.gplapplication.domain.datasource.impl

import android.util.Log
import com.google.firebase.firestore.FirebaseFirestore
import com.hwan3434.gplapplication.domain.datasource.PersonFirebaseDataSource
import com.hwan3434.gplapplication.domain.db.base.table.entity.PersonEntity
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import javax.inject.Inject

class PersonFirebaseDataSourceImpl @Inject constructor(
    private val firebase: FirebaseFirestore
) : PersonFirebaseDataSource {

    override fun getVersion(): Flow<Int> {
        return callbackFlow {
            firebase.collection("setting")
                .document("person_version")
                .get()
                .addOnSuccessListener { it ->
                    val version = it.data?.getOrDefault("version", 0L) as Long
                    Log.d("v", "버어어어어전 2 : $version")
                    trySend(version.toInt())
                }.addOnFailureListener {

                }
            awaitClose{
                close()
            }
        }
    }


    override fun getPerson(): Flow<List<PersonEntity>> {
        return callbackFlow {
            val temp = mutableListOf<PersonEntity>()
            firebase.collection("Person")
                .get()
                .addOnSuccessListener { it1 ->
                    for (doc in it1) {
                        val person: PersonEntity = doc.toObject(PersonEntity::class.java)
                        temp.add(person)
                    }
                    trySend(temp)
                }.addOnFailureListener {

                }
            awaitClose{
                close()
            }
        }
    }



//    override fun getPersons(): Flow<List<PersonEntity>> {
//        return callbackFlow {
//            val temp = mutableListOf<PersonEntity>()
//            firebase.collection("Person")
//                .get()
//                .addOnSuccessListener { it1 ->
//                for (doc in it1) {
//                    val person: PersonEntity = doc.toObject(PersonEntity::class.java)
//                    temp.add(person)
//                }
//                trySend(temp)
//            }.addOnFailureListener {
//
//            }
//            awaitClose{
//                close()
//            }
//        }
//    }



//    override fun getPerson(): Flow<List<PersonEntity>> {
//        val temp = mutableListOf<PersonEntity>()
//        firebase.collection("Person")
//            .get()
//            .addOnSuccessListener { it1 ->
//
//                for (doc in it1) {
//                    val person: PersonEntity = doc.toObject(PersonEntity::class.java)
//                    temp.add(person)
//                }
//                Log.d("ㅇㅇ", "정환아 여기 111 역 : $temp")
//            }
//            .addOnFailureListener {
//                it.stackTrace
//            }
//
//        return temp
//
//    }

//
//    override suspend fun getPerson(): Flow<List<PersonEntity>> {
//        Log.d("244211", "안녕안ㄴ녕ㅇ아낭나ㅏㄴ아낭낭")
//        val temp = mutableListOf<PersonEntity>()
//        runBlocking {
//
//            firebase.collection("Person")
//                .get()
//                .addOnSuccessListener { it1 ->
//
//                    for (doc in it1){
//                        val person: PersonEntity = doc.toObject(PersonEntity::class.java)
//                        temp.add(person)
//                    }
//                    Log.d("ㅇㅇ", "정환아 여기 111 역 : $temp")
//                }
//                .addOnFailureListener {
//                    it.stackTrace
//                }
//
//        }
//
//        Log.d("","정환아 여기 222 역 : $temp")
//
//        return flow {
//            emit(temp)
//        }
//
//
//    }

//    FirebaseFirestore.getInstance().collection("Person")
//    .get()
//    .addOnSuccessListener {
//        var temp = mutableListOf<PersonEntity>()
//        for (doc in it){
//            val p: PersonEntity = doc.toObject(PersonEntity::class.java)
//            temp.add(p)
//        }
//        _personData.value = temp
//    }.addOnFailureListener {
//        logd("실패 : $it")
//    }


}