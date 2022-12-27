package com.example.motionlayoutexample.views.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.motionlayoutexample.domain.Car
import com.example.motionlayoutexample.repository.CarProvider

class CarViewModel(private val carProvider: CarProvider) : ViewModel() {

    private val _carList = MutableLiveData<List<Car>>(emptyList())
    val carList: LiveData<List<Car>> get() = _carList

    init {
        loadCars()
    }

    fun carDelete(car: Car) = carProvider.deleteCar(car)

    private fun loadCars() {
        _carList.value = carProvider.getCars()
    }

}

@Suppress("UNCHECKED_CAST")
class CarViewModelFactory(private val carProvider: CarProvider) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return CarViewModel(carProvider) as T
    }
}