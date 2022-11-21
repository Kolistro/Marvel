package com.kolistro.marvel.network

object ApiConstants {
    private const val PUBLIC_KEY = "913d99104cc6b97e0cbd3d6559b53f1e"
    const val BASE_URL = "http://gateway.marvel.com"
    const val AUTHENTICATION = "ts=1&" +
            "apikey=${PUBLIC_KEY}&" +
            "hash=86660d6aed300b7e63fa2abad45db8c8"
    const val WAY_CHARACTERS = "/v1/public/characters?${AUTHENTICATION}"
    const val WAY_CHARACTER = "/v1/public/characters/{characterId}?${AUTHENTICATION}"
}