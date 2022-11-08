package com.hwan3434.gplapplication.domain.impl

import com.hwan3434.gplapplication.domain.datasource.TombFirebaseDataSource
import com.hwan3434.gplapplication.domain.datasource.TombRoomDataSource
import com.hwan3434.gplapplication.domain.db.base.table.entity.TombEntity
import com.hwan3434.gplapplication.domain.repository.TombRepository
import kotlinx.coroutines.flow.Flow

class TombRepositoryImpl constructor(
    private val version: Int,
    private val tombRoomDataSource: TombRoomDataSource,
    private val tombFirebaseDataSource: TombFirebaseDataSource
) : TombRepository {

    override fun getTombAll(): Flow<List<TombEntity>> {
        return if(version >= 1) {
            tombRoomDataSource.getTomb()
        }else {
            tombFirebaseDataSource.getTomb()
        }
    }

}