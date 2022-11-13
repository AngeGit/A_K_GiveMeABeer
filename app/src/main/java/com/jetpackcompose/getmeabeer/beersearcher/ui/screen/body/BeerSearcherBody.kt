package com.jetpackcompose.getmeabeer.beersearcher.ui.screen.body


import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import com.jetpackcompose.getmeabeer.R
import com.jetpackcompose.getmeabeer.beersearcher.data.network.response.BeersListResponse
import com.jetpackcompose.getmeabeer.beersearcher.ui.BeerSearcherViewModel
import com.jetpackcompose.getmeabeer.beersearcher.ui.screen.body.recyclerview.BeersStickyRecyclerView

@Composable
fun Body(modifier: Modifier, beerSearcherViewModel: BeerSearcherViewModel) {

    val searchText: String by beerSearcherViewModel.searchText.observeAsState(initial = "")
    BeerSearchTextField(searchText) { beerSearcherViewModel.onSearchTextChanged(it) }

    if (beerSearcherViewModel.beerList.value != null) {
        if(beerSearcherViewModel.beerList.value!!.isNotEmpty()){
            val beersStickyMap: Map<String, List<BeersListResponse>> =
                beerSearcherViewModel.beerList.value!!.groupBy { it.name.toString() }
            BeersStickyRecyclerView(beersStickyMap, beerSearcherViewModel, modifier)
        }else{
            Toast.makeText(LocalContext.current, stringResource(R.string.no_beers_in_list),Toast.LENGTH_LONG).show()
        }
    }
}



