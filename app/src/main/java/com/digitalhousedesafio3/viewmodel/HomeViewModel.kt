package com.digitalhousedesafio3.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.digitalhousedesafio3.api.ResponseApi
import com.digitalhousedesafio3.business.MarvelHomeBusiness
import com.digitalhousedesafio3.model.Comics
import com.digitalhousedesafio3.model.Result
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {

    val onResultComics: MutableLiveData<Comics> = MutableLiveData()
    val onResultFailure: MutableLiveData<String> = MutableLiveData()

    private val business by lazy {
        MarvelHomeBusiness()
    }

    fun getComics() {
        viewModelScope.launch {
            when (val response = business.getComics()) {
                is ResponseApi.Success -> {
                    onResultComics.postValue(
                        response.data as Comics
                    )
                }
                is ResponseApi.Error -> {
                    onResultFailure.postValue(response.message)
                }
            }
        }
    }

}