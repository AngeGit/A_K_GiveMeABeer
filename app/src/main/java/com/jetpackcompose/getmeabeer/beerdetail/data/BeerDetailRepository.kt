package com.jetpackcompose.getmeabeer.beerdetail.data

import android.util.Log
import com.jetpackcompose.getmeabeer.beerdetail.data.network.BeerDetailService
import com.jetpackcompose.getmeabeer.beerdetail.data.network.response.BeerDetailResponse


class BeerDetailRepository {
    private val api= BeerDetailService()
    suspend fun getBeer(id:Int): List<BeerDetailResponse>? {
        var apiResponse=api.getBeer(id)
        Log.d("---BeerDetailRepository---",
            "es null= ${apiResponse==null} size:${apiResponse!!.size}")
        return apiResponse
    }
}