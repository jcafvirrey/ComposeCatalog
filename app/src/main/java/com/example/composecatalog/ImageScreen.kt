package com.example.composecatalog

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalMapOf
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage


@Composable
fun MyImage(){
    Image(
        painter = painterResource(id = R.drawable.ic_launcher_background),
        contentDescription = "Imagen de Ejemplo",
        modifier = Modifier.padding(8.dp),
        alpha = 0.9f
    )
    Image(
        painter = painterResource(id = R.drawable.ic_launcher_background),
        contentDescription = "Imagen de Ejemplo",
        modifier = Modifier.padding(8.dp).clip(RoundedCornerShape(20f)),
        alpha = 0.9f
    )

    Image(
        painter = painterResource(id = R.drawable.ic_launcher_background),
        contentDescription = "Imagen de Ejemplo",
        modifier = Modifier.padding(8.dp).clip(CircleShape),
        alpha = 0.9f
    )
}

@Composable
fun MyImageCoil(){
    AsyncImage(
        model = "https://loremflickr.com/400/400/cat?lock=1",
        contentDescription = "Imagen de un gato"
    )
}

@Composable
fun MyIcon(){
    Icon(
        imageVector =  Icons.Rounded.Star,
        contentDescription = null,
        tint = Color.Red
    )
}
@Preview(showBackground = true)
@Composable
fun MyImagePreview(){
        MyIcon()
}