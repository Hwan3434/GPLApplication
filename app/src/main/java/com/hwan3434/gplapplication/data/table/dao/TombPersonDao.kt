package com.hwan3434.gplapplication.data.table.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.hwan3434.gplapplication.data.baseclass.BaseDao
import com.hwan3434.gplapplication.data.table.entity.TombEntity
import com.hwan3434.gplapplication.data.table.entity.TombPersonEntity
import kotlinx.coroutines.flow.Flow


@Dao
interface TombPersonDao : BaseDao<TombPersonEntity>{

    @Query("SELECT * from ${TombPersonEntity.TABLE_NAME}")
    fun selectAll(): List<TombPersonEntity>

}