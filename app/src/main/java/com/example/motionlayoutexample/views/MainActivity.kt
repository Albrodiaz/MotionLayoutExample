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
        listeners()
        observers()
    }

    private fun observers() {
        carViewModel.carList.observe(this) {
            adapter = CarAdapter(
                cars = it,
                onCarClick = { car -> showCar(car) },
                onCarDelete = { deleted ->
                    carViewModel.carDelete(deleted)
                    adapter.notifyItemRemoved(deleted)
                }
            )
            binding.mainRecycler.adapter = adapter
        }

        carViewModel.filteredList.observe(this) {
            adapter.updateList(it)
        }
    }

    private fun listeners() {
        binding.filterText.addTextChangedListener {
            carViewModel.setFilteredList(it.toString())
        }
    }

    private fun showCar(car: Car) {
        CarDetailFragment.inflateDetails(car)
            .show(supportFragmentManager, "FragmentTag")
    }
}