package com.hwan3434.gplapplication.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.hwan3434.gplapplication.data.table.dao.PersonChildrenDao
import com.hwan3434.gplapplication.data.table.dao.PersonDao
import com.hwan3434.gplapplication.data.table.dao.TombDao
import com.hwan3434.gplapplication.data.table.dao.TombPersonDao
import com.hwan3434.gplapplication.data.table.entity.PersonChildrenEntity
import com.hwan3434.gplapplication.data.table.entity.PersonEntity
import com.hwan3434.gplapplication.data.table.entity.TombEntity
import com.hwan3434.gplapplication.data.table.entity.TombPersonEntity


@Database(
    entities = [
        PersonChildrenEntity::class,
        PersonEntity::class,
        TombEntity::class,
        TombPersonEntity::class
    ],
    version = 1,
    exportSchema = false
)

//@TypeConverters(RoomDBConvert::class)
abstract class RoomDB : RoomDatabase() {
    abstract fun personChildrenDao(): PersonChildrenDao
    abstract fun personDao(): PersonDao
    abstract fun tombPersonDao(): TombPersonDao
    abstract fun tombDao(): TombDao

}
