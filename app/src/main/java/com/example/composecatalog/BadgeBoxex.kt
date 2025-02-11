package com.example.composecatalog

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun MyBadgeBox(){
    BadgedBox(modifier = Modifier.padding(24.dp),
        badge = {
            Badge(
                containerColor = Color.Blue,
                contentColor = Color.Green
            ){
                Text(text = "10")
            }
        }) {
        Icon(imageVector = Icons.Default.Star, contentDescription = "Start")
    }
}
@Preview(showBackground = true)
@Composable
fun MyBadgeBoxPreview(){
    MyBadgeBox()
}

