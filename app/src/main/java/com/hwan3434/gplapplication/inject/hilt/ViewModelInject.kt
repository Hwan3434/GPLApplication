package com.hwan3434.gplapplication.inject.hilt

import com.hwan3434.gplapplication.data.table.dao.PersonDao
import com.hwan3434.gplapplication.data.table.dao.TombDao
import com.hwan3434.gplapplication.data.table.datainterface.PersonInterface
import com.hwan3434.gplapplication.data.table.datainterface.TombInterface
import com.hwan3434.gplapplication.data.table.impl.PersonImpl
import com.hwan3434.gplapplication.data.table.impl.TombImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object ViewModelInject {

    @Provides
    fun personImpl(personDao: PersonDao): PersonInterface {
        return PersonImpl(personDao)
    }

    @Provides
    fun tombImpl(tombDao: TombDao): TombInterface {
        return TombImpl(tombDao)
    }

}