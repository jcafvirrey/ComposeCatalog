package com.example.composecatalog

import androidx.compose.foundation.clickable
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight

@Composable
fun SimpleRecyclerView(){
    val myList = listOf("Item 1", "Item 2", "Item 3", "Item 4")
    LazyColumn {
        item {
            Text(text = "HEADER", fontWeight = FontWeight.Bold)
        }
        items(myList) {
            Text(text = "I'm the $it")
        }
        item {
            Text(text = "FOOTER", fontWeight = FontWeight.Bold)
        }

    }
}