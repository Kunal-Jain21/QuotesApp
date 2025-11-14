package com.example.quotes.navigation

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.quotes.ui.theme.colorFFFFFFFF

@Composable
fun BottomNavigationBar(navController: NavHostController) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    val selectedIndex = remember(currentRoute) {
        if (currentRoute == null) {
            0
        } else {
            // Extract base route by removing query parameters (everything after '?')
            val baseRoute = currentRoute.substringBefore("?")
            bottomNavigationList.indexOfFirst { item ->
                item.route == baseRoute || currentRoute.startsWith(item.route)
            }.takeIf { it >= 0 } ?: 0
        }
    }

    NavigationBar(
        containerColor = colorFFFFFFFF,
    ) {
        bottomNavigationList.forEachIndexed { index, item ->
            NavigationBarItem(
                selected = selectedIndex == index,
                onClick = {
                    navController.navigate(item.route) {
                        // Pop up to the start destination to avoid building up a back stack
                        popUpTo(navController.graph.startDestinationId)
                        launchSingleTop = true
                    }
                },
                icon = {
                    Icon(imageVector = item.icon, contentDescription = item.title)
                },
                label = {
                    Text(
                        text = item.title,
                    )
                }
            )
        }

    }
}