package com.example.composecatalog

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalMapOf
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout

@Preview
@Composable
fun ConstraintBarrier(){

    ConstraintLayout(Modifier.fillMaxSize()) {
        val (boxRed, boxGreen, boxYellow) = createRefs()
        val barrier = createEndBarrier(boxRed, boxGreen)

        Box(modifier = Modifier
            .size(375.dp)
            .background(Color.Red)
            .constrainAs(boxRed){
                start.linkTo(parent.start, margin = 16.dp)
            })
        Box(modifier = Modifier
            .size(300.dp)
            .background(Color.Green)
            .constrainAs(boxGreen){
                top.linkTo(boxRed.bottom)
                start.linkTo(parent.start, margin = 32.dp)
            })
        Box(modifier = Modifier
            .size(50.dp)
            .background(Color.Yellow)
            .constrainAs(boxYellow){
                start.linkTo(barrier)
            }
            )
    }
}
