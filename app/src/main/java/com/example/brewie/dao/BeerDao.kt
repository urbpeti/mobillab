package com.example.brewie.dao

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import android.arch.persistence.room.Update

@Dao
interface BeerDao {
    @Query("SELECT * from beer")
    fun getBeers(): LiveData<Beer>

    @Query("SELECT * from beer WHERE id = :id")
    fun getBeer(id : Int): Beer

    @Update
    fun updateBeer(beer: Beer)

    @Insert
    fun insert(beer: Beer)

    @Query("DELETE FROM beer")
    fun deleteAll()
}