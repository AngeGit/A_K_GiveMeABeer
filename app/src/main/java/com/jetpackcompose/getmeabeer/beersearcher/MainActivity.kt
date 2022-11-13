package com.jetpackcompose.getmeabeer.beersearcher

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
import com.jetpackcompose.getmeabeer.beersearcher.ui.BeerSearcherViewModel
import com.jetpackcompose.getmeabeer.beersearcher.ui.screen.BeerSearcherScreen
import com.jetpackcompose.getmeabeer.beersearcher.ui.theme.GetMeABeerTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GetMeABeerTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = colorResource(id = R.color.dark_teal)
                ) {
                    BeerSearcherScreen(BeerSearcherViewModel())
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    GetMeABeerTheme {
        BeerSearcherScreen(BeerSearcherViewModel())
    }
}