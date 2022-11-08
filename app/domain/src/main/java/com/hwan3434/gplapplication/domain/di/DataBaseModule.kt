package com.hwan3434.gplapplication.domain.di

import android.content.Context
import androidx.room.Room
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.hwan3434.gplapplication.domain.db.base.RoomDB
import com.hwan3434.gplapplication.domain.db.base.RoomDBCallBack
import com.hwan3434.gplapplication.domain.db.base.table.dao.PersonDao
import com.hwan3434.gplapplication.domain.db.base.table.dao.TombDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object DataBaseModule {
    // room 으로 가져옵니다.

    // roomDB
    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext appContext: Context): RoomDB {
        return Room.databaseBuilder(
            appContext,
            RoomDB::class.java,
            "gpl.db.v1")
            .addCallback(RoomDBCallBack()) // database use callback
            .build()
    }

    private val MIGRATION_Ver_1_2 = object : Migration(1, 2) {
        override fun migrate(database: SupportSQLiteDatabase) {

        }
    }

    @Provides
    fun providePersonDao(database: RoomDB) : PersonDao {
        return database.personDao()
    }

    @Provides
    fun provideTombDao(database: RoomDB) : TombDao {
        return database.tombDao()
    }

}