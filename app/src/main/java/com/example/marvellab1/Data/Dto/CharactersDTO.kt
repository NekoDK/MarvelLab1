package com.example.marvellab1.Data.Dto

import com.google.gson.annotations.SerializedName


data class CharactersDTO(
    @SerializedName("name") val name: String,
    @SerializedName("description") val description: String,
    @SerializedName("thumbnail") val thumbnail: Image
)

data class Image(
    @SerializedName("path") val path: String
)
