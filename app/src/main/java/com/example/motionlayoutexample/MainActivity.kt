package com.example.motionlayoutexample

import android.os.Bundle
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
        carFilter()
        initRecylcer()
    }

    private fun initRecylcer() {
        adapter = CarAdapter(
            carList = carList,
            onCarClick = { car -> showCar(car) },
            onCarDelete = { deleted -> carDelete(deleted) })
        binding.mainRecycler.adapter = adapter
    }

    private fun showCar(car: Car) {
        CarDetailFragment.inflateDetails(car)
            .show(supportFragmentManager, "FragmentTag")
    }

    private fun carDelete(position: Int) {
        carList.removeAt(position)
        adapter.notifyItemRemoved(position)
    }

    private fun carFilter() {
        binding.filterText.addTextChangedListener { filterText ->
            adapter.updateList(carList.filter { car ->
                car.brand.toString().lowercase()
                    .contains(filterText.toString().lowercase())
            })
        }
    }
}