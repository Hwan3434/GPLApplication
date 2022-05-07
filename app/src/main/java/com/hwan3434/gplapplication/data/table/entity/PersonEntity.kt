package com.hwan3434.gplapplication.data.table.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class PersonEntity(

    @PrimaryKey
    val personKey: String, // 주민등록번호

    @ColumnInfo(name = "alive")
    val alive: Boolean,

    @ColumnInfo(name = "name")
    val name: String,

    @ColumnInfo(name = "family") // 가평 이씨
    val family: String,

    @ColumnInfo(name = "clan") // 사직공파
    val clan: String,

    @ColumnInfo(name = "generator") // 39대손
    val generator: Int,

    @ColumnInfo(name = "genader")
    val gender: Boolean,

    @ColumnInfo(name = "spouse")
    val spouse: Int,

    @ColumnInfo(name = "yearMonthDay") // yyyyMMdd
    val dateDeath: String,

    )
