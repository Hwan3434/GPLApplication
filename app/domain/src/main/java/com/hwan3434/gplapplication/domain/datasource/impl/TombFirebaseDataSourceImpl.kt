package com.hwan3434.gplapplication.domain.datasource.impl

import android.util.Log
import com.google.firebase.firestore.FirebaseFirestore
import com.hwan3434.gplapplication.domain.datasource.TombFirebaseDataSource
import com.hwan3434.gplapplication.domain.db.base.table.entity.PersonEntity
import com.hwan3434.gplapplication.domain.db.base.table.entity.TombEntity
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.suspendCancellableCoroutine
import javax.inject.Inject
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException

class TombFirebaseDataSourceImpl @Inject constructor(
    private val firebase : FirebaseFirestore
) : TombFirebaseDataSource {

    override fun getVersion(): Flow<Int> {
        return callbackFlow {
            firebase.collection("setting")
                .document("tomb_version")
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

    override fun getTomb(): Flow<List<TombEntity>> {
        return callbackFlow {
            val temp = mutableListOf<TombEntity>()
            firebase.collection("Tomb").get().addOnSuccessListener { it1 ->
                for (doc in it1) {
                    val person: TombEntity = doc.toObject(TombEntity::class.java)
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

}