package com.hwan3434.gplapplication.domain.datasource

import kotlinx.coroutines.flow.Flow

interface BaseFirebaseDataSource {

    fun getVersion(): Flow<Int>

}