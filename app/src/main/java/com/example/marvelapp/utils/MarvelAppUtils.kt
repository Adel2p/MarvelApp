package com.example.marvelapp.utils

import com.example.marvelapp.data.remote.Constants.MARVEL_PRIVATE_KEY
import com.example.marvelapp.data.remote.Constants.MARVEL_PUBLIC_KEY
import java.security.MessageDigest

object MarvelAppUtils {


    fun getTimestamp(): String {
        return System.currentTimeMillis().toString()
    }

    fun generateHash(): String {
        val input = "${getTimestamp()}$MARVEL_PRIVATE_KEY$MARVEL_PUBLIC_KEY"
        return md5(input)
    }

    fun md5(input: String): String {
        val md = MessageDigest.getInstance("MD5")
        val digest = md.digest(input.toByteArray())
        return digest.joinToString("") { "%02x".format(it) }
    }
}