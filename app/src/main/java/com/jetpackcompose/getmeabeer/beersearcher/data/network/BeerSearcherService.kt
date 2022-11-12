package com.jetpackcompose.getmeabeer.beersearcher.data.network

import com.jetpackcompose.getmeabeer.beersearcher.data.network.response.BeersListResponse
import com.jetpackcompose.getmeabeer.core.network.RetrofitHelper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class BeerSearcherService {
    private val retrofit= RetrofitHelper.getRetrofit()

    suspend fun getBeers():List<BeersListResponse>?{
     return withContext(Dispatchers.IO){
           val response= retrofit.create(BeerSearcherClient::class.java).getBeers()
            response.body()
        }
    }
}