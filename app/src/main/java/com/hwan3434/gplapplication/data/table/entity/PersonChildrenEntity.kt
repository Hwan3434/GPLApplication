package com.hwan3434.gplapplication.data.table.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class PersonChildrenEntity (

    // 해당키가 가진 자식

    @PrimaryKey
    val personKey: String, // 주민등록번호


    @ColumnInfo(name = "children_key")
    val childrenKey: String,









)
