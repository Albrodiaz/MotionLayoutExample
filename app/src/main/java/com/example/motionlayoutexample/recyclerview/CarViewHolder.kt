package com.example.motionlayoutexample.recyclerview

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.motionlayoutexample.Car
import com.example.motionlayoutexample.databinding.ItemCarBinding

class CarViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val binding = ItemCarBinding.bind(view)

    fun render(car: Car, onCarClick: (Car) -> Unit, onCarDelete: (Car) -> Unit) {
        binding.brand.text = car.brand.toString()
        binding.model.text = car.model.toString()
        binding.horsePower.text = "${car.hp} Cv"
        binding.motor.text = "${car.motor} Cc"
        Glide.with(binding.carImage.context).load(car.photo).into(binding.carImage)
        binding.showIcon.setOnClickListener { onCarClick(car) }
        binding.deleteIcon.setOnClickListener { onCarDelete(car) }
    }
}