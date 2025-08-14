import 'package:flutter/material.dart';
import 'product_list_screen.dart';
import 'cart_screen.dart';
import 'profile_screen.dart';

class HomeScreen extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: Text('GreenOBasket')),
      body: Center(child: Text('Welcome to GreenOBasket!')),
      drawer: Drawer(
        child: ListView(
          children: [
            ListTile(
              title: Text('Products'),
              onTap: () => Navigator.push(context, MaterialPageRoute(builder: (_) => ProductListScreen())),
            ),
            ListTile(
              title: Text('Cart'),
              onTap: () => Navigator.push(context, MaterialPageRoute(builder: (_) => CartScreen())),
            ),
            ListTile(
              title: Text('Profile'),
              onTap: () => Navigator.push(context, MaterialPageRoute(builder: (_) => ProfileScreen())),
            ),
          ],
        ),
      ),
    );
  }
}