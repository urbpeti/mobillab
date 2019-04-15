package com.example.brewie.dao

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context

@Database(entities = [Beer::class], version = 1)
abstract class BeerRoomDatabase : RoomDatabase() {
    abstract fun beerDao(): BeerDao

    companion object {
        @Volatile
        private var INSTANCE: BeerRoomDatabase? = null

        fun getDatabase(
            context: Context
        ): BeerRoomDatabase {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(context.applicationContext, BeerRoomDatabase::class.java, "beer.db")
                    .build()
            }

            return INSTANCE!!
        }
    }
}