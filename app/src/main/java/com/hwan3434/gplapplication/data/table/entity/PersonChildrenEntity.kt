package com.hwan3434.gplapplication.data.table.entity

import androidx.room.*
import com.hwan3434.gplapplication.data.table.entity.PersonChildrenEntity.Companion.TABLE_NAME

@Entity(tableName = TABLE_NAME, indices = [Index(value = [BaseEntity.BASE_INDEX], unique = true)])
data class PersonChildrenEntity (


// 해당키가 가진 자식
    @ColumnInfo(name = PERSON_KEY)
    val personKey: String, // 주민등록번호

    @ColumnInfo(name = CHILDREN_KEU)
    val childrenKey: String,



): BaseEntity() {

    companion object {
        const val TABLE_NAME = "PersonChildrenEntity";
        const val PERSON_KEY = "PersonKey"
        const val CHILDREN_KEU = "ChildrenKey"
    }

}
