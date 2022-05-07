package com.hwan3434.gplapplication.data.table.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class TombPersonKeyEntity(

    @PrimaryKey
    var tombKey:String,

    @ColumnInfo(name = "person_key")
    val personKey: String,

)
