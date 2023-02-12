package com.jetpackcompose.getmeabeer.beerdetail.domain

import com.jetpackcompose.getmeabeer.beerdetail.data.BeerDetailRepository
import com.jetpackcompose.getmeabeer.beerdetail.data.network.response.BeerDetailDataResponse
import com.jetpackcompose.getmeabeer.beerdetail.ui.uimodels.BeerDetailUiData
import javax.inject.Inject

class GetBeerUseCase @Inject constructor(private val repository: BeerDetailRepository) {
    suspend operator fun invoke(id:Int): List<BeerDetailUiData>? {
        return repository.getBeer(id)
    }
}