package com.itenas.tisaapps.ui.weather

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.itenas.tisaapps.databinding.ItemWeatherBinding

class CuacaAdapter(private val list: List<CuacaDetail>) :
    RecyclerView.Adapter<CuacaAdapter.CuacaViewHolder>() {

    inner class CuacaViewHolder(val binding: ItemWeatherBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CuacaViewHolder {
        val binding = ItemWeatherBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return CuacaViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CuacaViewHolder, position: Int) {
        val item = list[position]
        with(holder.binding) {
            tvWaktu.text = item.local_datetime.substring(11, 16) + " WIB"
            tvDesc.text = item.weather_desc
            tvTemp.text = "${item.t}°C"

            Glide.with(root.context)
                .load(item.image)
                .into(imgIconCuaca)
        }
    }

    override fun getItemCount(): Int = list.size
}

