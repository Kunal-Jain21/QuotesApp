package com.example.quotes.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalWindowInfo
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.quotes.R
import com.example.quotes.domain.model.categories
import com.example.quotes.domain.model.quoteCardList
import com.example.quotes.navigation.QuotesScreenRoute
import com.example.quotes.presentation.SavedQuotesState
import com.example.quotes.presentation.components.CategoryCard
import com.example.quotes.presentation.components.QuoteCard
import com.example.quotes.ui.theme.Bold12
import com.example.quotes.ui.theme.Bold16
import com.example.quotes.ui.theme.Bold20
import com.example.quotes.ui.theme.Medium12
import com.example.quotes.ui.theme.Typography
import com.example.quotes.ui.theme.colorFF000000
import com.example.quotes.ui.theme.colorFF596FC6
import com.example.quotes.ui.theme.colorFFA9A9A9
import com.example.quotes.ui.theme.colorFFF9CC18

@Composable
fun HomeScreen(
    navController: NavHostController,
    savedQuotesState: SavedQuotesState
) {
    val windowInfo = LocalWindowInfo.current
    val heightDp = with(LocalDensity.current) {
        windowInfo.containerSize.height.toDp()
    }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 12.dp)
    ) {

        item {
            HomeHeader()

            Spacer(modifier = Modifier.height(15.dp))

        }

        item {
            Box(
                modifier = Modifier
                    .height(heightDp * 0.2f)
                    .fillMaxWidth()
                    .background(color = colorFFF9CC18, shape = RoundedCornerShape(16.dp)),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "BELIEVE IN\nYOURSELF",
                    style = Typography.Bold20.copy(fontSize = 34.sp, lineHeight = 30.sp),
                    textAlign = TextAlign.Center
                )
            }
        }

        // LatestQuotes
        item {
            Section(
                sectionTitle = stringResource(R.string.latest_quotes),
                onButtonClick = {}
            ) {
                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(16.dp),
                ) {
                    items(quoteCardList) { item ->
                        QuoteCard(
                            data = item,
                            isFavorite = savedQuotesState.isSaved(item.id),
                            onShareClick = {},
                            onFavoriteClick = {
                                savedQuotesState.toggleSave(item)
                            }
                        )
                    }
                }
            }
        }

        // Categories
        item {
            Section(
                sectionTitle = stringResource(R.string.categories),
                onButtonClick = {}
            ) {
                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(16.dp),
                ) {
                    items(categories) { item ->
                        CategoryCard(
                            item = item,
                            onCardClick = {
                                navController.navigate("${QuotesScreenRoute.Explore.route}?category=${item.title}")
                            }
                        )
                    }
                }
            }
        }

        // Trending Quotes
        item {
            Section(
                sectionTitle = stringResource(R.string.trending_quotes),
                onButtonClick = {}
            ) {
                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(16.dp),
                ) {
                    items(quoteCardList) { item ->
                        QuoteCard(
                            data = item,
                            isFavorite = savedQuotesState.isSaved(item.id),
                            onShareClick = {},
                            onFavoriteClick = {
                                savedQuotesState.toggleSave(item)
                            }
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun HomeHeader() {
    Text(
        text = stringResource(R.string.explore),
        style = Typography.Bold20.copy(fontSize = 25.sp)
    )

    // Sub heading
    Text(
        text = stringResource(R.string.home_screen_subtitle),
        style = Typography.Medium12.copy(
            color = colorFFA9A9A9
        )
    )
}

@Composable
fun Section(
    sectionTitle: String,
    onButtonClick: () -> Unit,
    sectionContent: @Composable () -> Unit
) {
    // Title and ViewAll Button
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = sectionTitle,
                style = Typography.Bold16.copy(color = colorFF000000)
            )

            TextButton(
                onClick = onButtonClick
            ) {
                Text(
                    text = "View All",
                    style = Typography.Bold12.copy(
                        fontSize = 12.sp,
                        color = colorFF596FC6
                    )
                )
            }
        }

        Spacer(modifier = Modifier.height(4.dp))

        // items of section
        sectionContent()
    }
}

