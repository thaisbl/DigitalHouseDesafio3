package com.digitalhousedesafio3.viewmodel

import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModel
import com.bumptech.glide.Glide
import com.digitalhousedesafio3.databinding.ActivityComicBinding
import com.digitalhousedesafio3.model.Result
import java.text.ParseException
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*

class ComicViewModel : ViewModel() {

    @RequiresApi(Build.VERSION_CODES.O)
    fun setContent(context: Context, comic: Result, binding: ActivityComicBinding) = with(binding) {

        Glide.with(context)
            .load("${comic.thumbnail?.path?.replace("http","https")}.${comic.thumbnail?.extension}")
            .into(ivComicCover)


        if(comic.images.size >=2) {
            Glide.with(context)
                .load("${comic.images[1].path?.replace("http","https")}.${comic.images[1].extension}")
                .into(ivLandscape)
        } else {
            Glide.with(context)
                .load("${comic.images[0].path?.replace("http","https")}.${comic.images[0].extension}")
                .into(ivLandscape)
        }

        tvTitle.text = comic.title

        if (comic.description.isNullOrEmpty()) {
            tvDescription.text = "No description avaible"
        } else {
            tvDescription.text = comic.description
        }


        if(comic.dates?.get(0)?.type=="onsaleDate") {
            val date = comic.dates[0].date
            val toDate = DateTimeFormatter.ofPattern("MMMM dd, yyyy")
            val dateFormatted= LocalDate.parse(date.substring(0, 19), DateTimeFormatter.ISO_LOCAL_DATE_TIME)
            tvPublishedContent.text = toDate.format(dateFormatted)
        }
        tvPriceContent.text = "$ ${comic.prices[0].price}"
        tvPagesContent.text = comic.pageCount.toString()
    }

}