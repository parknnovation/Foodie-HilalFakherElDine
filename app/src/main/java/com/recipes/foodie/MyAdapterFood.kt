package com.recipes.foodie

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView

class MyAdapterFood(private val foodList : ArrayList<FoodType>) : RecyclerView.Adapter<MyAdapterFood.MyViewHolder>() {

    private lateinit var mListener : onItemClickListener

    interface onItemClickListener {

        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(listener: onItemClickListener) {

        mListener = listener
    }
//create instances of a ViewHolder , including working with the ViewHolder to set up the widgets
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder { // when views are first time created, this function will create the layout

        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return MyViewHolder(itemView, mListener)
    }

    override fun getItemCount(): Int {
        return foodList.size // the adapter will know how many items are there in the recyclerView - the size of the ArrayList
    }

    class MyViewHolder(itemView: View, listener: onItemClickListener) : RecyclerView.ViewHolder(itemView){ // refer to the items in the view of the recycler view

        val foodImage : ShapeableImageView = itemView.findViewById(R.id.BurgerImage)
        val foodName : TextView = itemView.findViewById(R.id.BurgerDescription)

        init {

            itemView.setOnClickListener {

                listener.onItemClick(adapterPosition)
            }
        }

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = foodList[position]
        holder.foodImage.setImageResource(currentItem.FoodImage)
        holder.foodName.text = currentItem.FoodName
    }

}