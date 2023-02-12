package com.jetpackcompose.getmeabeer.beersearcher.ui

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavHostController

import com.jetpackcompose.getmeabeer.beersearcher.domain.GetBeersUseCase
import com.jetpackcompose.getmeabeer.beersearcher.ui.uimodels.BeerListUiResponse
import com.jetpackcompose.getmeabeer.core.nav.Routes
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BeerSearcherViewModel @Inject constructor(
    private val getBeers: GetBeersUseCase
): ViewModel() {
    //region navigation
    private val _navigationController= MutableLiveData<NavHostController>()
    fun setNavigationController(navigationController: NavHostController) {
        _navigationController.value=navigationController
    }
    //endregion navigation
    //region SearchBar
    private val _searchText = MutableLiveData<String>("")
    val searchText: LiveData<String> = _searchText
    fun onSearchTextChanged(text: String) {
        _searchText.value = text
        refreshBeers()
    }
    //endregion SearchBar
    //region Progressbar
    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading
    //endregion Progressbar
    //region Footer
    private val _hasSpacer = MutableLiveData<Boolean>()
    val hasSpacer: LiveData<Boolean> = _hasSpacer

    fun onFooterClick(activity: Activity) {
        val i = Intent(Intent.ACTION_VIEW)
        i.data = Uri.parse(LINKEDIN_FOOTER_URL)
        activity.startActivity(i)
    }
    //endregion Footer
    //region RecyclerView
    //Lista modificada, filtrada:
    private val _beerList = MutableLiveData<List<BeerListUiResponse>>()
    val beerList: LiveData<List<BeerListUiResponse>> = _beerList
    private fun refreshBeers() {
        _beerList.value = _beerDefaultList.value!!.filter {
            it.name!!.lowercase().startsWith(_searchText.value!!)
        }
        _hasSpacer.value = beerList.value!!.isEmpty()
    }

    //Lista control entera, no modificable, del sw:
    private val _beerDefaultList = MutableLiveData<List<BeerListUiResponse>>()
    val beerDefaultList: LiveData<List<BeerListUiResponse>> = _beerDefaultList

    fun initializeBeers() {
        viewModelScope.launch {
            _isLoading.value = true
            val list = getBeers()
            if (list != null) {
                _beerDefaultList.value = list.sortedBy { it.name }//seteamos la lista inicial
                _beerList.value = _beerDefaultList.value //seteamos la lista para modificar
            }
            _isLoading.value = false
        }
    }
    fun onBeerClicked(beer: BeerListUiResponse) {
        _navigationController.value!!.navigate(Routes.DetailScreen.createDetailScreen(beer.id!!))
    }

    //endregion RecyclerView

    companion object {
        const val LINKEDIN_FOOTER_URL= "https://www.linkedin.com/in/%C3%A1ngeles-mart%C3%ADn-fontenla-0b7937175/"
    }
}
