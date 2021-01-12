package com.digitalhousedesafio3.view.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.digitalhousedesafio3.databinding.ActivityPopUpBinding
import com.digitalhousedesafio3.model.Thumbnail
import com.digitalhousedesafio3.utils.Constants.Intent.KEY_COMIC_THUMBNAIL

class PopUpActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPopUpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPopUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setImage()
        setupObservables()
    }

    private fun setupObservables() {
        binding.closeButton.setOnClickListener {
            onBackPressed()
        }
    }

    private fun setImage() {
        val thumbnail = intent.getParcelableExtra<Thumbnail>(KEY_COMIC_THUMBNAIL)
        Glide.with(this)
            .load("${thumbnail?.path?.replace("http", "https")}.${thumbnail?.extension}")
            .into(binding.ivComicCover)
    }
}