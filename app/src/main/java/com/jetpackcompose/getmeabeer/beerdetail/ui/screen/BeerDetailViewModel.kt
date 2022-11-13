package com.jetpackcompose.getmeabeer.beerdetail.ui.screen

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jetpackcompose.getmeabeer.beerdetail.data.network.response.BeerDetailResponse
import com.jetpackcompose.getmeabeer.beerdetail.domain.BeerDetailUseCase
import kotlinx.coroutines.launch


class BeerDetailViewModel() : ViewModel() {

    val beerDetailUseCase = BeerDetailUseCase()

    //region progressbar
    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading
    //endregion progressbar

    private val _beerList = MutableLiveData<List<BeerDetailResponse>>()//El servicio web nos lo devuelve como un []
    private val _beer = MutableLiveData<BeerDetailResponse>()
    val beer: LiveData<BeerDetailResponse> = _beer

    fun loadBeer(id: Int) {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                val beerReceived = beerDetailUseCase(id)
                if (beerReceived != null && beerReceived.isNotEmpty()) {
                    _beerList.value = beerReceived//seteamos la lista para modificar
                    _beer.value = _beerList.value!![0]
                    Log.d("BeerDetailViewModel()----------", "_beerList=${_beerList.value}")
                    Log.d("BeerDetailViewModel()----------", "_beer=${_beer.value}")
                    Log.d("BeerDetailViewModel()----------", "_beerList=${beer.value}")
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
            _isLoading.value = false
        }
    }
}