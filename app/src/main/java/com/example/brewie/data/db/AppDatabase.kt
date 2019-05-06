package com.example.brewie.data.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context


import com.example.brewie.data.db.dao.BeerDao
import com.example.brewie.data.db.entity.Beer

@Database(entities = [(Beer::class)], version = 2)
abstract class AppDatabase : RoomDatabase() {

    abstract fun beerDao(): BeerDao

    companion object {
        private var INSTANCE: AppDatabase? = null

        @Synchronized
        fun getInstance(context: Context): AppDatabase {
            if (INSTANCE == null) {
                INSTANCE = Room
                    .databaseBuilder(context.applicationContext, AppDatabase::class.java, "beersexampledb")
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build()
            }
            return INSTANCE!!
        }


        fun getMemoryDatabase(
            context: Context
        ): AppDatabase {
            if (INSTANCE == null) {
                INSTANCE = Room.inMemoryDatabaseBuilder(context.applicationContext, AppDatabase::class.java)
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build()
            }
            return INSTANCE!!
        }

        fun destroyInstance() {
            INSTANCE = null
        }
    }
}