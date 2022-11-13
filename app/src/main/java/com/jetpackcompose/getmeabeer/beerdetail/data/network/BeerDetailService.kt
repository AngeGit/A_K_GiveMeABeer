package com.jetpackcompose.getmeabeer.beerdetail.data.network


import com.jetpackcompose.getmeabeer.beerdetail.data.network.response.BeerDetailResponse
import com.jetpackcompose.getmeabeer.core.network.RetrofitHelper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class BeerDetailService {

    private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun getBeer(id: Int): List<BeerDetailResponse>? {
        return withContext(Dispatchers.IO) {
            val response = retrofit.create(BeerDetailClient::class.java).getBeer(id)
            response.body()
        }
    }
}