package com.example.marvellab1.Data

import androidx.compose.ui.unit.Constraints
import com.example.marvellab1.Data.Dto.CharactersDTO
import com.example.marvellab1.Util.Constants
import retrofit2.http.GET
import retrofit2.http.Query

interface MarvelApi {
    @GET(GET_MARVEL_CHARACTER)
    fun getCharacter(
        @Query("apikey") apiKey: String = Constants.API_KEY,
        @Query("ts") ts: String = Constants.timeStamp,
        @Query("hash") hash: String = Constants.hash()
    ): CharactersDTO

    companion object {
        private const val GET_MARVEL_CHARACTER = "/v1/public/characters"
    }
}