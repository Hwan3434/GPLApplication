package com.hwan3434.gplapplication.data.table.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import com.hwan3434.gplapplication.data.table.entity.TombEntity.Companion.TABLE_NAME

@Entity(tableName = TABLE_NAME, indices = [Index(value = [BaseEntity.BASE_INDEX], unique = true)])
data class TombEntity (

    @ColumnInfo(name = TOMB_KEY)
    val tombKey: String,    // 묘의 아이디

    @ColumnInfo(name = LAC)
    val location_Lac: Double,

    @ColumnInfo(name = LOC)
    val location_Loc: Double,

): BaseEntity() {

    companion object {
        const val TABLE_NAME = "TombEntity";
        const val TOMB_KEY = "TombKey"
        const val LAC = "lac"
        const val LOC = "loc"
    }

}