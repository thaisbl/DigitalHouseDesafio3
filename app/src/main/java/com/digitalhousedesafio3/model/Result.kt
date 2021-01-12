package com.digitalhousedesafio3.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Result(
    val characters: Characters?,
    val creators: Creators?,
    val dates: List<Date>?,
    var description: String?,
    val diamondCode: String?,
    val digitalId: Int?,
    val ean: String?,
    val events: Events?,
    val format: String?,
    val id: Int?,
    val images: List<Image>,
    val isbn: String?,
    val issn: String?,
    val issueNumber: Int?,
    val modified: String?,
    val pageCount: Int?,
    val prices: List<Price>,
    val resourceURI: String?,
    val series: Series?,
    val stories: Stories?,
    val textObjects: List<TextObject>?,
    var thumbnail: Thumbnail?,
    val title: String?,
    val upc: String?,
    val urls: List<Url>?,
    val variantDescription: String?,
    val variants: List<Variant>?
) : Parcelable