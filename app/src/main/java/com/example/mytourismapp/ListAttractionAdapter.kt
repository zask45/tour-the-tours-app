package com.example.mytourismapp

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mytourismapp.databinding.RowAttractionPlaceBinding

class ListAttractionAdapter(private val listAttractionPlace: ArrayList<AttractionPlace>) : RecyclerView.Adapter<ListAttractionAdapter.AttractionPlaceHolder>() {

    class AttractionPlaceHolder(var binding: RowAttractionPlaceBinding) : RecyclerView.ViewHolder(binding.root) {
        val imgPhoto: ImageView = binding.attractionImage
        val tvName: TextView = binding.tvItemName
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AttractionPlaceHolder {
        val itemBinding = RowAttractionPlaceBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AttractionPlaceHolder(itemBinding)
    }

    override fun getItemCount(): Int = listAttractionPlace.size

    override fun onBindViewHolder(holder: AttractionPlaceHolder, position: Int) {
        val (name, description, photo) = listAttractionPlace[position]
        holder.binding.tvItemName.text = name
        holder.binding.attractionImage.setImageResource(photo)
        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, DetailActivity::class.java)
            intent.putExtra(DetailActivity.EXTRA_PLACE, listAttractionPlace[position])
            holder.itemView.context.startActivity(intent)
        }
    }
}