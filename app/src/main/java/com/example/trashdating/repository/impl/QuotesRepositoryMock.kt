package com.example.trashdating.repository.impl

import com.example.trashdating.repository.QuotesRepository

class QuotesRepositoryMock: QuotesRepository {
    private var quotes = mutableMapOf(
        Pair(
            1, "Если закрыть глаза, становится темно"
        ),
        Pair(
            2, "Тут — это вам не там"
        ),
        Pair(
            3, "Кто рано встает — тому весь день спать хочется"
        )
    )

    override fun getQuote(userId: Int) : String {
        return quotes[userId] ?: ""
    }

    override fun addQuoteToProfile(userId: Int, quote: String) {
        quotes[userId] = quote
    }

    override fun removeQuoteFromProfile(userId: Int) {
        quotes.remove(userId)
    }
}