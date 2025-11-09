package com.itenas.tisaapps.ui.news

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.itenas.tisaapps.databinding.ItemNewsBinding

class NewsAdapter(private val list: List<News>) :
    RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {

    inner class NewsViewHolder(val binding: ItemNewsBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val binding = ItemNewsBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return NewsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val item = list[position]
        with(holder.binding){
            imgNews.setImageResource(item.image)
            tvNewsTitle.text = item.title
            tvNewsDate.text = item.date
            tvNewsDesc.text = item.desc
        }
    }

    override fun getItemCount() = list.size
}
