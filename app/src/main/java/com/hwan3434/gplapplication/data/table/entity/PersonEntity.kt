package com.hwan3434.gplapplication.data.table.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import com.google.firebase.firestore.PropertyName
import com.hwan3434.gplapplication.data.table.entity.PersonEntity.Companion.TABLE_NAME
import java.util.*

@Entity(tableName = TABLE_NAME, indices = [Index(value = [BaseEntity.BASE_INDEX], unique = true)])
data class PersonEntity(

    @PropertyName("personKey")
    @ColumnInfo(name = PERSON_KEY)
    val personKey: String = "", // 주민등록번호

    @PropertyName("alive")
    @ColumnInfo(name = ALIVE)
    val alive: Boolean = false,

    @PropertyName("name")
    @ColumnInfo(name = NAME)
    val name: String = "",

    @PropertyName("family")
    @ColumnInfo(name = FAMILY) // 가평 이씨
    val family: String = "",

    @PropertyName("clan")
    @ColumnInfo(name = CLAN) // 사직공파
    val clan: String = "",

    @PropertyName("generator")
    @ColumnInfo(name = GMERATOR) // 39대손
    val generator: Int = 0,

    @PropertyName("gender")
    @ColumnInfo(name = GENDER)
    val gender: Boolean = false,

    @PropertyName("spouse")
    @ColumnInfo(name = SPOUSE) // 배우자
    val spouse: Int = 0,

    @PropertyName("dateDeath")
    @ColumnInfo(name = YEARMONTHDAY) // yyyyMMdd
    val dateDeath: Long = 0,

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
