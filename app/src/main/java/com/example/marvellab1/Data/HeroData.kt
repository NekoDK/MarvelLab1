package com.example.marvellab1.Data

import com.example.marvellab1.R

object HeroData {
    fun getHero(): List<Hero> =
        listOf(
            Hero(
                IdHero = 0,
                cardText = R.string.deadpool_hero,
                cardDesc = R.string.deadpool_desc,
                cardImageUrl = "https://iili.io/JMnAfIV.png",
            ),
            Hero(
                IdHero = 1,
                cardText = R.string.iron_man_hero,
                cardDesc = R.string.iron_man_desc,
                cardImageUrl = "https://iili.io/JMnuDI2.png",
            ),
            Hero(
                IdHero = 2,
                cardText = R.string.spider_man_hero,
                cardDesc = R.string.spider_man_desc,
                cardImageUrl = "https://iili.io/JMnuyB9.png",
            ),
        )
}