package com.hwan3434.gplapplication.domain.db.base.table.dao

import androidx.room.Dao
import androidx.room.Query
import com.hwan3434.gplapplication.domain.db.base.table.entity.TombEntity
import kotlinx.coroutines.flow.Flow


@Dao
interface TombDao : BaseDao<TombEntity>{

    @Query("SELECT * from ${TombEntity.TABLE_NAME}")
    fun selectAll(): Flow<List<TombEntity>>

}