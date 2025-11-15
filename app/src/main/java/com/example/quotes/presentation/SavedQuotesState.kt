package com.example.quotes.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import com.example.quotes.domain.model.Quote

class SavedQuotesState {
    private val _savedQuotes = mutableStateOf<Set<Int>>(emptySet())
    val savedQuotes: Set<Int> by _savedQuotes

    fun isSaved(quoteId: Int): Boolean {
        return _savedQuotes.value.contains(quoteId)
    }

    fun toggleSave(quote: Quote) {
        val currentSet = _savedQuotes.value.toMutableSet()
        if (currentSet.contains(quote.id)) {
            currentSet.remove(quote.id)
        } else {
            currentSet.add(quote.id)
        }
        _savedQuotes.value = currentSet
    }

    fun getSavedQuotes(allQuotes: List<Quote>): List<Quote> {
        return allQuotes.filter { savedQuotes.contains(it.id) }
    }
}

