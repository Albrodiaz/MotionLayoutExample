package com.example.motionlayoutexample.views.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.motionlayoutexample.R
import com.example.motionlayoutexample.domain.Car
import com.example.motionlayoutexample.utilities.MyDiffUtil

class CarAdapter(
    var cars: List<Car>,
    private val onCarClick: (Car) -> Unit,
    private val onCarDelete: (Car) -> Unit
) : RecyclerView.Adapter<CarViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return CarViewHolder(layoutInflater.inflate(R.layout.item_car, parent, false))
    }

    override fun onBindViewHolder(holder: CarViewHolder, position: Int) {
        val item = cars[position]
        holder.render(item, onCarClick, onCarDelete)
    }

    override fun getItemCount(): Int = cars.size

    fun updateList(newList: List<Car>) {
        val result = DiffUtil.calculateDiff(MyDiffUtil(cars, newList))
        cars = newList as MutableList<Car>
        result.dispatchUpdatesTo(this)
    }

}