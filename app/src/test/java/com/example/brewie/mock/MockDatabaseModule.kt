package com.example.brewie.mock

import android.content.Context
import com.example.brewie.data.db.dao.BeerDao
import com.example.brewie.utils.mock
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class MockDatabaseModule {
    @Provides
    @Singleton
    fun provideBeerDao(context: Context): BeerDao {
        return mock()
    }
}
