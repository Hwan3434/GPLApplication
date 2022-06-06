package com.hwan3434.gplapplication.data.table.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.hwan3434.gplapplication.data.baseclass.BaseDao
import com.hwan3434.gplapplication.data.table.entity.PersonEntity
import com.hwan3434.gplapplication.data.table.entity.TombEntity
import kotlinx.coroutines.flow.Flow


@Dao
interface TombDao : BaseDao<TombEntity>{

    @Query("SELECT * from ${TombEntity.TABLE_NAME}")
    fun selectAll(): List<TombEntity>

}