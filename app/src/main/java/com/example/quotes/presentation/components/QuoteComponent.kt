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
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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

@Composable
fun QuoteComponent(
    data: Quote,
) {
    val currentCategory = categories.find {
        it.title == data.category
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(currentCategory?.color?.backgroundColor ?: colorFFEAEEF8, shape = RoundedCornerShape(10.dp))
            .padding(20.dp)
    ) {
        QuoteHeader(
            data = data,
            currentCategory = currentCategory,
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
                color = currentCategory?.color?.iconTint ?: colorFFBBC6E6
            )
        )
    }
}

@Composable
private fun QuoteHeader(data: Quote, currentCategory: Category?, ) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Surface(
            modifier = Modifier
                .size(32.dp)
                .clip(CircleShape),
            color = currentCategory?.color?.circleColor ?: colorFFBDBDBD
        ) {
            Icon(
                modifier = Modifier.padding(5.dp),
                imageVector = Icons.Default.Person,
                contentDescription = "Profile",
                tint = colorFF296ED1
            )
        }

        Text(
            text = data.category.name.lowercase().replaceFirstChar { it.uppercase() },
            style = Typography.Medium16.copy(
                color = currentCategory?.color?.iconTint ?: colorFF1E40AF
            )
        )
    }
}