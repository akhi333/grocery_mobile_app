import 'package:flutter/material.dart';
import 'screens/home_screen.dart';

void main() {
  runApp(GreenOBasketApp());
}

class GreenOBasketApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'GreenOBasket Grocery',
      theme: ThemeData(primarySwatch: Colors.green),
      home: HomeScreen(),
    );
  }
}