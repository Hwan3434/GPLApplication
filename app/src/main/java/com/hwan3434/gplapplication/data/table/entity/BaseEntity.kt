package com.hwan3434.gplapplication.data.table.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

abstract class BaseEntity {


    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = BASE_INDEX)
    var localIndex: Long = 0

    @ColumnInfo(name = BASE_DESC)
    var description: String? = null

    @ColumnInfo(name = BASE_CREATE_AT)
    var createAt: Long = System.currentTimeMillis()

    @ColumnInfo(name = BASE_MODIFY_AT)
    var modificationAt: Long = 0


    companion object {
        const val BASE_INDEX: String = "localIndex"
        const val BASE_CREATE_AT: String = "create_at"
        const val BASE_MODIFY_AT: String = "modify_at"
        const val BASE_DESC: String = "description"
    }

}