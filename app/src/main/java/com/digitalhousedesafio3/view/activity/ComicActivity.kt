package com.digitalhousedesafio3.view.activity

import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModelProvider
import com.digitalhousedesafio3.databinding.ActivityComicBinding
import com.digitalhousedesafio3.model.Result
import com.digitalhousedesafio3.utils.Constants.Intent.KEY_COMIC_RESULT
import com.digitalhousedesafio3.utils.Constants.Intent.KEY_COMIC_THUMBNAIL
import com.digitalhousedesafio3.viewmodel.ComicViewModel

class ComicActivity : BaseActivity() {

    private lateinit var binding: ActivityComicBinding
    private lateinit var viewModel: ComicViewModel
    private var comic: Result? = null

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityComicBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(ComicViewModel::class.java)

        comic = intent.getParcelableExtra(KEY_COMIC_RESULT)
        comic?.let {
            viewModel.setContent(this, it, binding)
        }

        setupObservables()
    }

    private fun setupObservables() {
        binding.backButton.setOnClickListener {
            onBackPressed()
        }

        binding.ivComicCover.setOnClickListener {
            val intent = Intent(this, PopUpActivity::class.java)
            intent.putExtra(KEY_COMIC_THUMBNAIL, comic?.thumbnail)
            startActivity(intent)
        }
    }

}