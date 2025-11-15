package com.example.quotes.domain.model

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Star
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.quotes.ui.theme.colorFF1E40AF
import com.example.quotes.ui.theme.colorFF2786A9
import com.example.quotes.ui.theme.colorFF2E7D32
import com.example.quotes.ui.theme.colorFF424242
import com.example.quotes.ui.theme.colorFF6A1B9A
import com.example.quotes.ui.theme.colorFFC2185B
import com.example.quotes.ui.theme.colorFFFFA000

data class Category(
    val title: QuoteCategory,
    val icon: ImageVector,
    val color: Color,
)

enum class QuoteCategory {
    Life, Motivation, Success, Wisdom, Love, Courage, Leadership
}

val categories = listOf(
    Category(
        title = QuoteCategory.Life,
        icon = Icons.Default.Favorite,
        color = colorFF1E40AF
    ),
    Category(
        title = QuoteCategory.Motivation,
        icon = Icons.Default.Star,
        color = colorFFFFA000
    ),

    Category(
        title = QuoteCategory.Success,
        icon = Icons.Default.LocationOn,
        color = colorFF2E7D32
    ),

    Category(
        title = QuoteCategory.Wisdom,
        icon = Icons.Default.Info,
        color = colorFF6A1B9A
    ),

    Category(
        title = QuoteCategory.Love,
        icon = Icons.Default.FavoriteBorder,
        color = colorFFC2185B
    ),

    Category(
        title = QuoteCategory.Courage,
        icon = Icons.Default.AccountBox,
        color = colorFF2786A9
    ),

    Category(
        title = QuoteCategory.Leadership,
        icon = Icons.Default.Person,
        color = colorFF424242
    )
)
