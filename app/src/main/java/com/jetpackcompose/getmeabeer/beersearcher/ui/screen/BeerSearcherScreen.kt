package com.jetpackcompose.getmeabeer.beersearcher.ui.screen

import android.app.Activity
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.jetpackcompose.getmeabeer.R
import com.jetpackcompose.getmeabeer.beersearcher.ui.BeerSearcherViewModel
import com.jetpackcompose.getmeabeer.beersearcher.ui.screen.body.Body
import com.jetpackcompose.getmeabeer.commontools.ui.Header
import com.jetpackcompose.getmeabeer.commontools.ui.LoadingProgressBar

@Composable
fun BeerSearcherScreen(beerSearcherViewModel: BeerSearcherViewModel) {

    val isLoading: Boolean by beerSearcherViewModel.isLoading.observeAsState(initial = false)
    val hasSpacer: Boolean by beerSearcherViewModel.hasSpacer.observeAsState(initial = false)
    val activity: Activity = LocalContext.current as Activity

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        if (isLoading) {
            LoadingProgressBar()
        } else {
            Header(
                stringResource(R.string.header_title),
                Modifier.weight(1f),
                Icons.Default.Close
            ) { activity.finish() }
            if (beerSearcherViewModel.beerDefaultList.value == null) {
                beerSearcherViewModel.initializeBeers()
            }
            Body(Modifier.weight(1f), beerSearcherViewModel)
            if (hasSpacer) {
                Spacer(modifier = Modifier.weight(2f))
            }
            Footer() { beerSearcherViewModel.onFooterClick(activity) }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BeerSearcherScreen(BeerSearcherViewModel())
}
