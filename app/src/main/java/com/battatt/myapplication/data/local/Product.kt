package com.battatt.myapplication.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "products")
data class Product (
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String,
    val expirationDate: String,
    val calories: Int,
    val protein: Double,
    val fat: Double,
    val carbs: Double,
    val quantity: Int
)