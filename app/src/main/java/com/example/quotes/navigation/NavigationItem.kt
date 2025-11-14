package com.example.quotes.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.graphics.vector.ImageVector

data class NavigationItem(
    val title: String,
    val icon: ImageVector,
    val route: String
)

val bottomNavigationList = listOf(
    NavigationItem(
        title = "Home",
        icon = Icons.Default.Home,
        route = QuotesScreenRoute.Home.route
    ),
    NavigationItem(
        title = "Explore",
        icon = Icons.Default.Search,
        route = QuotesScreenRoute.Explore.route
    ),
    NavigationItem(
        title = "Saved",
        icon = Icons.Default.Favorite,
        route = QuotesScreenRoute.Saved.route
    ),
)
