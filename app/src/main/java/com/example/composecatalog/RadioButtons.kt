package com.example.composecatalog

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun MyRadioButton(name: String, onItemSelected: (String) -> Unit) {

    Column(Modifier.fillMaxWidth(),) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            RadioButton(
                selected = (name == "Ejemplo 1"), onClick = {onItemSelected("Ejemplo 1") }, enabled = true
            )
            Text(
                text = "Ejemplo 1"
            )
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            RadioButton(
                selected = (name == "Ejemplo 2"), onClick = {onItemSelected("Ejemplo 2") }, enabled = true
            )
            Text(
                text = "Ejemplo 2"
            )
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            RadioButton(
                selected = (name == "Ejemplo 3"), onClick = {onItemSelected("Ejemplo 3") }, enabled = true
            )
            Text(
                text = "Ejemplo 3"
            )
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            RadioButton(
                selected = (name == "Ejemplo 4"), onClick = {onItemSelected("Ejemplo 4")}, enabled = true
            )
            Text(
                text = "Ejemplo 4"
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun MyRadioButtonPreview(){
    //MyRadioButton()
}