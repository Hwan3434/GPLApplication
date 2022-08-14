package com.hwan3434.gplapplication.data.table.impl

import androidx.lifecycle.LiveData
import com.hwan3434.gplapplication.data.table.dao.PersonDao
import com.hwan3434.gplapplication.data.table.datainterface.PersonInterface
import com.hwan3434.gplapplication.data.table.entity.PersonEntity
import com.hwan3434.gplapplication.model.Person
import javax.inject.Inject

class PersonImpl @Inject constructor(
    private val personDao: PersonDao
) : PersonInterface{

    override fun getFamilyPerson(): LiveData<List<PersonEntity>> {
        return personDao.selectAll()
    }


}