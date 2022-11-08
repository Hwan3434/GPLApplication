package com.hwan3434.gplapplication.domain.db.base.table.datainterface

import com.hwan3434.gplapplication.domain.db.base.table.entity.TombEntity
import kotlinx.coroutines.flow.Flow

interface TombInterface {
    fun getTombList() : Flow<List<TombEntity>>
}