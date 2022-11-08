package com.hwan3434.gplapplication.domain.db.base

import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase

class RoomDBCallBack : RoomDatabase.Callback() {

    /**
     * db가 생성되었을 때
     */
    override fun onCreate(db: SupportSQLiteDatabase) {
        super.onCreate(db)
    }

    /**
     * db가 열렸을 때
     */
    override fun onOpen(db: SupportSQLiteDatabase) {
        super.onOpen(db)
    }


}