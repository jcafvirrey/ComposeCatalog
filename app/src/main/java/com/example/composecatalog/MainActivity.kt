package com.example.composecatalog

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import com.example.composecatalog.ui.theme.ComposeCatalogTheme
import com.example.composecatalog.model.SuperHeroGridView

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeCatalogTheme {
                Surface (
                    color = MaterialTheme.colorScheme.background
                ){
                    /*var show by remember { mutableStateOf(false) }
                    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.TopStart){*/
                        /*Button(onClick = {show = true}) {
                            Text(text = "Show Dialog")
                        }*/
                        //MyDialog(show = show, onDismiss = {show = false}, onConfirm = { Log.i("dialog", "Click Done")})
                        //MySingleCustomDialog(show = show, onDismiss = {show = false})
                        //MyComplexDialog(show, onDismiss = {show = false})MyConfirmationDialog(show = show, onDismiss ={show = false} )
                        //SimpleRecyclerView()
                        //SuperHeroView()
                        SuperHeroGridView()
                    }
                    }
                }
            }
        }



