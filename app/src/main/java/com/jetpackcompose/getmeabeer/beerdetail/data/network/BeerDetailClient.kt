package com.jetpackcompose.getmeabeer.beerdetail.data.network


import com.jetpackcompose.getmeabeer.beerdetail.data.network.response.BeerDetailDataResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface BeerDetailClient {
    @GET("beers/{id}")
    suspend fun getBeer(@Path("id") id: Int): Response<List<BeerDetailDataResponse>>
}
