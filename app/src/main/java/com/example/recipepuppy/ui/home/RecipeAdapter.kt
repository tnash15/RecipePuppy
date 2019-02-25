package com.example.recipepuppy.ui.home

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.recipepuppy.R
import com.example.recipepuppy.model.RecipeResponse

class RecipeAdapter : RecyclerView.Adapter<RecipeAdapter.RecipeViewHolder>() {

    private val data = arrayListOf<RecipeResponse>()

    fun setData(result: List<RecipeResponse>) {
        data.clear()
        data.addAll(result)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        val rootView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_activity, parent, false)
        return RecipeViewHolder(rootView)
    }

    override fun getItemCount() = data.size


    override fun onBindViewHolder(recipeViewHolder: RecipeViewHolder, position: Int) {
        recipeViewHolder.bind(data[position])
    }

    inner class RecipeViewHolder(val view: View) :
            RecyclerView.ViewHolder(view) {
        fun bind(data: RecipeResponse){
            val tvIngredients = view.findViewById<TextView>(R.id.tvIngredients)
            val tvDishName = view.findViewById<TextView>(R.id.tvDishName)
            tvIngredients.text = data.toString()
            tvDishName.text = data.title
        }
    }
}