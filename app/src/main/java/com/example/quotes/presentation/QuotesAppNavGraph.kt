package com.example.quotes.presentation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.quotes.navigation.QuotesScreenRoute
import com.example.quotes.presentation.screens.ExploreScreen
import com.example.quotes.presentation.screens.HomeScreen
import com.example.quotes.presentation.screens.SavedScreen

@Composable
fun QuotesAppNavGraph(
    navController: NavHostController,
    modifier: Modifier,
    savedQuotesState: SavedQuotesState
) {
    NavHost(
        navController = navController,
        startDestination = QuotesScreenRoute.Home.route,
        modifier = modifier
    ) {
        composable(route = QuotesScreenRoute.Home.route) {
            HomeScreen(
                navController = navController,
                savedQuotesState = savedQuotesState
            )
        }

        composable(
            route = "${QuotesScreenRoute.Explore.route}?category={category}",
            arguments = listOf(
                navArgument("category") {
                    type = NavType.StringType
                    nullable = true
                    defaultValue = null
                }
            )
        ) { backStackEntry ->
            val category = backStackEntry.arguments?.getString("category")
            ExploreScreen(
                preSelectedCategory = category,
                savedQuotesState = savedQuotesState,
            )
        }

        composable(route = QuotesScreenRoute.Saved.route) {
            SavedScreen(
                savedQuotesState = savedQuotesState
            )
        }
    }
}