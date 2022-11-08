package com.hwan3434.gplapplication.domain.datasource

import com.hwan3434.gplapplication.domain.db.base.table.entity.TombEntity
import kotlinx.coroutines.flow.Flow

interface TombFirebaseDataSource : BaseFirebaseDataSource {
    fun getTomb(): Flow<List<TombEntity>>
}