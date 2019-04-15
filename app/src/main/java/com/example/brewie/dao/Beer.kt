package com.example.brewie.dao

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "beer")
data class Beer(
    @PrimaryKey(autoGenerate = true) var id: Long?,
    @ColumnInfo(name = "name") var name: String,
    @ColumnInfo(name = "firstbrewed") var firstBrewed: String,
    @ColumnInfo(name = "imgurl") var imgUrl: String,
    @ColumnInfo(name = "abv") var abv: Float,
    @ColumnInfo(name = "description") var description: String
)