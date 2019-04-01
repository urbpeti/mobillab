package com.example.brewie.model

import com.google.gson.annotations.SerializedName

data class Beer(
    @SerializedName("id")
    var id: Int? = null,
    @SerializedName("name")
    var name: String? = null,
    @SerializedName("tagline")
    var tagline: String? = null,
    @SerializedName("first_brewed")
    var first_brewed: String? = null,
    @SerializedName("description")
    var description: String? = null,
    @SerializedName("image_url")
    var image_url: String? = null,
    @SerializedName("abv")
    var abv: Float? = null,
    @SerializedName("ibu")
    var ibu: Float? = null,
    @SerializedName("target_fg")
    var target_fg: Float? = null,
    @SerializedName("target_og")
    var target_og: Float? = null,
    @SerializedName("ebc")
    var ebc: Float? = null,
    @SerializedName("srm")
    var srm: Float? = null,
    @SerializedName("ph")
    var ph: Float? = null,
    @SerializedName("attenuation_level")
    var attenuation_level: Float? = null,
    @SerializedName("volume")
    var volume: Any? = null,
    @SerializedName("boil_volume")
    var boil_volume: Any? = null,
    @SerializedName("method")
    var method: Any? = null,
    @SerializedName("ingredients")
    var ingredients: Any? = null,
    @SerializedName("food_pairing")
    var food_pairing: List<String>? = null,
    @SerializedName("brewers_tips")
    var brewers_tips: String? = null,
    @SerializedName("contributed_by")
    var contributed_by: String? = null
)