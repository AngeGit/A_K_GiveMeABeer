package com.jetpackcompose.getmeabeer.beerdetail.ui.screen

import android.util.Log
import androidx.compose.runtime.Composable


@Composable
fun DetailBody(detailViewModel: BeerDetailViewModel) {
    Log.d("Beer", "${detailViewModel.beer.value}")

    if (detailViewModel.beer.value != null) {
        ItemBeer(detailViewModel.beer.value!!)
    }

}

