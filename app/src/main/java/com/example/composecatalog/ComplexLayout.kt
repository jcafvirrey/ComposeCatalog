package com.example.composecatalog
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview(showBackground = true)
@Composable
fun MyComplexLayout(){
    Column(Modifier.fillMaxSize()){
        Box(Modifier
            .fillMaxWidth()
            .weight(1f)
            .background(Color.Cyan),
            contentAlignment = Alignment.Center
        ){
            Text(
                text= "Ejemplo1",
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp

            )
        }
        //Spacer(modifier = Modifier.height(30.dp))
        MySpacer(30)

        Row(Modifier
            .fillMaxWidth()
            .weight(1f)){
            Box(modifier = Modifier
                .weight(1f)
                .background(Color.Red)
                .fillMaxHeight(),
                contentAlignment = Alignment.Center){
                Text(
                    text= "Ejemplo2",
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp

                )

            }
            Box(modifier = Modifier
                .weight(1f)
                .background(Color.Green)
                .fillMaxHeight(),
                contentAlignment = Alignment.Center){
                Text(
                    text= "Ejemplo3",
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp

                )
            }
        }
        MySpacer(70)
        Box(modifier = Modifier
            .weight(1f)
            .background(Color.Magenta)
            .fillMaxWidth(),
            contentAlignment = Alignment.BottomCenter){
            Text(
                text= "Ejemplo4",
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp

            )

        }
    }
}
@Composable
fun MySpacer(size: Int) {
    Spacer(modifier = Modifier.height(size.dp))
}
