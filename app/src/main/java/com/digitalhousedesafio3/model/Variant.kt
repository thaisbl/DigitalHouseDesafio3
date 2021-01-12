package com.digitalhousedesafio3.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Variant(
    val name: String,
    val resourceURI: String
): Parcelable