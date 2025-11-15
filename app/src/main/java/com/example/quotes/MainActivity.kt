package com.example.quotes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.quotes.navigation.BottomNavigationBar
import com.example.quotes.presentation.QuotesAppNavGraph
import com.example.quotes.presentation.SavedQuotesState
import com.example.quotes.ui.theme.QuotesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            val savedQuotesState = remember { SavedQuotesState() }
            QuotesTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    bottomBar = { BottomNavigationBar(navController = navController) }
                ) { innerPadding ->
                    QuotesAppNavGraph(
                        modifier = Modifier.padding(innerPadding),
                        navController = navController,
                        savedQuotesState = savedQuotesState
                    )
                }
            }
        }
    }
}