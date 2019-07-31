package com.neversaydie.andreii.growplants.presentation.screen

import com.neversaydie.andreii.growplants.R
import com.neversaydie.andreii.growplants.presentation.base.BaseRouter
import com.neversaydie.andreii.growplants.presentation.screen.game.GameFragment
import com.neversaydie.andreii.growplants.presentation.screen.game.GardenFragment
import com.neversaydie.andreii.growplants.presentation.screen.game.ToPlantFragment
import com.neversaydie.andreii.growplants.presentation.screen.game.plantfour.PlantFourFragment
import com.neversaydie.andreii.growplants.presentation.screen.game.plantsecond.PlantSecondFragment
import com.neversaydie.andreii.growplants.presentation.screen.game.plantthird.PlantThirdFragment
import com.neversaydie.andreii.growplants.presentation.screen.logo.LogoFragment

class GameRouter(activity: GameMainActivity) : BaseRouter<GameMainActivity>(activity) {

    fun goToLogo() {
        replaceFragment(activity.supportFragmentManager
                , LogoFragment()
                , R.id.fragmentConteiner, false)
    }

    fun goToGame() {
        replaceFragment(activity.supportFragmentManager
                , GameFragment()
                , R.id.fragmentConteiner, false)
    }

    fun goToPlant() {
        replaceFragment(activity.supportFragmentManager
                , ToPlantFragment()
                , R.id.fragmentConteiner, false)
    }

    fun goToGaerden() {
        replaceFragment(activity.supportFragmentManager
                , GardenFragment()
                , R.id.fragmentConteiner, false)
    }

    fun goToPlantSecond() {
        replaceFragment(activity.supportFragmentManager
                , PlantSecondFragment()
                , R.id.fragmentConteiner, false)
    }

    fun goToPlantThird() {
        replaceFragment(activity.supportFragmentManager
                , PlantThirdFragment()
                , R.id.fragmentConteiner, false)
    }

    fun goToPlantFour() {
        replaceFragment(activity.supportFragmentManager
                , PlantFourFragment()
                , R.id.fragmentConteiner, false)
    }

}