package com.example.brewie.model

import com.google.gson.annotations.SerializedName

data class Item(
    @SerializedName("uri")
    var uri: String? = null
)
