package com.example.brewie.dao

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query

@Dao
interface BeerDao {
    @Query("SELECT * from beer")
    fun getBeers(): LiveData<Beer>

    @Insert
    fun insert(beer: Beer)

    @Query("DELETE FROM beer")
    fun deleteAll()
}