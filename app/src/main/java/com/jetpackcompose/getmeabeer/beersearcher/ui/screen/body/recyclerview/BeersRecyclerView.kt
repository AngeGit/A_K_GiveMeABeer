package com.jetpackcompose.getmeabeer.beersearcher.ui.screen.body.recyclerview

import android.app.Activity
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jetpackcompose.getmeabeer.R
import com.jetpackcompose.getmeabeer.beersearcher.data.network.response.BeersListResponse
import com.jetpackcompose.getmeabeer.beersearcher.ui.BeerSearcherViewModel


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun BeersStickyRecyclerView(
    beers: Map<String, List<BeersListResponse>>,
    beerSearcherViewModel: BeerSearcherViewModel,
    modifier: Modifier
) {
    val activity: Activity = LocalContext.current as Activity

    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier.background(colorResource(id = R.color.recycler_background))
    ) {
        beers.forEach { (name, myBeer) ->
            stickyHeader {
                Text(
                    text = name,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 8.dp),
                    fontSize = 16.sp,
                    color = colorResource(id = R.color.sticky_background),
                    fontFamily = FontFamily.Monospace,
                    fontWeight = FontWeight.SemiBold
                )
            }

            items(myBeer) { myBeer ->
                PaintBeerItem (
                    beer = myBeer, modifier
                ) {
                  beerSearcherViewModel.onBeerClicked(it,activity)
                }
            }
        }
    }
}




