package com.example.androidmaster.examplemvvm.model

class QuoteProvider {
    companion object { //clase estática

        fun random(): QuoteModel {
            val position = (0 until quote.size).random()
            return quote[position]
        }

        private val quote = listOf<QuoteModel>(
            QuoteModel(
                "Be yourself; everyone else is already taken.",
                "Oscar Wilde"
            ),
            QuoteModel(
                "So many books, so little time.",
                "Frank Zappa"
            ),
            QuoteModel(
                "A room without books is like a body without a soul.",
                "Marcus Tullius Cicero"
            ),
            QuoteModel(
                "You only live once, but if you do it right, once is enough.",
                "Mae West"
            ),
            QuoteModel(
                "Be the change that you wish to see in the world.",
                "Mahatma Gandhi"
            ),
            QuoteModel(
                "In three words I can sum up everything I've learned about life: it goes on.",
                "Robert Frost"
            ),
            QuoteModel(
                "If you tell the truth, you don't have to remember anything.",
                "Mark Twain"
            ),
            QuoteModel(
                "A friend is someone who knows all about you and still loves you.",
                "Elbert Hubbard"
            ),
            QuoteModel(
                "Always forgive your enemies; nothing annoys them so much.",
                "Oscar Wilde"
            ),
            QuoteModel(
                "To live is the rarest thing in the world. Most people exist, that is all.",
                "Oscar Wilde"
            )
        )
    }
}