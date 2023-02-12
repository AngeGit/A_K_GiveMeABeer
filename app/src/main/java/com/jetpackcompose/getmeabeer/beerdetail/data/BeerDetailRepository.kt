package com.jetpackcompose.getmeabeer.beerdetail.data

import android.util.Log
import com.jetpackcompose.getmeabeer.beerdetail.data.network.BeerDetailService
import com.jetpackcompose.getmeabeer.beerdetail.data.network.response.BeerDetailDataResponse
import com.jetpackcompose.getmeabeer.beerdetail.ui.uimodels.BeerDetailUiData
import com.jetpackcompose.getmeabeer.beersearcher.data.network.response.BeersListDataResponse
import com.jetpackcompose.getmeabeer.beersearcher.ui.uimodels.BeerListUiResponse
import javax.inject.Inject


class BeerDetailRepository @Inject constructor(
    private val api: BeerDetailService
){
    suspend fun getBeer(id:Int): List<BeerDetailUiData>? {
        return api.getBeer(id)?.map{
            Log.d("---BeerDetailRepository---",it.name!!)
            it.toBeerDetailUiData()
        }
    }
}
//Función de extensión para convertir el modelo de datos en el modelo ui:
fun BeerDetailDataResponse.toBeerDetailUiData(): BeerDetailUiData =
    BeerDetailUiData(
        this.id,
        this.name,
        this.tagname,
        this.firstBrewed,
        this.description,
        this.imageUrl,
        this.abv,
        this.ibu
    )