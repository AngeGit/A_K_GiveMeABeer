package com.jetpackcompose.getmeabeer.beersearcher.domain

import com.jetpackcompose.getmeabeer.beersearcher.data.BeerSearcherRepository
import com.jetpackcompose.getmeabeer.beersearcher.data.network.response.BeersListResponse


class BeerSearcherUseCase { //Caso de uso que usa el viewModel
    val repository = BeerSearcherRepository()
    suspend operator fun invoke(): List<BeersListResponse>? {
        return repository.getBeers()
    }
}