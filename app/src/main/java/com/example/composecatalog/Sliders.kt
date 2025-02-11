package com.example.composecatalog

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun MyBasicSlider(){
    Column(horizontalAlignment = Alignment.CenterHorizontally){
        var sliderPosition by remember{ mutableStateOf(0f) }
        Slider(value = sliderPosition, onValueChange = {sliderPosition = it})
        Text(text = sliderPosition.toString())
    }
}
@Composable
fun MyAdvanceSlider(){
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        var sliderPosition by remember { mutableStateOf(0f) }
        var completeValue by remember { mutableStateOf("") }
        Slider(
            value = sliderPosition,
            onValueChange = {sliderPosition = it},
            onValueChangeFinished = {completeValue = sliderPosition.toString()},
            valueRange = 0f ..10f,
            steps = 9
        )
        Text(text = completeValue.toString())
    }
}



@Preview(showBackground = true)
@Composable
fun MySlidersPreview(){
    //MyBasicSlider()
    MyAdvanceSlider()
}