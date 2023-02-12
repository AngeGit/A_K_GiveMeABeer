package com.jetpackcompose.getmeabeer.beerdetail.data.network


import com.jetpackcompose.getmeabeer.beerdetail.data.network.response.BeerDetailDataResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class BeerDetailService @Inject constructor(
    private val beerDetailClient:BeerDetailClient
){
    suspend fun getBeer(id: Int): List<BeerDetailDataResponse>? {
        return withContext(Dispatchers.IO) {
            val response = beerDetailClient.getBeer(id)
            response.body()
        }
    }
}