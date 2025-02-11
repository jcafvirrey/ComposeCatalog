package com.example.composecatalog

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composecatalog.ui.theme.ComposeCatalogTheme

@Preview(showSystemUi = false, backgroundColor = 0xFFFFFFFF, showBackground = true)
@Composable
fun MySuperTextPreview(){
    MySuperText("Juan Carlos", modifier = Modifier)
}

@Composable
fun MySuperText(name: String, modifier: Modifier){
    Text(
        text = "Soy $name",
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
            .clickable { }
    )
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
        Text(
            text = "Hello $name!",
            modifier = modifier
        )
}

@Composable
fun GreetingPreview() {
    ComposeCatalogTheme {
        Greeting("Android")
    }
}