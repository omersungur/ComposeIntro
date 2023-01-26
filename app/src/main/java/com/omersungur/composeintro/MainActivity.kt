package com.omersungur.composeintro

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.omersungur.composeintro.ui.theme.ComposeIntroTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeIntroTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MainScreen()
                }

                //testFunction(5,::testLambda) lambda gösterimi değil. bu fonksiyonu referans sistemiyle kullandık
                /*testFunction(6) {
                    testLambda()
                }*/
            }
        }
    }

    /*fun testFunction (number : Int, myFunction : () -> Unit) {
        myFunction.invoke()
    }

    fun testLambda() {
        println("Test")
    }*/
}

@Composable
fun MainScreen() {
    //Row > Satırda sıralama(yatay)
    //Column > Sütunda sıralama (dikey)
    //Box > Z ekseninde sıralama

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.LightGray),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        CustomText(text = "Hello Android")
        Spacer(modifier = Modifier.padding(bottom = 5.dp))
        CustomText(text = "Hello Kotlin")
        Spacer(modifier = Modifier.padding(bottom = 5.dp))
        CustomText(text = "Hello Java")

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            CustomText(text = "Test 1")
            Spacer(modifier = Modifier.padding(5.dp))
            CustomText(text = "Test 2")
            Spacer(modifier = Modifier.padding(5.dp))
            CustomText(text = "Test 3")

        }
    }
}

@Composable
fun CustomText(text: String) {
    Text(modifier = Modifier
        .clickable {
            println("Texte tıklandı!")
        }
        .background(color = Color.Yellow)
        .padding(top = 10.dp, bottom = 5.dp, start = 15.dp, end = 20.dp)
        .width(150.dp),
        text = text,
        color = Color.Blue,
        fontWeight = FontWeight.Bold,
        fontSize = 22.sp
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MainScreen()
}