package com.example.composecatalog

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.composecatalog.ui.theme.ComposeCatalogTheme
import coil3.compose.AsyncImage

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeCatalogTheme {
                Surface (
                    color = MaterialTheme.colorScheme.background
                ){
                    var show by remember { mutableStateOf(false) }
                    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.TopStart){
                        /*Button(onClick = {show = true}) {
                            Text(text = "Show Dialog")
                        }*/
                        //MyDialog(show = show, onDismiss = {show = false}, onConfirm = { Log.i("dialog", "Click Done")})
                        //MySingleCustomDialog(show = show, onDismiss = {show = false})
                        //MyComplexDialog(show, onDismiss = {show = false})MyConfirmationDialog(show = show, onDismiss ={show = false} )
                        SimpleRecyclerView()
                    }
                    }
                }
            }
        }
    }


