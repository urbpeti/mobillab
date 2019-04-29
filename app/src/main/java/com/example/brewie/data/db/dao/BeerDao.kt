package com.example.brewie.data.db.dao

import android.arch.persistence.room.*
import com.example.brewie.data.db.entity.Beer

@Dao
interface BeerDao {
    @Query("SELECT * from beer")
    fun getBeers(): List<Beer>

    @Query("SELECT * from beer WHERE id = :id")
    fun getBeer(id : Int): Beer

    @Update
    fun updateBeer(beer: Beer)

    @Insert
    fun insert(beer: Beer)

    @Query("DELETE FROM beer")
    fun deleteAll()

    @Query("DELETE FROM beer WHERE id= :id")
    fun deleteBeer(id: Int)
}