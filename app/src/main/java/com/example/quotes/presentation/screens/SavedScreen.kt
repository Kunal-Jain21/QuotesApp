package com.example.quotes.presentation.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.quotes.domain.model.quoteCardList
import com.example.quotes.presentation.SavedQuotesState
import com.example.quotes.presentation.components.ExploreQuoteCard
import com.example.quotes.ui.theme.Bold20
import com.example.quotes.ui.theme.Medium12
import com.example.quotes.ui.theme.Typography
import com.example.quotes.ui.theme.colorFFA9A9A9

@Composable
fun SavedScreen(savedQuotesState: SavedQuotesState) {
    val savedQuotes = savedQuotesState.getSavedQuotes(quoteCardList)

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 12.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        item {
            Text(
                text = "Saved",
                style = Typography.Bold20.copy(
                    fontSize = 25.sp,
                )
            )

            Spacer(modifier = Modifier.height(4.dp))
        }

        if (savedQuotes.isEmpty()) {
            item {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 64.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "No saved quotes yet",
                        style = Typography.Bold20.copy(
                            color = colorFFA9A9A9
                        ),
                        textAlign = TextAlign.Center
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "Tap the heart icon on any quote to save it",
                        style = Typography.Medium12.copy(
                            color = colorFFA9A9A9
                        ),
                        textAlign = TextAlign.Center
                    )
                }
            }
        } else {
            items(
                items = savedQuotes,
                key = { it.id }
            ) { quote ->
                ExploreQuoteCard(
                    data = quote,
                    isSaved = savedQuotesState.isSaved(quote.id),
                    onFavoriteClick = { savedQuotesState.toggleSave(quote) },
                )
            }
        }
    }
}