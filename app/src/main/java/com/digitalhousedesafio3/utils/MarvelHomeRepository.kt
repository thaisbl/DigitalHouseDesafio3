package com.digitalhousedesafio3.utils

import com.digitalhousedesafio3.api.ApiService
import com.digitalhousedesafio3.api.ResponseApi

class MarvelHomeRepository {

    suspend fun getComics(): ResponseApi {
        return try {
            val response = ApiService.marvelApi.getComics()

            if(response.code() == 200) {
                ResponseApi.Success(response.body())
            } else if (response.isSuccessful) {
                ResponseApi.Success(response.body())
            } else {
                if (response.code() == 404) {
                    ResponseApi.Error("Dado não encontrado")
                } else {
                    ResponseApi.Error("Erro ao carregar os dados")
                }
            }
        } catch (exception: Exception) {
            ResponseApi.Error("Erro ao carregar os dados")
        }
    }

}