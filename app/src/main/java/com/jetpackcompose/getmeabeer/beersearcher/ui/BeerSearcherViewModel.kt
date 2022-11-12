package com.jetpackcompose.getmeabeer.beersearcher.ui

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.core.content.ContextCompat.startActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jetpackcompose.getmeabeer.beerdetail.DetailActivity
import com.jetpackcompose.getmeabeer.beersearcher.data.network.response.BeersListResponse
import com.jetpackcompose.getmeabeer.beersearcher.domain.BeerSearcherUseCase
import kotlinx.coroutines.launch


class BeerSearcherViewModel : ViewModel() {

    val beersSearcherUseCase = BeerSearcherUseCase()


    //region SearchBar
    private val _searchText = MutableLiveData<String>("")
    val searchText: LiveData<String> = _searchText

    fun onSearchTextChanged(text: String) {
        _searchText.value = text
        refreshBeers()
    }
    //endregion SearchBar

    //region RecyclerView
    //Lista modificada, filtrada:
    private val _beerList = MutableLiveData<List<BeersListResponse>>()
    val beerList: LiveData<List<BeersListResponse>> = _beerList
    private fun refreshBeers() {
        _beerList.value = _beerDefaultList.value!!.filter {
            it.name!!.toLowerCase().startsWith(_searchText.value!!)
        }
    }

    //Lista control entera, no modificable, del sw:
    private val _beerDefaultList = MutableLiveData<List<BeersListResponse>>()
    val beerDefaultList: LiveData<List<BeersListResponse>> = _beerDefaultList

    fun initializeBeers() {
        viewModelScope.launch {
            _isLoading.value = true
            val list = beersSearcherUseCase()
            if (list != null) {
                _beerDefaultList.value = list.sortedBy { it.name }//seteamos la lista inicial
                _beerList.value = _beerDefaultList.value //seteamos la lista para modificar
            }
            _isLoading.value = false
        }
    }

    fun onBeerClicked(beer: BeersListResponse, activity: Activity) {
        val intent = Intent(activity, DetailActivity::class.java)
        intent.putExtra(BEER_KEY, beer.id)
        activity.startActivity(intent)
    }
    //endregion RecyclerView

    //region Progressbar
    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading
    //endregion Progressbar
fun onFooterClick(activity: Activity){
        val url = "https://www.linkedin.com/in/%C3%A1ngeles-mart%C3%ADn-fontenla-0b7937175/"
        val i = Intent(Intent.ACTION_VIEW)
        i.data = Uri.parse(url)
        activity.startActivity(i)
}
    companion object {
        const val BEER_KEY: String = "beerId"
    }

}
