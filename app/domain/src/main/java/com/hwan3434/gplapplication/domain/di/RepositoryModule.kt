package com.hwan3434.gplapplication.domain.di

import android.content.Context
import androidx.lifecycle.asLiveData
import com.google.firebase.firestore.FirebaseFirestore
import com.hwan3434.gplapplication.domain.datasource.PersonFirebaseDataSource
import com.hwan3434.gplapplication.domain.datasource.PersonRoomDataSource
import com.hwan3434.gplapplication.domain.datasource.TombFirebaseDataSource
import com.hwan3434.gplapplication.domain.datasource.TombRoomDataSource
import com.hwan3434.gplapplication.domain.datasource.impl.PersonFirebaseDataSourceImpl
import com.hwan3434.gplapplication.domain.datasource.impl.PersonRoomDataSourceImpl
import com.hwan3434.gplapplication.domain.datasource.impl.TombFirebaseDataSourceImpl
import com.hwan3434.gplapplication.domain.datasource.impl.TombRoomDataSourceImpl
import com.hwan3434.gplapplication.domain.db.base.table.dao.PersonDao
import com.hwan3434.gplapplication.domain.db.base.table.dao.TombDao
import com.hwan3434.gplapplication.domain.impl.PersonRepositoryImpl
import com.hwan3434.gplapplication.domain.impl.TombRepositoryImpl
import com.hwan3434.gplapplication.domain.repository.PersonRepository
import com.hwan3434.gplapplication.domain.repository.TombRepository
import com.hwan3434.gplapplication.domain.util.PreferenceManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.flow.first
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {


    // 이렇게 나누는게 아니다
    // 다른구조로
    /**
     *
     * <DataSource>로 만들자
     * 그리고 <firebaseDataSource>로 통일하자
     *
     *
     */
    @Provides
    @Singleton
    fun providerPersonRepository(
        preferenceManager: PreferenceManager,
        personRoomDataSource: PersonRoomDataSource,
        personFirebaseDataSource: PersonFirebaseDataSource
    ): PersonRepository {
        return PersonRepositoryImpl(preferenceManager.gplVersion, personRoomDataSource, personFirebaseDataSource)
    }


    @Provides
    @Singleton
    fun providerTombRepository(
        preferenceManager: PreferenceManager,
        tombRoomDataSource: TombRoomDataSource,
        tombFirebaseDataSource: TombFirebaseDataSource
    ): TombRepository {
        return TombRepositoryImpl(preferenceManager.gplVersion, tombRoomDataSource, tombFirebaseDataSource)
    }


    @Provides
    @Singleton
    fun providerPersonRoomDataSource(personDao: PersonDao) : PersonRoomDataSource
            = PersonRoomDataSourceImpl(personDao)

    @Provides
    @Singleton
    fun providerPersonFirebaseDataSource(firebase: FirebaseFirestore) : PersonFirebaseDataSource
            = PersonFirebaseDataSourceImpl(firebase)

    @Provides
    @Singleton
    fun providerTombRoomDataSource(tombDao: TombDao) : TombRoomDataSource
            = TombRoomDataSourceImpl(tombDao)

    @Provides
    @Singleton
    fun providerTombFirebaseDataSource(firebase: FirebaseFirestore) : TombFirebaseDataSource
            = TombFirebaseDataSourceImpl(firebase)

    @Provides
    @Singleton
    fun providerFirebase() : FirebaseFirestore
            = FirebaseFirestore.getInstance()

    @Provides
    @Singleton
    fun providerPreferenceManager(@ApplicationContext context: Context) : PreferenceManager
            = PreferenceManager(context)




}