package com.example.composecatalog

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun MyText(name: String, modifier: Modifier){
    Column(Modifier.fillMaxSize()){
        Text(text = "Esto es un ejemplo en $name")
        Text(text = "Esto es un ejemplo en $name", color= Color.Red)
        Text(text = "Esto es un ejemplo en $name", fontWeight = FontWeight.Bold)
        Text(text = "Esto es un ejemplo en $name", style = TextStyle(fontFamily = FontFamily.Cursive))
        Text(
            text = "Esto es un ejemplo en $name",
            style = TextStyle(textDecoration = TextDecoration.Underline))

        Text(text = "Esto es un ejemplo en $name",
            textDecoration = TextDecoration.Underline)
        Text(
            text = "Esto es un ejemplo en $name",
            style = TextStyle(textDecoration = TextDecoration.LineThrough))
        Text(
            text = "Esto es un ejemplo en $name",
            textDecoration = TextDecoration.LineThrough)

        Text(
            text = "Esto es un ejemplo en $name",
            style = TextStyle(textDecoration = TextDecoration.combine(
                listOf(TextDecoration.Underline, TextDecoration.LineThrough)
            )))

        Text(text = "Esto es un ejemplo en $name")
        Text(text = "Esto es un ejemplo en $name")

    }
}
@Composable
fun MyTextField(name: String, onValueChanged:(String)->Unit) {

    TextField(
        value = name,
        onValueChange = {onValueChanged(it)},
        label = {Text(text = "Introduce tu nombre")})
}

@Composable
fun MyOutlinedTextField(){
    var myText by rememberSaveable() { mutableStateOf("")  }
    OutlinedTextField(
        value = myText,
        onValueChange = {myText = it},
        modifier = Modifier.padding(24.dp),
        label = { Text(text = "ExampleOutlinedTextField")},
        colors = OutlinedTextFieldDefaults.colors(
            focusedTextColor = Color.Red,
            focusedBorderColor = Color.Red,
            unfocusedTextColor = Color.Blue,
            unfocusedBorderColor = Color.Blue
        )
    )
}

@Composable
fun MyButton(enabled: Boolean, onButtonClicked: ()->Unit) {

    Column(){
        Button(
            onClick = onButtonClicked,
            enabled = enabled,
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Blue,
                contentColor = Color.Yellow,
            )
        ) {
            Text(
                text = "Pulsame"
            )
        }
    }

}

@Composable
fun MyOutlinedButton(state: Boolean, onButtonOutlinedClicked: () -> Unit){
    OutlinedButton(
        onClick = onButtonOutlinedClicked,
        Modifier.padding(8.dp),
        enabled = state,
        colors = ButtonDefaults.outlinedButtonColors(
            contentColor = Color.Magenta,
            containerColor = Color.Cyan
        )
    ) {
        Text(text = "OutlinedButton")
    }
}

@Composable
fun MyTextButton(){
    TextButton(onClick = {}) {
        Text(text = "This a TextButton")
    }
}

@Composable
fun MyProgressBar() {
    Column(
        Modifier
            .padding(24.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally)
    {

        CircularProgressIndicator(color = Color.Red, strokeWidth = 5.dp)
        LinearProgressIndicator(
            modifier = Modifier.padding(top = 32.dp),
            color = Color.Green,
            trackColor = Color.Red
        )
    }
}



@Preview(showBackground = true)
@Composable
fun MyComponentsPreview(){
    //MyText("Android", modifier = Modifier)
    //MyTextField()
    //MyOutlinedTextField()
    //MyButton()
    //MyOutlinedButton()
    //MyTextButton()
    //MyProgressBar()
}