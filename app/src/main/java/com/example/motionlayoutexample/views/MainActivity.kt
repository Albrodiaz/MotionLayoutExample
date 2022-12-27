package com.example.motionlayoutexample.views

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import com.example.motionlayoutexample.databinding.ActivityMainBinding
import com.example.motionlayoutexample.domain.Car
import com.example.motionlayoutexample.repository.CarProvider
import com.example.motionlayoutexample.views.recyclerview.CarAdapter
import com.example.motionlayoutexample.views.viewmodel.CarViewModel
import com.example.motionlayoutexample.views.viewmodel.CarViewModelFactory

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: CarAdapter
    private val carViewModel: CarViewModel by viewModels { CarViewModelFactory(CarProvider()) }

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        observers()
        listeners()
    }

    private fun observers() {
        carViewModel.carList.observe(this) { cars ->
            adapter = CarAdapter(
                cars = cars.toMutableList(),
                onCarClick = { car -> showCar(car) },
                onCarDelete = { deleted -> deleteCar(deleted) }
            )
            binding.mainRecycler.adapter = adapter

        }
    }

    private fun listeners() {
        binding.filterText.addTextChangedListener { userText ->
            val filteredList = carViewModel.carList.value!!.filter { car ->
                car.brand.toString().lowercase().contains(userText.toString().lowercase())
            }
            adapter.updateList(filteredList)
        }
    }


    private fun showCar(car: Car) {
        CarDetailFragment.inflateDetails(car)
            .show(supportFragmentManager, "FragmentTag")
    }

    private fun deleteCar(car: Car) {
        carViewModel.carDelete(car)
        adapter.cars.drop(1)
        binding.filterText.setText("")
    }

}