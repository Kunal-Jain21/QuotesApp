package com.example.quotes.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.quotes.domain.model.Category
import com.example.quotes.domain.model.Quote
import com.example.quotes.domain.model.categories
import com.example.quotes.ui.theme.Medium12
import com.example.quotes.ui.theme.Medium16
import com.example.quotes.ui.theme.Typography
import com.example.quotes.ui.theme.colorFF000000
import com.example.quotes.ui.theme.colorFF1E40AF
import com.example.quotes.ui.theme.colorFF296ED1
import com.example.quotes.ui.theme.colorFFBBC6E6
import com.example.quotes.ui.theme.colorFFBDBDBD
import com.example.quotes.ui.theme.colorFFEAEEF8
import com.example.quotes.ui.theme.colorFFFF0000
import com.example.quotes.ui.theme.colorFFFFFFFF

@Composable
fun ExploreQuoteCard(
    data: Quote,
    isSaved: Boolean,
    onFavoriteClick: () -> Unit,
) {
    val currentCategory = categories.find {
        it.title == data.category
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                (currentCategory?.color ?: colorFFEAEEF8).copy(
                    alpha = 0.1F
                ), shape = RoundedCornerShape(10.dp)
            )
            .padding(20.dp)
    ) {
        QuoteHeader(
            data = data,
            currentCategory = currentCategory,
            isFavorite = isSaved,
            onFavoriteClick = onFavoriteClick,
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = data.text,
            style = Typography.Medium16.copy(
                fontSize = 17.sp,
                color = colorFF000000
            )
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = data.author,
            style = Typography.Medium12.copy(
                color = currentCategory?.color ?: colorFFBBC6E6
            )
        )
    }
}

@Composable
private fun QuoteHeader(
    data: Quote,
    currentCategory: Category?,
    onFavoriteClick: () -> Unit,
    isFavorite: Boolean
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Surface(
            modifier = Modifier
                .size(38.dp)
                .clip(CircleShape),
            color = (currentCategory?.color ?: colorFFBDBDBD).copy(alpha = 0.4F)
        ) {
            Icon(
                modifier = Modifier.padding(5.dp),
                imageVector = Icons.Default.Person,
                contentDescription = "Profile",
                tint = colorFF296ED1
            )
        }

        Column(
            horizontalAlignment = Alignment.End,
            verticalArrangement = Arrangement.spacedBy(5.dp, Alignment.CenterVertically)
        ) {

            IconButton(
                modifier = Modifier.size(25.dp),
                onClick = onFavoriteClick
            ) {
                Icon(
                    imageVector = if (isFavorite) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                    contentDescription = if (isFavorite) "Remove from favorites" else "Add to favorites",
                    tint = if (isFavorite) colorFFFF0000 else colorFFFFFFFF
                )
            }

            Text(
                text = data.category.name.lowercase().replaceFirstChar { it.uppercase() },
                style = Typography.Medium16.copy(
                    color = currentCategory?.color ?: colorFF1E40AF
                )
            )
        }
    }
}