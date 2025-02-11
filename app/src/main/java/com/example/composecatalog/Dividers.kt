package com.example.composecatalog

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun MyDivider() {
    HorizontalDivider(
        Modifier
            .fillMaxWidth()
            .padding(top = 10.dp, start = 10.dp),
        color = Color.Blue,
        thickness = 10.dp
    )
    VerticalDivider(
        Modifier
            .fillMaxHeight()
            .padding(top = 20.dp, start = 10.dp),
        color = Color.Red,
        thickness = 10.dp
    )
}
@Preview(showBackground = true)
@Composable
fun MyDividerPreview(){
    MyDivider()
}