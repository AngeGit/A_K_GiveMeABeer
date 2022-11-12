package com.jetpackcompose.getmeabeer.beersearcher.ui.screen.body.recyclerview

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.jetpackcompose.getmeabeer.R
import com.jetpackcompose.getmeabeer.beersearcher.data.network.response.BeersListResponse


@Composable
fun PaintBeerItem(beer: BeersListResponse, modifier:Modifier, onItemClicked: (BeersListResponse) -> Unit) {
    Card(
        modifier= Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .clickable { onItemClicked(beer) },
        elevation=10.dp
    ){
        Row(
            modifier= Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.Center
        ){
            LoadCoilImage(beer,modifier.weight(1f).background(Color.White).align(Alignment.CenterVertically))
            Column(
                modifier= Modifier
                    .fillMaxWidth()
                    .weight(2f),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                beer.description?.let { PrintBeerInfo(it, Modifier.padding(8.dp),  colorResource(id = R.color.light_teal), 16) }
            }
        }
    }
}


@Composable
fun LoadCoilImage(beer: BeersListResponse, modifier: Modifier) {
        Image(
            painter = rememberImagePainter(beer.imageUrl),
            contentDescription = beer.name,
            modifier= modifier
                .size(150.dp)
                .clip(RoundedCornerShape(50f)),
            contentScale= ContentScale.FillHeight
        )
}
@Composable
fun PrintBeerInfo(info: String, modifier: Modifier, color: Color, size:Int) {
    Text(
        text = info,
        color = color,
        fontSize= size.sp,
        modifier =modifier
    )
}
