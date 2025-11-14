package com.example.quotes.presentation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.quotes.navigation.QuotesScreenRoute
import com.example.quotes.presentation.screens.ExploreScreen
import com.example.quotes.presentation.screens.HomeScreen
import com.example.quotes.presentation.screens.SavedScreen

@Composable
fun QuotesAppNavGraph(
    navController: NavHostController,
    modifier: Modifier
) {
    NavHost(
        navController = navController,
        startDestination = QuotesScreenRoute.Home.route,
        modifier = modifier
    ) {
        composable(route = QuotesScreenRoute.Home.route) {
            HomeScreen()
        }

        composable(route = QuotesScreenRoute.Explore.route) {
            ExploreScreen()
        }

        composable(route = QuotesScreenRoute.Saved.route) {
            SavedScreen()
        }
    }
}