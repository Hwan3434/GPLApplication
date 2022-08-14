package com.hwan3434.gplapplication.data.table.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.hwan3434.gplapplication.data.baseclass.BaseDao
import com.hwan3434.gplapplication.data.table.entity.PersonChildrenEntity
import com.hwan3434.gplapplication.data.table.entity.PersonEntity
import kotlinx.coroutines.flow.Flow


@Dao
interface PersonDao : BaseDao<PersonEntity>{

    @Query("SELECT * from ${PersonEntity.TABLE_NAME}")
    fun selectAll(): LiveData<List<PersonEntity>>

}