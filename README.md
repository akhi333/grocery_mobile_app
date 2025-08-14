# Grocery Mobile App

A cross-platform grocery mobile app with both Flutter (original) and native Android Kotlin implementations.

## ✨ **NEW: Native Android Kotlin Version Available!**

The app has been converted to a native Android application using Kotlin and Jetpack Compose for improved performance and user experience. See [KOTLIN_README.md](KOTLIN_README.md) for detailed information about the Kotlin version.

## Project Structure

- **Flutter Version** (original): Cross-platform implementation in the `lib/` directory
- **Android Kotlin Version**: Native Android app in the `android/` directory using Jetpack Compose

## Features

- 🛒 Product browsing and listing
- 🛍️ Shopping cart functionality  
- 👤 User profile management
- 💳 Checkout process
- 📱 Material Design UI
- 🌐 API integration ready

## Getting Started

### Android Kotlin Version (Recommended)
1. Open the `android` folder in Android Studio
2. Build and run the project
3. See [KOTLIN_README.md](KOTLIN_README.md) for detailed setup

### Flutter Version
1. Install [Flutter](https://flutter.dev/docs/get-started/install)
2. Run `flutter pub get` to install dependencies
3. Update the backend API URL in `lib/services/api_service.dart`
4. Start with `flutter run`

## Architecture

### Kotlin Version
- **Jetpack Compose**: Modern declarative UI
- **MVVM Pattern**: Clean architecture
- **Material Design 3**: Latest design system
- **Navigation Component**: Type-safe navigation

### Flutter Version  
- **Dart/Flutter**: Cross-platform framework
- **Material Design**: Flutter's material components
- **Widget-based architecture**: Composable UI components

## Next Steps

- Implement real backend connection
- Add cart persistence and user authentication
- Enhance UI/UX with animations and transitions
- Prepare for app store deployment