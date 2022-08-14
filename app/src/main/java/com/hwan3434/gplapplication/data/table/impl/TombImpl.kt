package com.hwan3434.gplapplication.data.table.impl

import androidx.lifecycle.LiveData
import com.hwan3434.gplapplication.data.table.dao.PersonDao
import com.hwan3434.gplapplication.data.table.dao.TombDao
import com.hwan3434.gplapplication.data.table.datainterface.PersonInterface
import com.hwan3434.gplapplication.data.table.datainterface.TombInterface
import com.hwan3434.gplapplication.data.table.entity.PersonEntity
import com.hwan3434.gplapplication.data.table.entity.TombEntity
import javax.inject.Inject

class TombImpl @Inject constructor(
    private val tombDao: TombDao
) : TombInterface {

    override fun getTombAll(): LiveData<List<TombEntity>> {
        return tombDao.selectAll()
    }


}