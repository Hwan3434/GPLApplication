package com.hwan3434.gplapplication.domain.repository

import com.hwan3434.gplapplication.domain.db.base.table.entity.PersonEntity
import kotlinx.coroutines.flow.Flow

interface PersonRepository{
    fun getPersonAll() : Flow<List<PersonEntity>>
}