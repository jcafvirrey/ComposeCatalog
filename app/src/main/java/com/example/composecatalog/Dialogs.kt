package com.example.composecatalog

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview


@Composable
fun MyDialog(
    show: Boolean,
    onDismiss: () -> Unit,
    onConfirm: () -> Unit
){
    if(show){
        AlertDialog(
            onDismissRequest = {onDismiss()},
            confirmButton = {
                TextButton(onClick = {onConfirm()}) {
                    Text(text = "ConfirmButton")
                }
            },
            dismissButton = {
                TextButton(onClick = {onDismiss()}) {
                    Text(text = "DismissButton")
                }
            },
            title = {Text(text = "Title")},
            text = {Text(text = "Hello, I'm a description")}
        )
    }
}

@Preview(showBackground = true)
@Composable
fun MyDialogsPreview(){
    //MyDialog()
}