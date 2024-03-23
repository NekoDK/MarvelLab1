package com.example.marvellab1.Data

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.marvellab1.Data.CharactersDTO
import com.example.marvellab1.Util.Constants
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class HeroViewModel : ViewModel() {
    private val _heroList = MutableStateFlow(emptyList<Hero>())
    val heroList: StateFlow<List<Hero>> = _heroList

    private fun charactersDTOToDomain(charactersDTO: List<CharactersDTO>): List<Hero> {
        val heros = charactersDTO.map {
            Hero(
                IdHero = 0,
                cardText = it.name,
                cardDesc = it.description,
                cardImageUrl = it.thumbnail.path
            )
        }
        return heros
    }
    fun getHeroes() {
        viewModelScope.launch {
            _heroList.value = getHeroesFromApi()

        }
    }

    fun getHeroById(id: Int): Hero? {
        return heroList.value.find { it.IdHero == id }
    }


    private fun getHeroesFromApi(): List<Hero> {
        val retrofit = Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build()
        val marvelService = retrofit.create(MarvelApi::class.java)

        var list = emptyList<Hero>()

        CoroutineScope(Dispatchers.IO).launch {

            list =  charactersDTOToDomain(listOf(marvelService.getCharacter().await()))
        }
        return list
    }


}