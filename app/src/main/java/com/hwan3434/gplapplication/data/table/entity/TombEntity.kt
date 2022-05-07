package com.hwan3434.gplapplication.data.table.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class TombEntity (

    @PrimaryKey
    val tombKey: String,    // 묘의 아이디

    @ColumnInfo(name = "lac")
    val location_Lac: Double,

    @ColumnInfo(name = "loc")
    val location_Loc: Double,

)