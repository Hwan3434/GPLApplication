package com.hwan3434.gplapplication.data.database

import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.hwan3434.gplapplication.appbase.log.logd

class RoomDBCallBack : RoomDatabase.Callback() {

    /**
     * db가 생성되었을 때
     */
    override fun onCreate(db: SupportSQLiteDatabase) {
        logd("onCreate Room")
        super.onCreate(db)
    }

    /**
     * db가 열렸을 때
     */
    override fun onOpen(db: SupportSQLiteDatabase) {
        logd("onOpen Room");
        super.onOpen(db)
    }


}