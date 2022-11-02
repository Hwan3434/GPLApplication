package com.hwan3434.gplapplication.data.table.impl

import androidx.lifecycle.LiveData
import com.hwan3434.gplapplication.data.table.dao.PersonDao
import com.hwan3434.gplapplication.data.table.datainterface.PersonInterface
import com.hwan3434.gplapplication.data.table.entity.PersonEntity
import com.hwan3434.gplapplication.model.Person
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PersonImpl @Inject constructor(
    private val personDao: PersonDao
) : PersonInterface{

    override fun getFamilyPerson(): Flow<List<PersonEntity>> {
        return personDao.selectAll()
    }

    override suspend fun insert(entity: PersonEntity) : Boolean {
        personDao.insert(entity)
        return true
    }

}