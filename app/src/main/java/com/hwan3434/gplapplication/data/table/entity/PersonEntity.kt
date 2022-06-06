package com.hwan3434.gplapplication.data.table.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import com.hwan3434.gplapplication.data.table.entity.PersonEntity.Companion.TABLE_NAME

@Entity(tableName = TABLE_NAME, indices = [Index(value = [BaseEntity.BASE_INDEX], unique = true)])
data class PersonEntity(

    @ColumnInfo(name = PERSON_KEY)
    val personKey: String, // 주민등록번호

    @ColumnInfo(name = ALIVE)
    val alive: Boolean,

    @ColumnInfo(name = NAME)
    val name: String,

    @ColumnInfo(name = FAMILY) // 가평 이씨
    val family: String,

    @ColumnInfo(name = CLAN) // 사직공파
    val clan: String,

    @ColumnInfo(name = GMERATOR) // 39대손
    val generator: Int,

    @ColumnInfo(name = GENDER)
    val gender: Boolean,

    @ColumnInfo(name = SPOUSE) // 배우자
    val spouse: Int,

    @ColumnInfo(name = YEARMONTHDAY) // yyyyMMdd
    val dateDeath: String,

    ): BaseEntity() {

    companion object {
        const val TABLE_NAME = "PersonEntity"
        const val PERSON_KEY = "PersonKey"
        const val ALIVE = "alive"
        const val NAME = "name"
        const val FAMILY = "family"
        const val CLAN = "clan"
        const val GMERATOR = "generator"
        const val GENDER = "genader"
        const val SPOUSE = "spouse"
        const val YEARMONTHDAY = "yearMonthDay"
    }
}
