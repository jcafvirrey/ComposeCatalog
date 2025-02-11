package com.example.jetpackcomposecatalog2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun TriStateCheckboxGroup2() {
    // Estados para los tres checkboxes secundarios, utilizando ToggleableState
    var option1 by remember { mutableStateOf(ToggleableState.Off) }
    var option2 by remember { mutableStateOf(ToggleableState.Off) }
    var option3 by remember { mutableStateOf(ToggleableState.Off) }
    var mainState by remember { mutableStateOf(false) }
    // Calculamos el estado del checkbox principal:
    // Si todos están On, es On; si todos Off, es Off; en caso contrario, es Indeterminate.
    /*
    val mainState = when {
        option1 == ToggleableState.On && option2 == ToggleableState.On && option3 == ToggleableState.On ->
            ToggleableState.On
        option1 == ToggleableState.Off && option2 == ToggleableState.Off && option3 == ToggleableState.Off ->
            ToggleableState.Off
        else -> ToggleableState.Indeterminate
    }
     */

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Checkbox principal
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(bottom = 16.dp)
        ) {
            Text(text = "Selecciona todas las opciones:")
            Spacer(modifier = Modifier.width(8.dp))
            Checkbox(
                checked = mainState,
                onCheckedChange = {
                    if (mainState != true) {
                        mainState = true
                        // Si el principal no está en On, activamos los secundarios.
                        // Si alguno ya estaba en On, lo ponemos en Indeterminate.
                        val anyOn = (option1 == ToggleableState.On ||
                                option2 == ToggleableState.On ||
                                option3 == ToggleableState.On)
                        if (anyOn) {
                            option1 = if (option1 == ToggleableState.On) ToggleableState.Indeterminate else ToggleableState.On
                            option2 = if (option2 == ToggleableState.On) ToggleableState.Indeterminate else ToggleableState.On
                            option3 = if (option3 == ToggleableState.On) ToggleableState.Indeterminate else ToggleableState.On
                        } else {

                            option1 = ToggleableState.On
                            option2 = ToggleableState.On
                            option3 = ToggleableState.On
                        }
                    } else {
                        // Si el principal está en On y se pulsa, desactivamos todos
                        mainState = false
                        option1 = ToggleableState.Off
                        option2 = ToggleableState.Off
                        option3 = ToggleableState.Off
                    }
                }
            )


        }

        // Opción 1
        TriStateCheckboxRow2(
            label = "Opción 1",
            state = option1,
            onClick = {
                option1 = when (option1) {
                    ToggleableState.Off -> ToggleableState.On
                    ToggleableState.On -> ToggleableState.Off
                    ToggleableState.Indeterminate -> ToggleableState.On
                }
            }
        )

        // Opción 2
        TriStateCheckboxRow2(
            label = "Opción 2",
            state = option2,
            onClick = {
                option2 = when (option2) {
                    ToggleableState.Off -> ToggleableState.On
                    ToggleableState.On -> ToggleableState.Off
                    ToggleableState.Indeterminate -> ToggleableState.On
                }
            }
        )

        // Opción 3
        TriStateCheckboxRow2(
            label = "Opción 3",
            state = option3,
            onClick = {
                option3 = when (option3) {
                    ToggleableState.Off -> ToggleableState.On
                    ToggleableState.On -> ToggleableState.Off
                    ToggleableState.Indeterminate -> ToggleableState.On
                }
            }
        )
    }
}

@Composable
fun TriStateCheckboxRow2(
    label: String,
    state: ToggleableState,
    onClick: () -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(vertical = 4.dp)
    ) {
        TriStateCheckbox(
            state = state,
            onClick = onClick
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = label)
    }
}
@Preview(showBackground = true)
@Composable
fun MyExerciseCheckBoxPreview2(){

    TriStateCheckboxGroup2()

}

