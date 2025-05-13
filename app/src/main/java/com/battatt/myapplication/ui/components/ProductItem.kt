package com.battatt.myapplication.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.battatt.myapplication.data.local.Product

@Composable
fun ProductItem(product: Product) {
    Card(modifier = Modifier
            .fillMaxWidth()  //?
            .padding(8.dp), elevation = CardDefaults.cardElevation(4.dp)) {
        Column(modifier = Modifier.padding(16.dp)) {  //?
            Text(text = product.name, style = MaterialTheme.typography.titleMedium)
            Text(text = "Срок: ${product.expirationDate}")
            Text(text = "К: ${product.calories}  Б: ${product.protein}  Ж: ${product.fat}  У: ${product.carbs}")
            Text(text = "Кол-во: ${product.quantity}")
        }
    }
}
