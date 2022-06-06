package com.hwan3434.gplapplication.inject.hilt

import android.content.Context
import androidx.room.Room
import com.hwan3434.gplapplication.data.DataInterface
import com.hwan3434.gplapplication.data.database.RoomDB
import com.hwan3434.gplapplication.data.database.RoomDBCallBack
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object DataInject {

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

}