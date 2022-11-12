package com.jetpackcompose.getmeabeer.beersearcher.data.network

import com.jetpackcompose.getmeabeer.beersearcher.data.network.response.BeersListResponse
import retrofit2.Response
import retrofit2.http.GET

interface BeerSearcherClient {
@GET("beers")
    suspend fun getBeers():Response<List<BeersListResponse>>
}