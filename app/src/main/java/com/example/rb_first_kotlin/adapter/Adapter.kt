package com.example.rb_first_kotlin.adapter

import android.content.Context
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.rb_first_kotlin.databinding.CountryLayoutBinding
import com.example.rb_first_kotlin.model.Country
import com.github.twocoffeesoneteam.glidetovectoryou.GlideToVectorYou

class Adapter(private val dataSet: List<Country>) : RecyclerView.Adapter<Adapter.ViewHolder>() {

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    class ViewHolder(private val binding: CountryLayoutBinding) : RecyclerView.ViewHolder(binding.root) {

        fun set(item: Country) {
            binding.tvName.text = item.name
//            Glide.with(this.itemView).load(Uri.parse(item.flag)).into(binding.ivFlag)
            GlideToVectorYou
                .init()
                .with(binding.root.context)
                .load(Uri.parse(item.flag), binding.ivFlag);
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = CountryLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.set(dataSet[position])
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

}