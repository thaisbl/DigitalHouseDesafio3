package com.digitalhousedesafio3.model

import android.os.Parcelable
import com.digitalhousedesafio3.model.ItemXX
import kotlinx.parcelize.Parcelize

@Parcelize
data class Stories(
    val available: Int,
    val collectionURI: String,
    val items: List<ItemXX>,
    val returned: Int
): Parcelable