package com.digitalhousedesafio3.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Creators(
    val available: Int,
    val collectionURI: String,
    val items: List<ItemX>,
    val returned: Int
): Parcelable