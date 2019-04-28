package com.example.brewie.data.db

import android.content.Context
import com.example.brewie.data.db.dao.BeerDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class DatabaseModule {
    @Provides
    @Singleton
    fun provideBeerDao(context: Context): BeerDao {
        return AppDatabase.getInstance(context).beerDao()
    }
}