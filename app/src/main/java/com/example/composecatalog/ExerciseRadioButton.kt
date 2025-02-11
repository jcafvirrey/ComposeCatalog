package com.example.composecatalog

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

@Composable
fun MainScreen() {
    //Se obtiene el contexto actual mediante LocalContext.current para luego usarlo en el Toast.
    val context = LocalContext.current
    //Definimos un estado para almacenar el valor seleccionado en el grupo de RadioButtons
    var cicloSeleccionado by remember { mutableStateOf("") }
    //Definimos la lista de modulos segund el ciclo seleccionado
    val modulos = remember(cicloSeleccionado) {
        when (cicloSeleccionado) {
            "DAW" -> listOf("Desarrollo web en entorno cliente","Desarrollo web en entorno servidor","Despliegue de aplicaciones web")
            "DAM" -> listOf("Acceso a datos", "Desarrollo de interfaces", "Programación multimedia y dispositivos móviles")
            "ASIR" -> listOf("Administración de sistemas operativos", "Seguridad y alta disponibilidad", "Servicios de red e Internet")
            else -> emptyList()
        }
    }
    //Usamos esta tipo de estado para almacenar un par String-Boolean, indicando
    //si el módulo esta seleccionado o no
    val moduloSeleccionado = remember { mutableStateMapOf<String, Boolean>() }

    //Layout para organizar los elementos verticalmente.
    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = "Selecciona un ciclo:")
        //Iteramos sobre una lista de ciclos
        listOf("DAW", "DAM", "ASIR").forEach { ciclo ->
            Row (verticalAlignment = Alignment.CenterVertically){
                RadioButton(
                    //El botón de radio muestra si el ciclo actual es el seleccionado
                    selected = (cicloSeleccionado == ciclo),
                    //Al pulsar sobre el texto del ciclo, se cambia el valor de cicloSeleccionado.
                    onClick = { cicloSeleccionado = ciclo }
                )
                Text(text = ciclo, Modifier.clickable { cicloSeleccionado = ciclo })
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Selecciona los módulos:")
        //Se recorre cada módulo de la lista calculada previamente.
        modulos.forEach { modulo ->
            Row (verticalAlignment = Alignment.CenterVertically){
                Checkbox(
                    /**
                     * El estado del checkbox se obtiene del mapa moduloSeleccionado.
                     * Si el valor asociado al módulo es true, el checkbox aparece marcado.
                     */
                    checked = moduloSeleccionado[modulo] == true,
                    onCheckedChange = { moduloSeleccionado[modulo] = it }
                )
                Text(text = modulo)
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            /**
             * Se filtra el mapa moduloSeleccionado para obtener solo aquellos módulos con valor true (seleccionados)
             *  y se extraen las claves (nombres de los módulos).
             */
            val selected = moduloSeleccionado.filterValues { it }.keys
            Toast.makeText(context, "Módulos seleccionados: $selected", Toast.LENGTH_LONG).show()
        }) {
            Text("Mostrar selección")
        }
    }
}