package com.example.marvellab1

object HeroData {
    fun getHero(): List<Hero> =
        listOf(
            Hero(
                IdHero = 0,
                cardText = com.example.marvellab1.R.string.deadpool_hero ,
                cardDesc = com.example.marvellab1.R.string.deadpool_desc,
                cardImageUrl = "https://iili.io/JMnAfIV.png",
            ),
            Hero(
                IdHero = 1,
                cardText = com.example.marvellab1.R.string.iron_man_hero,
                cardDesc = com.example.marvellab1.R.string.iron_man_desc,
                cardImageUrl = "https://iili.io/JMnuDI2.png",
            ),
            Hero(
                IdHero = 2,
                cardText = com.example.marvellab1.R.string.spider_man_hero,
                cardDesc = com.example.marvellab1.R.string.spider_man_desc,
                cardImageUrl = "https://iili.io/JMnuyB9.png",
            ),
        )
}