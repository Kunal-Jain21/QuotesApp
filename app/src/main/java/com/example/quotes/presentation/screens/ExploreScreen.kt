package com.example.quotes.presentation.screens

import android.util.Log
import androidx.compose.foundation.BorderStroke
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.quotes.R
import com.example.quotes.domain.model.Category
import com.example.quotes.domain.model.QuoteCategory
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

    var selectedCategory by remember {
        mutableStateOf<QuoteCategory?>(null)
    }

    val filteredQuotes = remember(selectedCategory) {
        if (selectedCategory == null) {
            quoteCardList
        } else {
            quoteCardList.filter { it.category == selectedCategory }
        }
    }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 12.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        item {
            Text(
                text = stringResource(R.string.categories),
                style = Typography.Bold20.copy(
                    color = colorFF000000
                )
            )

            Spacer(modifier = Modifier.height(8.dp))

            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                items(categories,
                    key = {item -> item.title}) { category ->
                    val isSelected = selectedCategory == category.title
                    Chip(
                        isSelected = isSelected,
                        category = category,
                        onClick = {
                            Log.d("Checking", "Onclick -> ${category.title}")
                            selectedCategory =
                                if (isSelected) null else category.title
                        }
                    )
                }
            }
        }

        items(
            items = filteredQuotes,
            key = { item -> item.id }) { cardData ->
            QuoteComponent(
                data = cardData
            )
        }
    }

}

@Composable
fun Chip(
    isSelected: Boolean,
    category: Category,
    onClick: () -> Unit,
) {
    Surface(
        onClick = onClick,
        shape = RoundedCornerShape(8.dp),
        color = if (isSelected) category.iconTint else colorFFFFFFFF,
        border = BorderStroke(
            width = 1.dp,
            color = colorFFD3D3D5
        )
    ) {
        Text(
            text = category.title.name,
            style = Typography.Medium12.copy(
                color = if (isSelected) colorFFFFFFFF else colorFF000000
            ),
            modifier = Modifier.padding(horizontal = 10.dp, vertical = 5.dp)
        )
    }
}