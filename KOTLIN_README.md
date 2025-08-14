# GreenOBasket - Android Kotlin App

This is the native Android version of the GreenOBasket grocery mobile app, built with Kotlin and Jetpack Compose.

## Features

- **Modern UI**: Built with Jetpack Compose for smooth, native Android experience
- **Material Design 3**: Follows latest Material Design guidelines
- **Navigation**: Intuitive navigation between screens with Material Navigation Drawer
- **Product Browsing**: View and browse grocery products
- **Shopping Cart**: Add items to cart and proceed to checkout
- **User Profile**: Manage user profile information
- **API Integration**: Ready for backend API integration

## Architecture

- **MVVM Pattern**: Model-View-ViewModel architecture
- **Jetpack Compose**: Modern declarative UI toolkit
- **Navigation Component**: Type-safe navigation between screens
- **Retrofit**: HTTP client for API communication
- **Coil**: Image loading library for product images

## Project Structure

```
android/app/src/main/kotlin/com/example/grocery_mobile_app/
├── MainActivity.kt              # Main activity and navigation setup
├── model/
│   └── Product.kt              # Product data model
├── service/
│   └── ApiService.kt           # API service for backend communication
├── ui/
│   ├── component/
│   │   └── ProductItem.kt      # Reusable product item component
│   ├── screen/                 # All app screens
│   │   ├── HomeScreen.kt
│   │   ├── ProductListScreen.kt
│   │   ├── CartScreen.kt
│   │   ├── ProfileScreen.kt
│   │   └── CheckoutScreen.kt
│   └── theme/                  # Material Design theme
│       ├── Color.kt
│       ├── Theme.kt
│       └── Type.kt
```

## Building and Running

1. Open the `android` folder in Android Studio
2. Make sure you have Android SDK 34 installed
3. Build and run the project

## Requirements

- Android Studio Flamingo or later
- Android SDK 34
- Minimum Android API level 21
- Kotlin 1.9.22

## Next Steps

- Connect to real backend API by updating `ApiService.kt`
- Implement cart functionality with local storage
- Add user authentication
- Implement push notifications
- Add offline support