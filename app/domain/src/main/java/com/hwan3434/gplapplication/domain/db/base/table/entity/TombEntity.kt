package com.hwan3434.gplapplication.domain.db.base.table.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import com.google.firebase.firestore.GeoPoint
import com.google.firebase.firestore.PropertyName
import com.hwan3434.gplapplication.domain.db.base.table.entity.TombEntity.Companion.TABLE_NAME

@Entity(tableName = TABLE_NAME, indices = [Index(value = [BaseEntity.BASE_INDEX], unique = true)])
data class TombEntity (

    @PropertyName(TOMB_KEY)
    @ColumnInfo(name = TOMB_KEY)
    val tombKey: Int = 0,    // 묘의 아이디

    @PropertyName(TABLE_NAME)
    @ColumnInfo(name = TABLE_NAME)
    val tombName: String = "",    // 묘의 이름

    @PropertyName(LOCATION)
    @ColumnInfo(name = LOCATION)
    val location: GeoPoint = GeoPoint(37.0, 127.0)

): BaseEntity() {

    companion object {
        const val TOMB_KEY = "tombKey"
        const val TABLE_NAME = "name"
        const val LOCATION = "location"
    }

}