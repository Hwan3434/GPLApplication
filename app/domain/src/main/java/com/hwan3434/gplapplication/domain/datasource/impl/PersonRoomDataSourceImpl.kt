package com.hwan3434.gplapplication.domain.datasource.impl

import com.hwan3434.gplapplication.domain.datasource.PersonRoomDataSource
import com.hwan3434.gplapplication.domain.db.base.table.dao.PersonDao
import javax.inject.Inject

class PersonRoomDataSourceImpl @Inject constructor(
    private val personDao: PersonDao
) : PersonRoomDataSource {
    override fun getPerson() = personDao.selectAll()
}