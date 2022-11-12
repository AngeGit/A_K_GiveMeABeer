package com.jetpackcompose.getmeabeer.beersearcher.data

import com.jetpackcompose.getmeabeer.beersearcher.data.network.BeerSearcherService
import com.jetpackcompose.getmeabeer.beersearcher.data.network.response.BeersListResponse


class BeerSearcherRepository {
    private val api= BeerSearcherService()
    suspend fun getBeers (): List<BeersListResponse>? {
        return api.getBeers()
    }
}