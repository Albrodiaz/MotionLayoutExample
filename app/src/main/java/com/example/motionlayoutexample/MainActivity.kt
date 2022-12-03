package com.example.motionlayoutexample

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import com.example.motionlayoutexample.databinding.ActivityMainBinding
import com.example.motionlayoutexample.recyclerview.CarAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var carList: MutableList<Car> = CarProvider.carList.toMutableList()
    private lateinit var adapter: CarAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initRecylcer()
        filteredList()
    }

    private fun initRecylcer() {
        adapter = CarAdapter(
            carList = carList,
            onCarClick = { car -> carSelected(car) },
            onCarDelete = { deleted -> carDelete(deleted) })
        binding.mainRecycler.adapter = adapter
    }

    private fun filteredList() {
        binding.filterText.addTextChangedListener { filter ->
            val filteredList = carList.filter { car ->
                car.brand.toString().lowercase().contains(filter.toString().lowercase()) ||
                        car.model.toString().lowercase().contains(filter.toString().lowercase())
            }
            adapter.updateCarList(filteredList)
            adapter.notifyDataSetChanged()
        }
    }

    private fun carSelected(car: Car) {
        Toast.makeText(this, "Item pulsado: ${car.brand} ${car.model}", Toast.LENGTH_SHORT).show()
    }

    private fun carDelete(position: Int) {
        carList.removeAt(position)
        adapter.notifyItemRemoved(position)
    }
}