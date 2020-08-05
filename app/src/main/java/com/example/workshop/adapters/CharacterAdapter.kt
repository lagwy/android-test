package com.example.workshop.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.workshop.R
import com.example.workshop.api.models.Character

class CharacterAdapter(private val items: ArrayList<Character>, private val context : Context) : RecyclerView.Adapter<CharacterAdapter.ViewHolder>() {

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.setIsRecyclable(false)

        holder.tvWorld.text = item.world?.name
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.element_character_row, parent, false))
    }

    class ViewHolder (view: View) : RecyclerView.ViewHolder(view) {
        val tvWorld : TextView = view.findViewById(R.id.tv_world)
    }

}