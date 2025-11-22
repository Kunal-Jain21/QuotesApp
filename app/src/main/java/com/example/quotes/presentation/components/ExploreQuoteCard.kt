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
import com.example.quotes.domain.model.Quote
import com.example.quotes.ui.theme.Medium12
import com.example.quotes.ui.theme.Medium16
import com.example.quotes.ui.theme.Typography
import com.example.quotes.ui.theme.colorFF000000
import com.example.quotes.ui.theme.colorFF296ED1
import com.example.quotes.ui.theme.colorFFFF0000

@Composable
fun ExploreQuoteCard(
    quote: Quote,
    isSaved: Boolean,
    onSaveButtonClick: () -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                quote.category.color.copy(
                    alpha = 0.1F
                ), shape = RoundedCornerShape(10.dp)
            )
            .padding(20.dp)
    ) {
        QuoteHeader(
            quote = quote,
            isFavorite = isSaved,
            onFavoriteClick = onSaveButtonClick,
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = quote.text,
            style = Typography.Medium16.copy(
                fontSize = 17.sp,
                color = colorFF000000
            )
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = quote.author,
            style = Typography.Medium12.copy(
                color = quote.category.color
            )
        )
    }
}

@Composable
private fun QuoteHeader(
    quote: Quote,
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
            color = quote.category.color.copy(alpha = 0.4F)
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
                    tint = colorFFFF0000
                )
            }

            Text(
                text = quote.category.name.lowercase().replaceFirstChar { it.uppercase() },
                style = Typography.Medium16.copy(
                    color = quote.category.color
                )
            )
        }
    }
}