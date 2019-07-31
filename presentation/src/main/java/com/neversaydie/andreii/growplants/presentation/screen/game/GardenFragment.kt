package com.neversaydie.andreii.growplants.presentation.screen.game

import android.arch.lifecycle.ViewModelProviders
import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import android.util.Log
import android.view.View
import com.neversaydie.andreii.growplants.R
import com.neversaydie.andreii.growplants.databinding.FragmentGardenBinding
import com.neversaydie.andreii.growplants.presentation.base.BaseMvvmFragment
import com.neversaydie.andreii.growplants.presentation.screen.GameRouter
import kotlinx.android.synthetic.main.fragment_garden.*

class GardenFragment : BaseMvvmFragment<GardenViewModel, GameRouter, FragmentGardenBinding>() {

    override fun provideViewModel(): GardenViewModel {
        return ViewModelProviders.of(this).get(GardenViewModel::class.java)

    }

    override fun provideLayoutId(): Int {
        return R.layout.fragment_garden

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        button_all_zero.visibility = View.INVISIBLE
        button_new_plant.visibility = View.VISIBLE

        viewModel.setOne()
        viewModel.setTwo()
        viewModel.setThree()
        viewModel.setFour()


        val drawone: BitmapDrawable = activity?.resources?.getDrawable(R.drawable.first_plant_seven) as BitmapDrawable
        val drawtwo: BitmapDrawable = activity?.resources?.getDrawable(R.drawable.second_plant_seven) as BitmapDrawable
        val drawthree: BitmapDrawable = activity?.resources?.getDrawable(R.drawable.third_plant_seven) as BitmapDrawable
        val drawfour: BitmapDrawable = activity?.resources?.getDrawable(R.drawable.fourth_plant_eight) as BitmapDrawable

        if (viewModel.setOne == true) {
            imageView_garden_plant_one.background = drawone
        }

        if (viewModel.setTwo == true) {
            imageView_garden_plant_two.background = drawtwo
        }

        if (viewModel.setThree == true) {
            imageView_garden_plant_three.background = drawthree
        }

        if (viewModel.setFour == true) {
            imageView_garden_plant_four.background = drawfour
            button_all_zero.visibility = View.VISIBLE
            button_new_plant.visibility = View.INVISIBLE
        }

        button_new_plant.setOnClickListener({

            if ((viewModel.setOne == true) && (viewModel.setTwo == false) && (viewModel.setThree == false)) {
                viewModel.startDaySecondPlant()
                router?.goToPlantSecond()
            } else if ((viewModel.setOne == true) && (viewModel.setTwo == true) && (viewModel.setThree == false)) {
                viewModel.startDayThirdPlant()
                router?.goToPlantThird()
            } else if ((viewModel.setOne == true) && (viewModel.setTwo == true) && (viewModel.setThree == true)) {
                viewModel.startDayFourthPlant()
                router?.goToPlantFour()
            }
        })

        button_all_zero.setOnClickListener({
            viewModel.setAllZero()
            router?.goToLogo()
        })
    }
}