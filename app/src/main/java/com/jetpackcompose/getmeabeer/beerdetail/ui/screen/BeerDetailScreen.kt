package com.jetpackcompose.getmeabeer.beerdetail.ui.screen

import android.app.Activity
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import com.jetpackcompose.getmeabeer.R
import com.jetpackcompose.getmeabeer.commontools.ui.Header
import com.jetpackcompose.getmeabeer.commontools.ui.LoadingProgressBar

@Composable
fun BeerDetailScreen(detailViewModel: BeerDetailViewModel, recoverBeerId: Int) {
    val activity: Activity = LocalContext.current as Activity
    val isLoading: Boolean by detailViewModel.isLoading.observeAsState(initial = false)

    if (isLoading) {
        LoadingProgressBar()
    } else {
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            if (detailViewModel.beer.value == null) {//no tenemos cerveza guardada
                detailViewModel.loadBeer(recoverBeerId)//la recuperamos
            }
            if (detailViewModel.beer.value != null) {
                Header(
                    stringResource(R.string.header_title),
                    Modifier.weight(1f),
                    Icons.Default.ArrowBack
                ) { activity.finish() }
                DetailBody(detailViewModel)
            }
        }
    }
}
