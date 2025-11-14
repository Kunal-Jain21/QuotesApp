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
    ),

    // ✅ Motivation
    Quote(
        id = 5,
        text = "Push yourself, because no one else is going to do it for you.",
        author = "— Unknown",
        category = QuoteCategory.Motivation
    ),
    Quote(
        id = 6,
        text = "Small steps every day lead to big results.",
        author = "— Unknown",
        category = QuoteCategory.Motivation
    ),

    // ✅ Success
    Quote(
        id = 7,
        text = "Success is not final; failure is not fatal.",
        author = "— Winston Churchill",
        category = QuoteCategory.Success
    ),
    Quote(
        id = 8,
        text = "Success comes to those who are too busy to be looking for it.",
        author = "— Henry David Thoreau",
        category = QuoteCategory.Success
    ),

    // ✅ Wisdom
    Quote(
        id = 9,
        text = "The only true wisdom is knowing you know nothing.",
        author = "— Socrates",
        category = QuoteCategory.Wisdom
    ),
    Quote(
        id = 10,
        text = "In the end, we regret the chances we didn’t take.",
        author = "— Lewis Carroll",
        category = QuoteCategory.Wisdom
    ),

    // ✅ Love
    Quote(
        id = 11,
        text = "Where there is love, there is life.",
        author = "— Mahatma Gandhi",
        category = QuoteCategory.Love
    ),
    Quote(
        id = 12,
        text = "To love and be loved is to feel the sun from both sides.",
        author = "— David Viscott",
        category = QuoteCategory.Love
    ),

    // ✅ Courage
    Quote(
        id = 13,
        text = "Courage doesn’t mean you don’t get afraid. It means you don’t let fear stop you.",
        author = "— Bethany Hamilton",
        category = QuoteCategory.Courage
    ),
    Quote(
        id = 14,
        text = "It takes courage to grow up and become who you really are.",
        author = "— E.E. Cummings",
        category = QuoteCategory.Courage
    ),

    // ✅ Leadership
    Quote(
        id = 15,
        text = "A leader is one who knows the way, goes the way, and shows the way.",
        author = "— John C. Maxwell",
        category = QuoteCategory.Leadership
    ),
    Quote(
        id = 16,
        text = "Leadership is not a position or title; it is action and example.",
        author = "— Unknown",
        category = QuoteCategory.Leadership
    )
)

