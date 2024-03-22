package com.example.marvellab1.Data

import com.example.marvellab1.Data.Dto.CharactersDTO

class MarvelRepositoryImpl( private val marvelApi: MarvelApi): MarvelRepository {
    override suspend fun getCharacter(): List<CharactersDTO> = listOf( marvelApi.getCharacter())

}