package com.hwan3434.gplapplication.data.table.datainterface

import androidx.lifecycle.LiveData
import com.hwan3434.gplapplication.data.table.entity.PersonEntity
import com.hwan3434.gplapplication.model.Person

interface PersonInterface {

    fun getFamilyPerson() : LiveData<List<PersonEntity>>;

}