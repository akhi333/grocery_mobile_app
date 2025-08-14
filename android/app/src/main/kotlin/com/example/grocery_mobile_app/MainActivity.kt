package com.example.grocery_mobile_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.grocery_mobile_app.ui.screen.*
import com.example.grocery_mobile_app.ui.theme.GreenOBasketTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GreenOBasketTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    GreenOBasketApp()
                }
            }
        }
    }
}

@Composable
fun GreenOBasketApp() {
    val navController = rememberNavController()
    
    NavHost(
        navController = navController,
        startDestination = "home"
    ) {
        composable("home") {
            HomeScreen(
                onNavigateToProducts = { navController.navigate("products") },
                onNavigateToCart = { navController.navigate("cart") },
                onNavigateToProfile = { navController.navigate("profile") }
            )
        }
        
        composable("products") {
            ProductListScreen(
                onNavigateBack = { navController.popBackStack() },
                onNavigateToCart = { navController.navigate("cart") }
            )
        }
        
        composable("cart") {
            CartScreen(
                onNavigateBack = { navController.popBackStack() },
                onNavigateToCheckout = { navController.navigate("checkout") }
            )
        }
        
        composable("profile") {
            ProfileScreen(
                onNavigateBack = { navController.popBackStack() }
            )
        }
        
        composable("checkout") {
            CheckoutScreen(
                onNavigateBack = { navController.popBackStack() }
            )
        }
    }
}