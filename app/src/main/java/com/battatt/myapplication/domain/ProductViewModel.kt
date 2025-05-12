package com.battatt.myapplication.domain

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.battatt.myapplication.data.local.AppDatabase
import com.battatt.myapplication.data.local.Product
import com.battatt.myapplication.data.repository.ProductRepository
import kotlinx.coroutines.launch

class ProductViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: ProductRepository
    val allProducts: LiveData<List<Product>>

    init {
        val dao = AppDatabase.getInstance(application).productDao()
        repository = ProductRepository(dao)
        allProducts = repository.allProducts.asLiveData()
    }

    fun insert(product: Product) = viewModelScope.launch {
        repository.insert(product)
    }

    fun delete(product: Product) = viewModelScope.launch {
        repository.delete(product)
    }
}