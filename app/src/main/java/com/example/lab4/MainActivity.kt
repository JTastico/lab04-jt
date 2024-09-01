package com.example.lab4

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lab4.ui.theme.Lab4Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Lab4Theme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    floatingActionButton = {
                        FloatingActionButton(onClick = { /* Acción importante, como guardar los datos */ }) {
                            Text("+")
                        }
                    }
                ) { innerPadding ->
                    CombinedContent(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun CombinedContent(modifier: Modifier = Modifier) {
    var name by remember { mutableStateOf("") }
    var lastName by remember { mutableStateOf("") }
    var age by remember { mutableStateOf("") }

    Column(modifier = modifier.fillMaxSize()) {
        // Lista de elementos utilizando LazyColumn
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(1) {
                // Inputs de texto para nombre, apellido y edad
                InputField(label = "Nombre", value = name, onValueChange = { name = it })
                InputField(label = "Apellido", value = lastName, onValueChange = { lastName = it })
                InputField(label = "Edad", value = age, onValueChange = { age = it })
            }
        }
    }
}

@Composable
fun InputField(label: String, value: String, onValueChange: (String) -> Unit) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(label) },
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    )
}

@Preview(showBackground = true)
@Composable
fun CombinedContentPreview() {
    Lab4Theme {
        CombinedContent()
    }
}
