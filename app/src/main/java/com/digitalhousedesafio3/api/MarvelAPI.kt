package com.digitalhousedesafio3.api

import com.digitalhousedesafio3.model.Comics
import retrofit2.Response
import retrofit2.http.GET

interface MarvelAPI {
    @GET("comics")
    suspend fun getComics(): Response<Comics>
}