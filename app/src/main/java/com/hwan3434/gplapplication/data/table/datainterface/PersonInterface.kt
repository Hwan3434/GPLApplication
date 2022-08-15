package com.hwan3434.gplapplication.data.table.datainterface

import com.hwan3434.gplapplication.data.table.entity.PersonEntity
import kotlinx.coroutines.flow.Flow

interface PersonInterface {

    fun getFamilyPerson() : Flow<List<PersonEntity>>

    suspend fun insert(entity : PersonEntity) : Boolean

}