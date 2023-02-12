package com.jetpackcompose.getmeabeer.beerdetail.ui.uimodels

import com.google.gson.annotations.SerializedName

data class BeerDetailUiData(
    @SerializedName("id") var id: Int? = null,
    @SerializedName("name") var name: String? = null,
    @SerializedName("tagline") var tagname: String? = null,
    @SerializedName("first_brewed") var firstBrewed: String? = null,
    @SerializedName("description") var description: String? = null,
    @SerializedName("image_url") var imageUrl: String? = null,
    @SerializedName("abv") var abv: Float? = null,
    @SerializedName("ibu") var ibu: Float? = null
)
