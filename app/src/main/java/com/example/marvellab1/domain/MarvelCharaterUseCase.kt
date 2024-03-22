package com.example.marvellab1.domain

import com.example.marvellab1.Data.Hero

interface MarvelCharaterUseCase {
  suspend  fun getHero() : List<Hero>
}