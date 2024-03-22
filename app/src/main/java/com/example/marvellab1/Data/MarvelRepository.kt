package com.example.marvellab1.Data

import com.example.marvellab1.Data.Dto.CharactersDTO

interface MarvelRepository {
    suspend fun getCharacter(): List<CharactersDTO>
}