package com.example.grocery_mobile_app.service

import com.example.grocery_mobile_app.model.Product
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiInterface {
    @GET("products")
    suspend fun getProducts(): Response<List<Map<String, Any>>>
}

class ApiService {
    companion object {
        private const val BASE_URL = "YOUR_BACKEND_API_URL/"
    }
    
    private val loggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }
    
    private val client = OkHttpClient.Builder()
        .addInterceptor(loggingInterceptor)
        .build()
    
    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    
    private val api = retrofit.create(ApiInterface::class.java)
    
    suspend fun fetchProducts(): Result<List<Product>> {
        return withContext(Dispatchers.IO) {
            try {
                val response = api.getProducts()
                if (response.isSuccessful) {
                    val body = response.body()
                    if (body != null) {
                        val products = body.map { productMap ->
                            Product.fromJson(productMap)
                        }
                        Result.success(products)
                    } else {
                        Result.failure(Exception("Empty response body"))
                    }
                } else {
                    Result.failure(Exception("Failed to load products: ${response.code()}"))
                }
            } catch (e: Exception) {
                Result.failure(Exception("Failed to load products: ${e.message}"))
            }
        }
    }
}