package com.kolistro.marvel.network

import com.kolistro.marvel.network.characters.Characters
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path


private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(ApiConstants.BASE_URL)
    .build()

interface CharactersApiService {
    @GET(ApiConstants.WAY_CHARACTERS)
    suspend fun getMarvelCharacters():Characters
}

interface CharacterApiService{
    @GET(ApiConstants.WAY_CHARACTER)
    suspend fun getHero(@Path ("characterId") id: String?):com.kolistro.marvel.network.characters.Result
}

object MarvelApi {
    val retrofitService : CharactersApiService by lazy {
        retrofit.create(CharactersApiService::class.java)
    }
    val retrofitService2 : CharacterApiService by lazy {
        retrofit.create(CharacterApiService::class.java)
    }
}