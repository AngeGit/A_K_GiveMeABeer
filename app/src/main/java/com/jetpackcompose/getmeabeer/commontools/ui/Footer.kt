package com.jetpackcompose.getmeabeer.commontools.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jetpackcompose.getmeabeer.R

@Composable
fun Footer(

    onFooterClicked: () -> Unit,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(colorResource(id = R.color.transparent_teal)),
        verticalAlignment = Alignment.CenterVertically,

    ) {
        Column() {
            FooterDivider()
            FooterInfo(onFooterClicked)
        }
    }
}
@Composable
fun FooterDivider() {
    Divider(
        modifier = Modifier
            .background(colorResource(id = R.color.light_teal))
            .height(2.dp)
            .fillMaxWidth()
    )
}
@Composable
fun FooterInfo(onFooterClicked: () -> Unit) {
    Row(
        Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = stringResource(R.string.footer_text1),
            Modifier.padding(vertical=8.dp),
            fontSize = 12.sp,
            color = colorResource(id = R.color.white)
        )
        Text(
            text = stringResource(R.string.footer_text2),
            Modifier
                .padding(start=8.dp)
                .clickable { onFooterClicked() },
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold,
            color = colorResource(id = R.color.light_teal),
            textDecoration = TextDecoration.Underline
        )
    }
}