package com.example.marvellab1.Data


data class CharactersDTO(
    val name: String,
    val description: String,
    val thumbnail: Image
)

data class Image(
    val path: String
)
