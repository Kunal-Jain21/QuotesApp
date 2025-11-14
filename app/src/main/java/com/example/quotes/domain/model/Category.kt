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
import com.example.quotes.ui.theme.colorFFA5D6A7
import com.example.quotes.ui.theme.colorFFB9DDE9
import com.example.quotes.ui.theme.colorFFBBC6E6
import com.example.quotes.ui.theme.colorFFBDBDBD
import com.example.quotes.ui.theme.colorFFCE93D8
import com.example.quotes.ui.theme.colorFFE8F5E9
import com.example.quotes.ui.theme.colorFFE9F4F8
import com.example.quotes.ui.theme.colorFFEAEEF8
import com.example.quotes.ui.theme.colorFFEBEBED
import com.example.quotes.ui.theme.colorFFF3E5F5

data class Category(
    val title: QuoteCategory,
    val icon: ImageVector,
    val backgroundColor: Color,   // outer card background
    val circleColor: Color,       // icon circle background
    val iconTint: Color           // icon tint
)

enum class QuoteCategory {
    Life, Motivation, Success, Wisdom, Love, Courage, Leadership
}

val categories = listOf(
    Category(
        title = QuoteCategory.Life,
        icon = Icons.Default.Favorite,
        backgroundColor = colorFFEAEEF8,
        circleColor = colorFFBBC6E6,
        iconTint = colorFF1E40AF
    ),
    Category(
        title = QuoteCategory.Motivation,
        icon = Icons.Default.Star,
        backgroundColor = Color(0xFFFFF3E0),
        circleColor = Color(0xFFFFE0B2),
        iconTint = Color(0xFFFFA000)
    ),
    Category(
        title = QuoteCategory.Success,
        icon = Icons.Default.LocationOn,
        backgroundColor = colorFFE8F5E9,
        circleColor = colorFFA5D6A7,
        iconTint = colorFF2E7D32
    ),
    Category(
        title = QuoteCategory.Wisdom,
        icon = Icons.Default.Info,
        backgroundColor = colorFFF3E5F5,
        circleColor = colorFFCE93D8,
        iconTint = colorFF6A1B9A
    ),
    Category(
        title = QuoteCategory.Love,
        icon = Icons.Default.FavoriteBorder,
        backgroundColor = Color(0xFFFCE4EC),
        circleColor = Color(0xFFF8BBD0),
        iconTint = Color(0xFFC2185B)
    ),
    Category(
        title = QuoteCategory.Courage,
        icon = Icons.Default.AccountBox,
        backgroundColor = colorFFE9F4F8,
        circleColor = colorFFB9DDE9,
        iconTint = colorFF2786A9
    ),
    Category(
        title = QuoteCategory.Leadership,
        icon = Icons.Default.Person,
        backgroundColor = colorFFEBEBED,
        circleColor = colorFFBDBDBD,
        iconTint = colorFF424242
    ),
)
