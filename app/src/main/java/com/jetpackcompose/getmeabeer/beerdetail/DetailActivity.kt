package com.jetpackcompose.getmeabeer.beerdetail

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import com.jetpackcompose.getmeabeer.R
import com.jetpackcompose.getmeabeer.beerdetail.ui.screen.BeerDetailScreen
import com.jetpackcompose.getmeabeer.beerdetail.ui.screen.BeerDetailViewModel
import com.jetpackcompose.getmeabeer.beerdetail.ui.theme.GetMeABeerTheme
import com.jetpackcompose.getmeabeer.beersearcher.ui.BeerSearcherViewModel

class DetailActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GetMeABeerTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = colorResource(id = R.color.dark_teal)
                ) {
                    BeerDetailScreen(BeerDetailViewModel(),recoverBeerId())
                }
            }
        }
    }

    fun recoverBeerId(): Int {
        return intent.extras!!.getInt(BeerSearcherViewModel.BEER_KEY)
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    GetMeABeerTheme {
        BeerDetailScreen(BeerDetailViewModel(), 129)
    }
}