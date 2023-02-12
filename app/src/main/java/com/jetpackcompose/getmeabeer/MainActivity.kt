package com.jetpackcompose.getmeabeer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import com.jetpackcompose.getmeabeer.beerdetail.ui.screen.BeerDetailViewModel
import com.jetpackcompose.getmeabeer.beersearcher.ui.BeerSearcherViewModel
import com.jetpackcompose.getmeabeer.beersearcher.ui.theme.GetMeABeerTheme
import com.jetpackcompose.getmeabeer.core.nav.BeersNavHost
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val searcherVM: BeerSearcherViewModel by viewModels()
    private val detailVM: BeerDetailViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GetMeABeerTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = colorResource(id = R.color.dark_teal)
                ) {
                    BeersNavHost(searcherVM, detailVM)
                }
            }
        }
    }
}

/*
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    GetMeABeerTheme {
        //BeerSearcherScreen(BeerSearcherViewModel())
    }
}*/
