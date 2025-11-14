package com.example.quotes.navigation

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.NavHostController
import com.example.quotes.ui.theme.colorFFFFFFFF

@Composable
fun BottomNavigationBar(navController: NavHostController) {
    var selectedIndex by remember { mutableIntStateOf(0) }

    NavigationBar(
        containerColor = colorFFFFFFFF,
    ) {
        bottomNavigationList.forEachIndexed { index, item ->
            NavigationBarItem(
                selected = selectedIndex == index,
                onClick = {
                    selectedIndex = index
                    navController.navigate(item.route)
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