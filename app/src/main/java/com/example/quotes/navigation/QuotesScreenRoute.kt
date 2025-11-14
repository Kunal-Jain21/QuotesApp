package com.example.quotes.navigation

sealed class QuotesScreenRoute(val route: String) {
    data object Home : QuotesScreenRoute(route = "Home")
    data object Explore : QuotesScreenRoute(route = "Explore")
    data object Saved : QuotesScreenRoute(route = "Saved")
}