package com.digitalhousedesafio3.utils

class Constants {
    object Api {
        const val BASE_URL = "https://gateway.marvel.com:443/v1/public/"
        const val API_TS_NAME = "ts"
        const val API_KEY_NAME = "apikey"
        const val API_HASH_NAME = "hash"
        const val API_PUBLIC_KEY_VALUE = "6eb7e8896ec5850c52515a8a23ee97f0"
        const val API_PRIVATE_KEY_VALUE = "0dd0c16fedb8a02985977eafca66b49f5e6a526f"
        const val QUERY_FORMAT_NAME = "format"
        const val QUERY_FORMAT_VALUE = "comic"
        const val QUERY_FORMAT_TYPE_NAME = "formatType"
        const val QUERY_FORMAT_TYPE_VALUE = "comic"
        const val QUERY_ORDER_BY_NAME = "orderBy"
        const val QUERY_ORDER_BY_VALUE = "-issueNumber"
        const val QUERY_CHARACTER_NAME = "characters"
        const val QUERY_CHARACTER_VALUE = "1009718"
    }

    object Intent {
        const val KEY_COMIC_RESULT = "comic"
        const val KEY_COMIC_THUMBNAIL = "thumbnail"
    }
}