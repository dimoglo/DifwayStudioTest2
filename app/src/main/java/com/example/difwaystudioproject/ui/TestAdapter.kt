package com.example.difwaystudioproject.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.difwaystudioproject.R

class TestAdapter(
    private val context: Context,
    private val itemCount: Int
) : RecyclerView.Adapter<TestAdapter.ViewHolder>() {

    override fun getItemCount(): Int {
        return itemCount
    }

    override fun onBindViewHolder(vh: ViewHolder, position: Int) {
        val text = "Машина $position"
        vh.pageNumberText.text = text
    }

    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int
    ): TestAdapter.ViewHolder {
        val layoutInflater = LayoutInflater.from(context)
        val card = layoutInflater.inflate(R.layout.card, parent, false)
        return ViewHolder(card)
    }

    inner class ViewHolder(card: View) : RecyclerView.ViewHolder(card) {
        val pageNumberText: TextView = card.findViewById(R.id.cardName)
    }
}