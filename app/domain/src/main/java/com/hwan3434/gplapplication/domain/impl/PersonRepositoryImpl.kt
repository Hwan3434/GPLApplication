package com.hwan3434.gplapplication.domain.impl

import com.hwan3434.gplapplication.domain.datasource.PersonFirebaseDataSource
import com.hwan3434.gplapplication.domain.datasource.PersonRoomDataSource
import com.hwan3434.gplapplication.domain.db.base.table.entity.PersonEntity
import com.hwan3434.gplapplication.domain.repository.PersonRepository
import kotlinx.coroutines.flow.Flow

class PersonRepositoryImpl constructor(
    private val version: Int,
    private val personRoomDataSource: PersonRoomDataSource,
    private val personFirebaseDataSource: PersonFirebaseDataSource
) : PersonRepository {

    override fun getPersonAll(): Flow<List<PersonEntity>> {

        return if(version >= 1) {
            personRoomDataSource.getPerson()
        }else {
            personFirebaseDataSource.getPerson()
        }

    }

}