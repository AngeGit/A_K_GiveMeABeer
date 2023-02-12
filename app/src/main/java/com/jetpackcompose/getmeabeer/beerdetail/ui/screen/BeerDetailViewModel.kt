package com.jetpackcompose.getmeabeer.beerdetail.ui.screen

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavHostController
import com.jetpackcompose.getmeabeer.beerdetail.data.network.response.BeerDetailDataResponse
import com.jetpackcompose.getmeabeer.beerdetail.domain.GetBeerUseCase
import com.jetpackcompose.getmeabeer.beerdetail.ui.uimodels.BeerDetailUiData
import com.jetpackcompose.getmeabeer.core.nav.Routes
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BeerDetailViewModel @Inject constructor(
    private val getBeerUseCase:GetBeerUseCase
) : ViewModel() {
    //region progressbar
    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading
    //endregion progressbar
    //region navigation
    private val _navigationController= MutableLiveData<NavHostController>()
    fun setNavigationController(navigationController: NavHostController) {
        _navigationController.value=navigationController
    }
    //endregion navigation
    private val _beerList = MutableLiveData<List<BeerDetailUiData>>()//El servicio web nos lo devuelve como un []
    private val _beer = MutableLiveData<BeerDetailUiData>()
    val beer: LiveData<BeerDetailUiData> = _beer

    fun loadBeer(id: Int) {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                val beerReceived = getBeerUseCase(id)
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

    fun goBack() {
        _navigationController.value!!.navigate(Routes.SearcherScreen.route)
    }
}