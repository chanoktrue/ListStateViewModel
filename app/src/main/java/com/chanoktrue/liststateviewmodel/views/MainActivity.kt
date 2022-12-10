package com.chanoktrue.liststateviewmodel.views

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.chanoktrue.liststateviewmodel.ui.theme.ListStateViewModelTheme
import com.chanoktrue.liststateviewmodel.viewModels.MyViewModel

class MainActivity : ComponentActivity() {

    private val myViewModel by viewModels<MyViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ListStateViewModelTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting(myViewModel = myViewModel)
                }
            }
        }
    }
}

@Composable
fun Greeting(myViewModel: MyViewModel) {
    val elements = myViewModel.elements
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(state = rememberScrollState())
    ) {
        Button(onClick = { myViewModel.addElement()}) {
            Text(text = "Add the number")
        }
        elements.forEach {
            Text(text = "Email: ${it.email} Passwrod: ${it.password}")
        }
    }
}

