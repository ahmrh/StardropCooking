package com.example.stardropcooking

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.stardropcooking.databinding.ItemRowCookingBinding

class ListCookingAdapter(private val listCooking: ArrayList<Cooking>) : RecyclerView.Adapter<ListCookingAdapter.ListViewHolder>() {
    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Cooking, id: Int)
    }

    class ListViewHolder(var binding: ItemRowCookingBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val binding = ItemRowCookingBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(binding)
    }

    override fun getItemCount(): Int = listCooking.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, photo, shortDescr) = listCooking[position]
        Log.d("Variable Logging", photo)
        Glide.with(holder.binding.imgItemPhoto.context)
            .load(photo)
            .into(holder.binding.imgItemPhoto)

        holder.binding.tvItemName.text = name
        holder.binding.tvItemShortDesc.text = shortDescr

        holder.binding.root.setOnClickListener{
            onItemClickCallback.onItemClicked(listCooking[holder.adapterPosition], holder.adapterPosition)
        }
    }
}