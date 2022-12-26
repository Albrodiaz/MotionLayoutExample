package com.example.motionlayoutexample.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.bumptech.glide.Glide
import com.example.motionlayoutexample.R
import com.example.motionlayoutexample.databinding.FragmentCarDetailBinding
import com.example.motionlayoutexample.domain.Car

class CarDetailFragment : DialogFragment() {

    private lateinit var binding: FragmentCarDetailBinding
    private var car: Car? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let { bundle ->
            car = bundle.getParcelable(CAR_PARAM)
        }
        setStyle(STYLE_NO_FRAME, R.style.Theme_MotionLayoutExample)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCarDetailBinding.inflate(inflater, container, false)

        Glide.with(binding.imageDetail.context).load(car?.photo).into(binding.imageDetail)
        binding.brandDetail.text = car?.brand
        binding.modelDetail.text = car?.model
        binding.performanceDetail.text = "${car?.hp} Cv, ${car?.motor} Cc"

        binding.closeIcon.setOnClickListener { dismiss() }

        return binding.root
    }

    companion object {
        private const val CAR_PARAM = "car_param"

        @JvmStatic
        fun inflateDetails(car: Car) =
            CarDetailFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(CAR_PARAM, car)
                }
            }
    }
}