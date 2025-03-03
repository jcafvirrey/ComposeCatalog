package com.example.composecatalog

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester.Companion.createRefs
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout


@Preview
@Composable
fun ConstraintBasicExample(){

    ConstraintLayout (modifier = Modifier.fillMaxSize()) {
        val (boxRed, boxBlue, boxYellow, boxMagenta) = createRefs()
        Box(modifier = Modifier.size(125.dp).background(Color.Red).constrainAs(boxRed){
            top.linkTo(parent.top)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            bottom.linkTo(parent.bottom)
        })
        Box(modifier = Modifier.size(125.dp).background(Color.Blue).constrainAs(boxBlue){})
        Box(modifier = Modifier.size(125.dp).background(Color.Yellow).constrainAs(boxYellow){
            bottom.linkTo(boxRed.top)
            end.linkTo(boxRed.start)
        })
        Box(modifier = Modifier.size(125.dp).background(Color.Magenta).constrainAs(boxMagenta){
            bottom.linkTo(boxRed.top)
            start.linkTo(boxRed.end)
        })

    }
}


