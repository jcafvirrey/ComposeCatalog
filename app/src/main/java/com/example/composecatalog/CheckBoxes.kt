package com.example.composecatalog


import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TriStateCheckbox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalMapOf
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun MyCheckBox(){
    var state by rememberSaveable { mutableStateOf(false) }
    Checkbox(
        checked = state,
        onCheckedChange = {state = !state},
        enabled = true,
        colors = CheckboxDefaults.colors(
            checkedColor = Color.Gray,
            uncheckedColor = Color.Yellow,
            checkmarkColor = Color.Red
        )
    )
    }

@Composable
fun MyCheckBoxWithText(){
    var state by rememberSaveable { mutableStateOf(false)}
    Row(Modifier.padding(8.dp), verticalAlignment = Alignment.CenterVertically){
        Checkbox(
            checked = state,
            onCheckedChange = {state = !state}
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = "Option 1")

    }
}

@Composable
fun MyCheckBoxWithTextComplete(checkInfo: CheckInfo){
    //var state by rememberSaveable { mutableStateOf(false)}
    Row(Modifier.padding(8.dp), verticalAlignment = Alignment.CenterVertically){
        Checkbox(
            checked = checkInfo.selected,
            onCheckedChange = {checkInfo.onCheckedChange(!checkInfo.selected)}
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = checkInfo.title)

    }
}

@Composable
fun getOptions(titles: List<String>): List<CheckInfo>{
    return titles.map{
        var status by rememberSaveable { mutableStateOf(true) }
        CheckInfo(
            title = it,
            selected = status,
            onCheckedChange = {status = it}
        )
    }
}

@Composable
fun MyTriStatusCheckBox(){
    var status by rememberSaveable { mutableStateOf(ToggleableState.Off) }
    TriStateCheckbox(state = status, onClick = {
        status = when(status){
            ToggleableState.On -> ToggleableState.Off
            ToggleableState.Off -> ToggleableState.Indeterminate
            ToggleableState.Indeterminate -> ToggleableState.On
        }
    })
}

@Preview(showBackground = true)
@Composable
fun MyCheckBoxPreview(){
    //MyCheckBox()
    //MyCheckBoxWithText()
    MyTriStatusCheckBox()
}