package com.digitalhousedesafio3.api

open class ResponseApi {
    class Success(val data: Any?) : ResponseApi()
    class Error(val message: String) : ResponseApi()
}