package com.battatt.myapplication.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.battatt.myapplication.data.local.Product

@Composable
fun AddProductDialog(onDismiss: () -> Unit, onAdd: (Product) -> Unit) {
    var name by remember { mutableStateOf("") }
    var expirationDate by remember { mutableStateOf("") }
    var calories by remember { mutableStateOf("") }
    var protein by remember { mutableStateOf("") }
    var fat by remember { mutableStateOf("") }
    var carbs by remember { mutableStateOf("") }
    var quantity by remember { mutableStateOf("") }

    AlertDialog(
        onDismissRequest = onDismiss,
        confirmButton = {
            Button(onClick = {
                onAdd(
                    Product(
                        name = name,
                        expirationDate = expirationDate,
                        calories = calories.toIntOrNull() ?: 0,
                        protein = protein.toDoubleOrNull() ?: 0.0,
                        fat = fat.toDoubleOrNull() ?: 0.0,
                        carbs = carbs.toDoubleOrNull() ?: 0.0,
                        quantity = quantity.toIntOrNull() ?: 1
                    )
                )
            }) {
                Text("Добавить")
            }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) {
                Text("Отмена")
            }
        },
        title = { Text("Добавить продукт") },
        text = {
            Column {
                OutlinedTextField(value = name, onValueChange = { name = it }, label = { Text("Название") })
                OutlinedTextField(value = expirationDate, onValueChange = { expirationDate = it }, label = { Text("Годен до") })
                OutlinedTextField(value = calories, onValueChange = { calories = it }, label = { Text("Калории") })
                OutlinedTextField(value = protein, onValueChange = { protein = it }, label = { Text("Белки") })
                OutlinedTextField(value = fat, onValueChange = { fat = it }, label = { Text("Жиры") })
                OutlinedTextField(value = carbs, onValueChange = { carbs = it }, label = { Text("Углеводы") })
                OutlinedTextField(value = quantity, onValueChange = { quantity = it }, label = { Text("Количество") })
            }
        }
    )
}
