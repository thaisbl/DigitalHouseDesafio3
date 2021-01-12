package com.digitalhousedesafio3.view.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.digitalhousedesafio3.databinding.ActivityHomeBinding
import com.digitalhousedesafio3.model.Result
import com.digitalhousedesafio3.utils.Constants.Intent.KEY_COMIC_RESULT
import com.digitalhousedesafio3.utils.MockData
import com.digitalhousedesafio3.view.adapter.MarvelHomeAdapter
import com.digitalhousedesafio3.viewmodel.HomeViewModel


class HomeActivity : BaseActivity() {

    private lateinit var viewModel: HomeViewModel
    private lateinit var binding: ActivityHomeBinding
    val mockData by lazy {
        MockData()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        viewModel.getComics()
        setupObservables()
    }


    private fun setupObservables() {
        viewModel.onResultComics.observe(this, {
            it?.data?.let { comics ->
                setupRecyclerView(comics.results)
            }
        })

        viewModel.onResultFailure.observe(this, {
            it?.let {
                Toast.makeText(this, it, Toast.LENGTH_LONG).show()
                setupRecyclerView(mockData.list)
            }
        })
    }

    private fun setupRecyclerView(comics: List<Result>) {
        binding.recyclerViewComics.apply {
            layoutManager = GridLayoutManager(this@HomeActivity, 3)
            adapter = MarvelHomeAdapter(comics) {
                val intent = Intent(this@HomeActivity, ComicActivity::class.java)
                intent.putExtra(KEY_COMIC_RESULT, it)
                startActivity(intent)
            }
        }
    }
}