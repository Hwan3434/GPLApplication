package com.hwan3434.gplapplication.data.baseclass

import androidx.room.Delete
import androidx.room.Insert

interface BaseDao<T> {

    @Insert
    fun insert(vararg obj:T)

    @Delete
    fun delete(obj:T)

    


}