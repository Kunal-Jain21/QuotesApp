package com.example.quotes.presentation.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.example.quotes.domain.model.categories
import com.example.quotes.domain.model.quoteCardList
import com.example.quotes.presentation.components.QuoteComponent
import com.example.quotes.ui.theme.Bold20
import com.example.quotes.ui.theme.Medium12
import com.example.quotes.ui.theme.Typography
import com.example.quotes.ui.theme.colorFF000000
import com.example.quotes.ui.theme.colorFFD3D3D5
import com.example.quotes.ui.theme.colorFFFFFFFF

@Composable
fun ExploreScreen() {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 12.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        item {
            Text(
                text = "Categories",
                style = Typography.Bold20.copy(
                    color = colorFF000000
                )
            )

            Spacer(modifier = Modifier.height(8.dp))

            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                items(categories) { category ->
                    Chip(
                        title = category.title.name,
                        onClick = {}
                    )
                }
            }
        }

        items(
            items = quoteCardList,
            key = { item -> item.id }) { cardData ->
            QuoteComponent(
                data = cardData
            )
        }
    }

}

@Composable
fun Chip(
    title: String,
    onClick: () -> Unit,
) {
    Surface(
        modifier = Modifier
            .background(color = colorFFFFFFFF,shape = RoundedCornerShape(8.dp))
            .clickable(
                onClick = onClick
            ),
        shape = RoundedCornerShape(8.dp),
        color = colorFFFFFFFF,
        border = BorderStroke(
            width = 1.dp,
            color = colorFFD3D3D5
        )
    ) {
        Text(
            text = title,
            style = Typography.Medium12,
            modifier = Modifier.padding(horizontal = 10.dp, vertical = 5.dp)
        )
    }
}