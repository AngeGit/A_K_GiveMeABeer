package com.jetpackcompose.getmeabeer.beersearcher.data

import com.jetpackcompose.getmeabeer.beersearcher.data.network.BeerSearcherService
import com.jetpackcompose.getmeabeer.beersearcher.data.network.response.BeersListDataResponse
import com.jetpackcompose.getmeabeer.beersearcher.ui.uimodels.BeerListUiResponse
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class BeerSearcherRepository @Inject constructor(private val api:BeerSearcherService) {
    suspend fun getBeers (): List<BeerListUiResponse>? {
        return api.getBeers()?.map {
            it.toBeerListUiDataResponse()
        }
    }
}
//Funciones de extensión para convertir el modelo de datos en el modelo ui:
fun BeersListDataResponse.toBeerListUiDataResponse(): BeerListUiResponse= BeerListUiResponse(this.id,this.name,this.description,this.imageUrl)
