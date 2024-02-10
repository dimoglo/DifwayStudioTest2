package com.example.difwaystudioproject.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.difwaystudioproject.R
import com.example.difwaystudioproject.databinding.FragmentMapBinding
import com.yandex.mapkit.MapKitFactory
import com.yandex.mapkit.mapview.MapView

class MapFragment: Fragment() {

    private lateinit var mapView: MapView
    private lateinit var binding: FragmentMapBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMapBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        MapKitFactory.initialize(requireContext())

        binding.viewPager.adapter = TestAdapter(requireContext(), itemCount = 5)
        binding.viewPager.orientation = ViewPager2.ORIENTATION_HORIZONTAL
        binding.viewPager.offscreenPageLimit = 2

        val cardMargin = resources.getDimensionPixelOffset(R.dimen.cardMargin)
        binding.viewPager.setPageTransformer { page, position ->
            val offset = position * -(cardMargin + cardMargin / 2)
            page.translationX = offset
        }

        // Возможность проскролливания до ячейки по индексу
        binding.header.setOnClickListener{
            binding.viewPager.currentItem = 3
        }
    }

    override fun onStart() {
        super.onStart()
        MapKitFactory.getInstance().onStart()
        binding.mapview.onStart()
    }

    override fun onStop() {
        binding.mapview.onStop()
        MapKitFactory.getInstance().onStop()
        super.onStop()
    }
}