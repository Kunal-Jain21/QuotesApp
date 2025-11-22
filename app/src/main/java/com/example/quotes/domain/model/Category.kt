package com.example.quotes.domain.model

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.TrendingUp
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Groups
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Shield
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
    val name: String,
    val icon: ImageVector,
    val color: Color,
) {
    companion object {
        val Life = Category(
            name = "Life",
            icon = Icons.Default.Favorite,
            color = colorFF1E40AF
        )

        val Motivation = Category(
            name = "Motivation",
            icon = Icons.Default.Star,
            color = colorFFFFA000
        )

        val Success = Category(
            name = "Success",
            icon = Icons.AutoMirrored.Filled.TrendingUp,
            color = colorFF2E7D32
        )

        val Wisdom = Category(
            name = "Wisdom",
            icon = Icons.Filled.Info,
            color = colorFF6A1B9A
        )

        val Love = Category(
            name = "Love",
            icon = Icons.Filled.FavoriteBorder,
            color = colorFFC2185B
        )

        val Courage = Category(
            name = "Courage",
            icon = Icons.Filled.Shield,
            color = colorFF2786A9
        )

        val Leadership = Category(
            name = "Leadership",
            icon = Icons.Filled.Groups,
            color = colorFF424242
        )

        fun findByName(name: String): Category? {
            return categories.find { it.name == name }
        }
    }
}

val categories = listOf(
    Category.Life,
    Category.Motivation,
    Category.Success,
    Category.Wisdom,
    Category.Love,
    Category.Courage,
    Category.Leadership
)
