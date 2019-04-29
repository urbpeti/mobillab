package com.example.brewie.model

import com.google.gson.annotations.SerializedName

data class Beer(
    @SerializedName("id")
    var id: Int? = null,
    @SerializedName("name")
    var name: String? = null,
    @SerializedName("first_brewed")
    var first_brewed: String? = null,
    @SerializedName("description")
    var description: String? = null,
    @SerializedName("image_url")
    var image_url: String? = null,
    @SerializedName("abv")
    var abv: Float? = null,
    @SerializedName("isMock")
    var isMock: Boolean? = null
)