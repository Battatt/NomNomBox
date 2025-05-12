package com.battatt.myapplication.data.repository

import com.battatt.myapplication.data.local.Product
import com.battatt.myapplication.data.local.ProductDao
import kotlinx.coroutines.flow.Flow

class ProductRepository(private val dao: ProductDao) {
    val allProducts: Flow<List<Product>> = dao.getAll()

    suspend fun insert(product: Product) = dao.insert(product)
    suspend fun delete(product: Product) = dao.delete(product)
}