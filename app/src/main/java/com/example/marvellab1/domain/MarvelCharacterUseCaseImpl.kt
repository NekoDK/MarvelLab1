package com.example.marvellab1.domain

import com.example.marvellab1.Data.Dto.CharactersDTO
import com.example.marvellab1.Data.Hero
import com.example.marvellab1.Data.MarvelRepository

class MarvelCharacterUseCaseImpl(private val repository: MarvelRepository) : MarvelCharaterUseCase {
    override suspend fun getHero() = charactersDTOToDomain(repository.getCharacter())

    private fun charactersDTOToDomain(charactersDTO: List<CharactersDTO>): List<Hero> {
     val heros =  charactersDTO.map {
            Hero(
                IdHero = 0,
                cardText = it.name,
                cardDesc = it.description,
                cardImageUrl = it.thumbnail.path
            )
        }
        return heros
    }

}