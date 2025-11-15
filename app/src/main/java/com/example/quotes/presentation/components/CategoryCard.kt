package com.example.quotes.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.quotes.domain.model.Category
import com.example.quotes.domain.model.QuoteCategory
import com.example.quotes.ui.theme.Medium12
import com.example.quotes.ui.theme.Typography
import com.example.quotes.ui.theme.colorFF000000

@Composable
fun CategoryCard(
    item: Category,
    onCardClick: (QuoteCategory) -> Unit,
) {
    Column(
        modifier = Modifier
            .width(90.dp)
            .clickable(
                onClick = { onCardClick(item.title) }
            )
            .background(
                color = item.color.copy(
                    alpha = 0.1F
                ), shape = RoundedCornerShape(10.dp)
            )
            .padding(horizontal = 10.dp, vertical = 14.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Surface(
            color = item.color.copy(
                alpha = 0.4F
            ),
            shape = RoundedCornerShape(100.dp),
        ) {
            Icon(
                modifier = Modifier.padding(8.dp),
                imageVector = item.icon,
                contentDescription = "Icon",
                tint = item.color
            )
        }

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = item.title.name,
            style = Typography.Medium12.copy(
                color = colorFF000000
            )
        )
    }
}