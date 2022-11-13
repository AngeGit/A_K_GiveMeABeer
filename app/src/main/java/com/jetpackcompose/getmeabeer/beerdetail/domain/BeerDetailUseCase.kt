package com.jetpackcompose.getmeabeer.beerdetail.domain

import com.jetpackcompose.getmeabeer.beerdetail.data.BeerDetailRepository
import com.jetpackcompose.getmeabeer.beerdetail.data.network.response.BeerDetailResponse

class BeerDetailUseCase {
    private val repository = BeerDetailRepository()
    suspend operator fun invoke(id:Int): List<BeerDetailResponse>? {
        return repository.getBeer(id)
    }
}