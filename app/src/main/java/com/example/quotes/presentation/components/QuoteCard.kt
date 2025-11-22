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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.unit.dp
import com.example.quotes.domain.model.Quote
import com.example.quotes.domain.model.categories
import com.example.quotes.ui.theme.Medium12
import com.example.quotes.ui.theme.Medium14
import com.example.quotes.ui.theme.Typography
import com.example.quotes.ui.theme.colorFF1E40AF
import com.example.quotes.ui.theme.colorFFFF0000
import com.example.quotes.ui.theme.colorFFFFFFFF

@Composable
fun QuoteCard(
    data: Quote,
    isFavorite: Boolean = false,
    onShareClick: () -> Unit = {},
    onFavoriteClick: () -> Unit = {}
) {
    val category = remember {
        categories.find {
            it.title == data.category
        }
    }
    Column(
        modifier = Modifier
            .width(200.dp)
            .height(220.dp)
            .clip(RoundedCornerShape(20.dp))
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(
                        (category?.color ?: colorFF1E40AF),
                        (category?.color ?: colorFF1E40AF).copy(alpha = 0.8F),
                        (category?.color ?: colorFF1E40AF).copy(alpha = 0.6F),
                    )
                ),
            )
            .padding(20.dp)
    ) {
        // Top
        QuoteCardHeader(
            isFavorite = isFavorite,
            onShareClick = onShareClick,
            onFavoriteClick = onFavoriteClick
        )

        Spacer(modifier = Modifier.weight(1f))

        // Quote Text
        Text(
            text = data.text,
            style = Typography.Medium14.copy(
                color = colorFFFFFFFF
            )
        )

        Spacer(modifier = Modifier.height(15.dp))

        // name text
        Text(
            text = data.author,
            style = Typography.Medium12.copy(
                color = colorFFFFFFFF.copy(alpha = 0.5F)
            )
        )
    }
}

@Composable
fun QuoteCardHeader(
    isFavorite: Boolean = false,
    onShareClick: () -> Unit,
    onFavoriteClick: () -> Unit
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Surface(
            modifier = Modifier
                .size(32.dp)
                .clip(CircleShape),
            color = colorFFFFFFFF.copy(alpha = 0.05F)
        ) {}

        Row(
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(
                modifier = Modifier.size(20.dp),
                onClick = onShareClick
            ) {
                Icon(
                    imageVector = Icons.Default.Share,
                    contentDescription = "Share",
                    tint = colorFFFFFFFF
                )
            }

            IconButton(
                modifier = Modifier.size(20.dp),
                onClick = onFavoriteClick
            ) {
                Icon(
                    imageVector = if (isFavorite) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                    contentDescription = if (isFavorite) "Remove from favorites" else "Add to favorites",
                    tint = if (isFavorite) colorFFFF0000 else colorFFFFFFFF
                )
            }
        }
    }
}