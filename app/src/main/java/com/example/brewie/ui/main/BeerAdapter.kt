package com.example.brewie.ui.main

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.brewie.R
import com.example.brewie.model.Beer
import kotlinx.android.synthetic.main.card_beer.view.*

class BeerAdapter constructor(
    private val context: Context,
    private var beers: List<Beer>) : RecyclerView.Adapter<BeerAdapter.ViewHolder>() {


    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.card_beer, viewGroup, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val beer = beers[position]

        beer.image_url?.let {
            val image = beer.image_url
            if (image != "") {
                Glide.with(context).load(image).into(holder.ivImage)
            }
        }

        holder.beerName.text = beer.name
        holder.beerAlcohol.text = beer.abv.toString()
    }

    override fun getItemCount() = beers.size

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var ivImage: ImageView = view.ivImage
        var beerName: TextView = view.beerName
        var beerAlcohol: TextView = view.beerAlcohol
    }
}