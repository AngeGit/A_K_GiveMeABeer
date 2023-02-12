package com.jetpackcompose.getmeabeer.beersearcher.domain

import com.jetpackcompose.getmeabeer.beersearcher.data.BeerSearcherRepository
import com.jetpackcompose.getmeabeer.beersearcher.ui.uimodels.BeerListUiResponse
import javax.inject.Inject


class GetBeersUseCase @Inject constructor(private val repository: BeerSearcherRepository) {
    suspend operator fun invoke(): List<BeerListUiResponse>? {
        return repository.getBeers()
    }
}