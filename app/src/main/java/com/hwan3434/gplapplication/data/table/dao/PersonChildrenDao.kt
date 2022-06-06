package com.hwan3434.gplapplication.data.table.dao

import androidx.room.Dao
import androidx.room.Query
import com.hwan3434.gplapplication.data.baseclass.BaseDao
import com.hwan3434.gplapplication.data.table.entity.PersonChildrenEntity
import kotlinx.coroutines.flow.Flow


@Dao
interface PersonChildrenDao : BaseDao<PersonChildrenEntity> {

    @Query("SELECT * from ${PersonChildrenEntity.TABLE_NAME}")
    fun selectAll(): List<PersonChildrenEntity>
}