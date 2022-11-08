package com.hwan3434.gplapplication.domain.db.base.table.datainterface

import com.hwan3434.gplapplication.domain.db.base.table.entity.PersonEntity
import kotlinx.coroutines.flow.Flow

interface PersonInterface {
    fun getPersonList(): Flow<List<PersonEntity>>
}