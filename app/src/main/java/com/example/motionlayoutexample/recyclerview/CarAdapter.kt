package com.example.motionlayoutexample.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.motionlayoutexample.Car
import com.example.motionlayoutexample.R

class CarAdapter(
    private var carList: List<Car>,
    private val onCarClick: (Car) -> Unit,
    private val onCarDelete: (Int) -> Unit
) : RecyclerView.Adapter<CarViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return CarViewHolder(layoutInflater.inflate(R.layout.item_car, parent, false))
    }

    override fun onBindViewHolder(holder: CarViewHolder, position: Int) {
        val item = carList[position]
        holder.render(item, onCarClick, onCarDelete)
    }

    override fun getItemCount(): Int = carList.size

    fun updateList(filteredList: List<Car>) {
        carList = filteredList
        notifyDataSetChanged()
    }

}