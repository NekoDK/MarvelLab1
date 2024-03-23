package com.example.marvellab1.Data

import com.example.marvellab1.Data.CharactersDTO
import com.example.marvellab1.Util.Constants
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Query

interface MarvelApi {
    @GET(GET_MARVEL_CHARACTER)
    suspend  fun getCharacter(
        @Query("apikey") apiKey: String = Constants.API_KEY,
        @Query("ts") ts: String = Constants.timeStamp,
        @Query("hash") hash: String = Constants.hash()
    ):Deferred<CharactersDTO>

    companion object {
        private const val GET_MARVEL_CHARACTER = "/v1/public/characters"
    }
}
