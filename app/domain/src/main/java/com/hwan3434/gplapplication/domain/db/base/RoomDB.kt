package com.hwan3434.gplapplication.domain.db.base

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.hwan3434.gplapplication.domain.db.base.table.dao.PersonDao
import com.hwan3434.gplapplication.domain.db.base.table.dao.TombDao
import com.hwan3434.gplapplication.domain.db.base.table.entity.PersonEntity
import com.hwan3434.gplapplication.domain.db.base.table.entity.TombEntity


@Database(
    entities = [
        PersonEntity::class,
        TombEntity::class,
    ],
    version = 1,
    exportSchema = false
)
@TypeConverters(RoomDBConvert::class)
abstract class RoomDB : RoomDatabase() {
    abstract fun personDao(): PersonDao
    abstract fun tombDao(): TombDao
}
