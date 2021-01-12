package com.digitalhousedesafio3.view.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.digitalhousedesafio3.databinding.ComicItemBinding
import com.digitalhousedesafio3.model.Result

class MarvelHomeAdapter(
    private val comicsList: List<Result>,
    private val onComicClicked: (Result) -> Unit
) : RecyclerView.Adapter<MarvelHomeAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ComicItemBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(comic = comicsList[position], onComicClicked)
    }

    override fun getItemCount(): Int {
        return comicsList.size
    }


    class ViewHolder(
        private val binding: ComicItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        @SuppressLint("SetTextI18n")
        fun bind(comic: Result, onComicClicked: (Result) -> Unit) = with(binding) {
            Glide.with(itemView.context)
                .load("${comic.thumbnail?.path?.replace("http","https")}.${comic.thumbnail?.extension}")
                .into(ivComicCover)
            val issueNumber = comic.issueNumber.toString()
            tvComicNumber.text = "#$issueNumber"

            itemView.setOnClickListener {
                onComicClicked(comic)
            }
        }
    }

}