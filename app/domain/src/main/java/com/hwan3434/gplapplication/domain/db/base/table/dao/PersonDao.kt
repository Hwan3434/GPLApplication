package com.hwan3434.gplapplication.domain.db.base.table.dao

import androidx.room.Dao
import androidx.room.Query
import com.hwan3434.gplapplication.domain.db.base.table.entity.PersonEntity
import kotlinx.coroutines.flow.Flow


@Dao
interface PersonDao : BaseDao<PersonEntity>{

    @Query("SELECT * from ${PersonEntity.TABLE_NAME}")
    fun selectAll(): Flow<List<PersonEntity>>

}