package com.example.motionlayoutexample.views.recyclerview

import android.view.View
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.motionlayoutexample.domain.Car
import com.example.motionlayoutexample.databinding.ItemCarBinding

class CarViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val binding = ItemCarBinding.bind(view)

    fun render(
        car: Car,
        onCarClick: (Car) -> Unit,
        onCarDelete: (Int) -> Unit
    ) {
        binding.MainMotionLayout.transitionToStart()
        binding.brand.text = car.brand.toString()
        binding.model.text = car.model.toString()
        binding.horsePower.text = "${car.hp} Cv"
        binding.motor.text = "${car.motor} Cc"
        Glide.with(binding.carImage.context).load(car.photo).into(binding.carImage)
        binding.showIcon.setOnClickListener {
            onCarClick(car)
            binding.MainMotionLayout.transitionToStart()
        }
        binding.deleteIcon.setOnClickListener { onCarDelete(adapterPosition) }

    }
}