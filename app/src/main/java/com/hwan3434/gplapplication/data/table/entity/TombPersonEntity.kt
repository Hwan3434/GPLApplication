package com.hwan3434.gplapplication.data.table.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import com.hwan3434.gplapplication.data.table.entity.TombPersonEntity.Companion.TABLE_NAME

@Entity(tableName = TABLE_NAME, indices = [Index(value = [BaseEntity.BASE_INDEX], unique = true)])
data class TombPersonEntity(

    @ColumnInfo(name = TOMB_KEY)
    var tombKey:String,

    @ColumnInfo(name = PERSON_KEY)
    val personKey: String,

): BaseEntity() {

    companion object {
        const val TABLE_NAME = "TombPersonEntity";
        const val TOMB_KEY = "TombKey"
        const val PERSON_KEY = "PersonKey"
    }
}
