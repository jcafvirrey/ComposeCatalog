package com.example.composecatalog

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage

@Composable
fun AnimalCard() {
    val context = LocalContext.current

    // Estados para el icono de favorito y el contador de compartir
    var isFavorite by remember { mutableStateOf(false) }
    var shareCount by remember { mutableStateOf(0) }

    Card(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column {
            // Imagen de Internet usando Coil
            AsyncImage(
                model = "https://via.placeholder.com/600x300", // URL de ejemplo
                contentDescription = "Imagen de la tarjeta",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp)
            )

            // Contenido de la tarjeta
            Column(modifier = Modifier.padding(16.dp)) {
                // Título en negrita usando TextStyle
                Text(
                    text = "Título de la Tarjeta",
                    style = TextStyle(
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )
                )
                Spacer(modifier = Modifier.height(8.dp))
                // Breve descripción
                Text(
                    text = "Esta es una breve descripción que explica el contenido de la tarjeta. Aquí se pueden dar más detalles sobre el tema.",
                    style = TextStyle(
                        fontSize = 14.sp,
                        color = Color.DarkGray
                    )
                )
                Spacer(modifier = Modifier.height(16.dp))
                // Fila que contiene los botones y los iconos
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    // Botones de "Leer más" y "Razas"
                    Row {
                        TextButton(
                            onClick = {
                                Toast.makeText(context, "Leer más", Toast.LENGTH_SHORT).show()
                            }
                        ) {
                            Text(
                                text = "Leer más",
                                style = TextStyle(
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight.Medium,
                                    color = Color.Blue
                                ),
                                modifier = Modifier.padding(4.dp)
                            )
                        }
                        TextButton(
                            onClick = {
                                Toast.makeText(context, "Razas", Toast.LENGTH_SHORT).show()
                            }
                        ) {
                            Text(
                                text = "Razas",
                                style = TextStyle(
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight.Medium,
                                    color = Color.Blue
                                ),
                                modifier = Modifier.padding(4.dp)
                            )
                        }
                    }
                    // Iconos: Corazón y Compartir
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        IconButton(onClick = { isFavorite = !isFavorite }) {
                            Icon(
                                imageVector = Icons.Filled.Favorite,
                                contentDescription = "Favorito",
                                tint = if (isFavorite) Color.Red else Color.Gray
                            )
                        }
                        IconButton(onClick = { shareCount++ }) {
                            Icon(
                                imageVector = Icons.Filled.Share,
                                contentDescription = "Compartir"
                            )
                        }
                        // Muestra el contador de compartir si es mayor que 0
                        if (shareCount > 0) {
                            Text(
                                text = "$shareCount",
                                modifier = Modifier.padding(start = 4.dp),
                                style = TextStyle(fontSize = 12.sp, color = Color.Black)
                            )
                        }
                    }
                }
            }
        }
    }
}