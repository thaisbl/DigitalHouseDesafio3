package com.digitalhousedesafio3.business

import com.digitalhousedesafio3.api.ResponseApi
import com.digitalhousedesafio3.model.Comics
import com.digitalhousedesafio3.utils.MarvelHomeRepository

class MarvelHomeBusiness {

    private val repository by lazy {
        MarvelHomeRepository()
    }

    suspend fun getComics(): ResponseApi {
        val response = repository.getComics()
        return if (response is ResponseApi.Success) {
            val comics = response.data as Comics
            ResponseApi.Success(comics)
        } else {
            response
        }
    }
}