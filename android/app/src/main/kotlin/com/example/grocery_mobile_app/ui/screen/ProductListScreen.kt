package com.example.grocery_mobile_app.ui.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.grocery_mobile_app.model.Product
import com.example.grocery_mobile_app.service.ApiService
import com.example.grocery_mobile_app.ui.component.ProductItem
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductListScreen(
    onNavigateBack: () -> Unit,
    onNavigateToCart: () -> Unit,
    modifier: Modifier = Modifier,
    apiService: ApiService = ApiService()
) {
    var products by remember { mutableStateOf<List<Product>>(emptyList()) }
    var isLoading by remember { mutableStateOf(true) }
    var errorMessage by remember { mutableStateOf<String?>(null) }
    val scope = rememberCoroutineScope()

    LaunchedEffect(Unit) {
        scope.launch {
            apiService.fetchProducts()
                .onSuccess { productList ->
                    products = productList
                    isLoading = false
                }
                .onFailure { error ->
                    errorMessage = error.message
                    isLoading = false
                    // For demo purposes, show some sample products
                    products = getSampleProducts()
                }
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Products") },
                navigationIcon = {
                    IconButton(onClick = onNavigateBack) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                },
                actions = {
                    IconButton(onClick = onNavigateToCart) {
                        Icon(Icons.Default.ShoppingCart, contentDescription = "Cart")
                    }
                }
            )
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            when {
                isLoading -> {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            CircularProgressIndicator()
                            Spacer(modifier = Modifier.height(16.dp))
                            Text("Loading products...")
                        }
                    }
                }
                products.isEmpty() -> {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(
                                text = "No products available",
                                style = MaterialTheme.typography.headlineSmall,
                                fontWeight = FontWeight.Medium
                            )
                            errorMessage?.let { message ->
                                Spacer(modifier = Modifier.height(8.dp))
                                Text(
                                    text = message,
                                    style = MaterialTheme.typography.bodyMedium,
                                    color = MaterialTheme.colorScheme.error
                                )
                            }
                        }
                    }
                }
                else -> {
                    LazyColumn(
                        modifier = Modifier.fillMaxSize(),
                        contentPadding = PaddingValues(16.dp),
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        items(products) { product ->
                            ProductItem(
                                product = product,
                                onAddToCart = {
                                    // TODO: Implement add to cart functionality
                                }
                            )
                        }
                    }
                }
            }
        }
    }
}

private fun getSampleProducts(): List<Product> {
    return listOf(
        Product("1", "Fresh Apples", 2.99, "https://example.com/apple.jpg"),
        Product("2", "Organic Bananas", 1.99, "https://example.com/banana.jpg"),
        Product("3", "Milk (1 Gallon)", 3.49, "https://example.com/milk.jpg"),
        Product("4", "Whole Wheat Bread", 2.79, "https://example.com/bread.jpg"),
        Product("5", "Free Range Eggs", 4.99, "https://example.com/eggs.jpg")
    )
}