package com.example.grocery_mobile_app.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Product(
    val id: String,
    val name: String,
    val price: Double,
    val imageUrl: String
) : Parcelable {
    companion object {
        fun fromJson(json: Map<String, Any>): Product {
            return Product(
                id = json["id"] as String,
                name = json["name"] as String,
                price = (json["price"] as Number).toDouble(),
                imageUrl = json["imageUrl"] as String
            )
        }
    }
    
    fun toJson(): Map<String, Any> {
        return mapOf(
            "id" to id,
            "name" to name,
            "price" to price,
            "imageUrl" to imageUrl
        )
    }
}