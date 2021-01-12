package com.digitalhousedesafio3.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ItemXX(
    val name: String,
    val resourceURI: String,
    val type: String
): Parcelable