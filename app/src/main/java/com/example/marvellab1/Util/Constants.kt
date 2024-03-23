package com.example.marvellab1.Util

import java.math.BigInteger
import java.security.MessageDigest
import java.sql.Timestamp

class Constants {
    companion object{
        const val BASE_URL = "https://gateway.marvel.com"
        val timeStamp = Timestamp(System.currentTimeMillis()).time.toString()
        const val API_KEY = "7e1a764944efedf093f569ce881b5c04"
        const val PRIVATE_KEY = "5f0a09e4e496104f7ec64ed94aa93f3b26a63a1d"
        const val limit = "20"
        fun hash():String{
            val input = "$timeStamp$PRIVATE_KEY$API_KEY"
            val md = MessageDigest.getInstance("MD5")
            return BigInteger(1,md.digest(input.toByteArray())).toString(16).padStart(32,'0')
        }
    }
}