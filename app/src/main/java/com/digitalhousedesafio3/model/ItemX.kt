package com.digitalhousedesafio3.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ItemX(
    val name: String,
    val resourceURI: String,
    val role: String
) : Parcelable