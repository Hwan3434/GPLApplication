package com.hwan3434.gplapplication.domain.datasource

import com.hwan3434.gplapplication.domain.db.base.table.entity.PersonEntity
import kotlinx.coroutines.flow.Flow

interface PersonRoomDataSource {
    fun getPerson(): Flow<List<PersonEntity>>
}