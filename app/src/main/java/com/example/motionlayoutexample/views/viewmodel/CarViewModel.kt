package com.example.motionlayoutexample.views.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.motionlayoutexample.domain.Car
import com.example.motionlayoutexample.repository.CarProvider
import com.example.motionlayoutexample.views.recyclerview.CarAdapter

class CarViewModel(private val carProvider: CarProvider): ViewModel() {

    private val _carList = MutableLiveData<List<Car>>(emptyList())
    val carList: LiveData<List<Car>> get() = _carList

    private val _filteredList = MutableLiveData<List<Car>>(emptyList())
    val filteredList: LiveData<List<Car>> get() = _filteredList

    init {
        _carList.value = carProvider.getCars()
        _filteredList.value = carProvider.getCars()
    }

    fun carDelete(car: Car) {
        carProvider.deleteCar(car)
        _carList.value = carProvider.getCars()
    }

    fun setFilteredList(userText: String) {
        val filteredList = _carList.value!!.filter { car ->
            car.brand.toString().lowercase().contains(
                userText.lowercase()
            )
        }
        _filteredList.value = filteredList
    }

}

@Suppress("UNCHECKED_CAST")
class CarViewModelFactory(private val carProvider: CarProvider): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return CarViewModel(carProvider) as T
    }
}