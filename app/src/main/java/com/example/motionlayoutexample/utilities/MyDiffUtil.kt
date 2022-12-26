package com.example.motionlayoutexample.utilities

import androidx.recyclerview.widget.DiffUtil
import com.example.motionlayoutexample.domain.Car

class MyDiffUtil(
    private val oldList: List<Car>,
    private val newList: List<Car>
): DiffUtil.Callback() {
    override fun getOldListSize(): Int = oldList.size

    override fun getNewListSize(): Int = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].brand == newList[newItemPosition].brand
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] == newList[newItemPosition]
    }
}