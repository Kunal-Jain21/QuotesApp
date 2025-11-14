package com.example.quotes.domain.model

data class Quote(
    val id: Int,
    val text: String,
    val author: String,
    val category: QuoteCategory,
)

val quoteCardList = listOf(
    Quote(
        id = 1,
        text = "Never forget those that helped before you even had to ask.",
        author = "— Id ~gavshdnv",
        category = QuoteCategory.Life
    ),
    Quote(
        id = 2,
        text = "Do something today that your future self will thank you for.",
        author = "— Unknown",
        category = QuoteCategory.Leadership
    ),
    Quote(
        id = 3,
        text = "The harder you work for something, the greater you’ll feel when you achieve it.",
        author = "— Anonymous",
        category = QuoteCategory.Life
    ),
    Quote(
        id = 4,
        text = "Dream it. Believe it. Build it.",
        author = "— Unknown",
        category = QuoteCategory.Life
    )
)
