package com.jetpackcompose.getmeabeer.beersearcher.data.network.response

import com.google.gson.annotations.SerializedName

data class BeersListResponse(
    @SerializedName("id") var id: Int? = null,
    @SerializedName("name") var name: String? = null,
    @SerializedName("description") var description: String? = null,
    @SerializedName("image_url") var imageUrl: String? = null
)
