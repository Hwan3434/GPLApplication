package com.hwan3434.gplapplication.domain.repository

import com.hwan3434.gplapplication.domain.db.base.table.entity.TombEntity
import kotlinx.coroutines.flow.Flow

interface TombRepository {
    fun getTombAll(): Flow<List<TombEntity>>
}