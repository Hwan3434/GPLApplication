package com.hwan3434.gplapplication.domain.db.base.table.dao

import androidx.room.*
import com.hwan3434.gplapplication.domain.db.base.table.entity.BaseEntity

interface BaseDao<T> where T : BaseEntity {

    @Transaction
    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun insert(baseEntity: T)

    @Transaction
    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun insert(baseEntities: List<T>)

    @Transaction
    @Update(onConflict = OnConflictStrategy.ABORT)
    fun update(baseEntity: T): Int

    @Transaction
    @Delete
    fun delete(baseEntity: T)

}