package com.example.trashdating.repository

interface QuotesRepository {
    fun getQuote(userId: Int) : String
    fun addQuoteToProfile(userId: Int, quote: String)
    fun removeQuoteFromProfile(userId: Int)
}