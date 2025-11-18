package com.example.myapplicationcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.Navigation
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myapplicationcompose.ui.theme.MyApplicationComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationComposeTheme() {
                Main()
            }
        }
    }
}
@Composable
fun First(ToThePage: () -> Unit){
    Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "The First Page")
        Button(onClick = ToThePage) {
            Text(text = "The Second Page")
        }
    }
}
@Composable
fun Second(ToThePage: () -> Unit){
    Column(Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "The Second page")
        Button(onClick = ToThePage) {
            Text(text = "The first page")
        }
    }
}
@Composable
fun Main(){
    val nav = rememberNavController()
    NavHost(nav, "first") {
        composable("first") {
            First(ToThePage = {nav.navigate("second")})
        }
        composable("second") {
            Second(ToThePage = {nav.navigate("first")})
        }
    }
}

