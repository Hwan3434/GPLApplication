package com.hwan3434.gplapplication.domain.datasource.impl

import com.hwan3434.gplapplication.domain.datasource.TombRoomDataSource
import com.hwan3434.gplapplication.domain.db.base.table.dao.TombDao
import javax.inject.Inject

class TombRoomDataSourceImpl @Inject constructor(
    private val tombDao: TombDao
) : TombRoomDataSource{
    override fun getTomb() = tombDao.selectAll()
}