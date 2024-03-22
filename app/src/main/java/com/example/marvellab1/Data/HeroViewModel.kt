package com.example.marvellab1.Data

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.marvellab1.domain.MarvelCharaterUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class HeroViewModel(private val useCase : MarvelCharaterUseCase) : ViewModel() {
    private val _heroList = MutableStateFlow(emptyList<Hero>())
    val heroList: StateFlow<List<Hero>> = _heroList

    init {
        getHeroes()
    }

    private fun getHeroes() {
        viewModelScope.launch {
            _heroList.value =  useCase.getHero()
          //  _heroList.value = HeroData.getHero()
        }
    }

    fun getHeroById(id: Int): Hero? {
        return heroList.value.find { it.IdHero == id }
    }

}