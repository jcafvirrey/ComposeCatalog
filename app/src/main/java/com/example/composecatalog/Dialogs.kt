package com.example.composecatalog

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties


@Composable
fun MyDialog(show: Boolean, onDismiss: () -> Unit, onConfirm: () -> Unit){
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

@Composable
fun MySingleCustomDialog(show: Boolean, onDismiss: () -> Unit){

    if(show){
        Dialog(onDismissRequest = {onDismiss()},
            properties = DialogProperties(
                dismissOnBackPress = false,
                dismissOnClickOutside = false
            )
        ) {
            Column(Modifier
                .background(Color.White)
                .padding(24.dp)
                .fillMaxWidth()
            ){
                Text(text = "This an example")

            }
        }
    }

}

@Composable
fun MyComplexDialog(show: Boolean, onDismiss: () -> Unit){

    if(show){
        Dialog(onDismissRequest = onDismiss){
            Column(
                modifier = Modifier
                    .fillMaxWidth(1f)
                    .background(color = Color.White)
            ){
                MyTitleDialog("Set backup account")
                AccountItem("ejemplo1@gmail.com", drawable = R.drawable.avatar)
                AccountItem("ejemplo1@gmail.com", drawable = R.drawable.avatar)
                AccountItem("ejemplo1@gmail.com", drawable = R.drawable.avatar)
                AccountItem("Add account", drawable = R.drawable.add)
            }

        }
    }

}

@Composable
fun MyConfirmationDialog(show: Boolean, onDismiss: () -> Unit){
    if(show){
        Column(
            Modifier
                .fillMaxWidth()
                .background(Color.White)
        ){
            MyTitleDialog("Phone Ringtone", modifier = Modifier.padding(24.dp))
            HorizontalDivider(Modifier.fillMaxWidth(), color = Color.LightGray)
            var status by remember { mutableStateOf("") }
            MyRadioButton(status) { status = it }
            HorizontalDivider(Modifier.fillMaxWidth(), color = Color.LightGray)
            Row(Modifier.align(Alignment.End).padding(8.dp)){
                TextButton(onClick = {}) {
                    Text(text = "CANCEL")
                }
                TextButton(onClick = {}) {
                    Text(text= "OK")
                }
                
            }
        }
    }
}


@Composable
fun MyTitleDialog(text: String,modifier: Modifier = Modifier.padding(bottom = 12.dp)){
    Text(
        text = text,
        fontWeight = FontWeight.SemiBold,
        fontSize = 20.sp,
        modifier = modifier
    )
}
@Composable
fun AccountItem(email: String, @DrawableRes  drawable: Int){
    Row(verticalAlignment = Alignment.CenterVertically){
        Image(
            painter = painterResource(id = drawable),
            contentDescription = "avatar",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .padding(8.dp)
                .size(40.dp)
                .clip(CircleShape)
        )
        Text(
            text = email,
            fontSize = 14.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color.Gray,
            modifier = Modifier.padding(8.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun MyDialogsPreview(){
    //MyDialog()
}