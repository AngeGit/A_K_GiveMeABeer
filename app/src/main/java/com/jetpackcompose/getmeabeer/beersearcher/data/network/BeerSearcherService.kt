package com.jetpackcompose.getmeabeer.beersearcher.data.network

import com.jetpackcompose.getmeabeer.beersearcher.data.network.response.BeersListDataResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class BeerSearcherService @Inject constructor(private val beerSearcherClient:BeerSearcherClient) {
    suspend fun getBeers():List<BeersListDataResponse>?{
     return withContext(Dispatchers.IO){
           val response=beerSearcherClient.getBeers()
            response.body()
        }
    }
}