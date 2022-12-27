package com.example.motionlayoutexample.views.recyclerview

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.motionlayoutexample.databinding.ItemCarBinding
import com.example.motionlayoutexample.domain.Car
import com.example.motionlayoutexample.utilities.loadUrl

class CarViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val binding = ItemCarBinding.bind(view)

    fun render(
        car: Car,
        onCarClick: (Car) -> Unit,
        onCarDelete: (Car) -> Unit
    ) {
        binding.MainMotionLayout.transitionToStart()
        binding.brand.text = car.brand.toString()
        binding.model.text = car.model.toString()
        binding.horsePower.text = "${car.hp} Cv"
        binding.motor.text = "${car.motor} Cc"
        binding.carImage.loadUrl(car.photo.toString())
        binding.showIcon.setOnClickListener {
            onCarClick(car)
            binding.MainMotionLayout.transitionToStart()
        }
        binding.deleteIcon.setOnClickListener { onCarDelete(car) }

    }
}