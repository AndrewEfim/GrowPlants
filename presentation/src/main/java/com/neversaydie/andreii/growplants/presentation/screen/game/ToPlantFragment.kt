package com.neversaydie.andreii.growplants.presentation.screen.game

import android.arch.lifecycle.ViewModelProviders
import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.view.View
import com.neversaydie.andreii.growplants.R
import com.neversaydie.andreii.growplants.databinding.FragmentToPlantBinding
import com.neversaydie.andreii.growplants.presentation.base.BaseMvvmFragment
import com.neversaydie.andreii.growplants.presentation.screen.GameRouter
import kotlinx.android.synthetic.main.fragment_to_plant.*
import java.util.*

class ToPlantFragment : BaseMvvmFragment<ToPlantViewModel, GameRouter, FragmentToPlantBinding>() {


    override fun provideViewModel(): ToPlantViewModel {
        return ViewModelProviders.of(this).get(ToPlantViewModel::class.java)
    }

    override fun provideLayoutId(): Int {
        return R.layout.fragment_to_plant
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        imageView_to_plant.setBackgroundResource(R.drawable.bean_animation)
        val animDraw: AnimationDrawable = imageView_to_plant.background as AnimationDrawable

        button_to_plant.setOnClickListener({
            animDraw.start()
            Timer().schedule(object : TimerTask() {
                override fun run() {
                    viewModel.saveProgress()
                    router?.goToGame()
                }
            }, 800)
        })
    }
}