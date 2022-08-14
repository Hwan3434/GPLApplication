package com.hwan3434.gplapplication.data.table.datainterface

import androidx.lifecycle.LiveData
import com.hwan3434.gplapplication.data.table.entity.TombEntity

interface TombInterface {
    fun getTombAll() : LiveData<List<TombEntity>>
}