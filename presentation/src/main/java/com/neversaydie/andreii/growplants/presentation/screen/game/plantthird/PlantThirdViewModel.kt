package com.neversaydie.andreii.growplants.presentation.screen.game.plantthird

import android.content.SharedPreferences
import android.databinding.ObservableField
import android.preference.PreferenceManager
import com.neversaydie.andreii.growplants.presentation.app.App
import com.neversaydie.andreii.growplants.presentation.base.BaseViewModel
import com.neversaydie.andreii.growplants.presentation.screen.GameRouter
import com.neversaydie.andreii.growplants.presentation.util.MyConstant
import com.neversaydie.andreii.growplants.presentation.util.MyConstnts
import java.util.*

class PlantThirdViewModel : BaseViewModel<GameRouter>() {

    var sharedPref: SharedPreferences = PreferenceManager.getDefaultSharedPreferences(App.instance)

    var click: Int = 0
    var waterIsEnable = false
    var clickProgressThirdPlant = ObservableField<Int>(0)
    var changePicture = sharedPref.getInt("PICTURE_THIRD_PLANT", 0)
    var startDay = sharedPref.getInt("START_DAY_THIRD_PLANT", 0)
    var gameDay = (startDay - 1)
    var calendar: Calendar = Calendar.getInstance()
    var nowDay = calendar.get(Calendar.DAY_OF_YEAR)
    var textNextWater = false
    var setText = false
    var setVisibleGardenButton = false

    init {

        if (gameDay == 0) {
            gameDay = (startDay - 1)
        } else if (gameDay != 0) {
            gameDay = sharedPref.getInt("GAME_DAY_THIRD_PLANT", gameDay)
        }
    }

    fun checkGameDay() {
        if (gameDay == 0) {
            gameDay = (startDay - 1)
        } else if (gameDay != 0) {
            gameDay = sharedPref.getInt("GAME_DAY_THIRD_PLANT", gameDay)
        }
    }

    fun plantIsGrow() {
        if (changePicture >= 6) {
            setText = true
            setVisibleGardenButton = true
        }
    }

    fun mainClik() {
        click++
        clickProgressThirdPlant.set(click)
        if (click >= MyConstnts.IntegerConstant.CLICK_NUMBER) {
            waterIsEnable = true
            checkDay()
        }
    }

    fun mainWater() {
        click = 0
        changePicture++
        gameDay++
        waterIsEnable = false
        if (changePicture >= 6) {
            setText = true
            setVisibleGardenButton = true
            sharedPref.edit().putString("PLANT_THREE", "plantThree").apply()
        }
    }

    fun checkDay() {
        if (gameDay == nowDay) {
            waterIsEnable = true
        } else if (gameDay == (nowDay + 1)) {
            waterIsEnable = false
            textNextWater = true
        }
    }

    fun saveMainProgress() {
        sharedPref.edit().putBoolean("WATER_IS_ENABLE_THIRD_PLANT", waterIsEnable).apply()
        sharedPref.edit().putInt("PICTURE_THIRD_PLANT", changePicture).apply()
        sharedPref.edit().putInt("CLICK_PROGRESS_THIRD_PLANT", clickProgressThirdPlant.get()!!).apply()
        sharedPref.edit().putInt("GAME_DAY_THIRD_PLANT", gameDay).apply()
    }

    fun setZero() {
        sharedPref.edit().putInt("START_DAY__THIRD_PLANT", 0).apply()
        sharedPref.edit().putInt("PICTURE_THIRD_PLANT", 0).apply()
        sharedPref.edit().putInt("GAME_DAY_THIRD_PLANT", 0).apply()
        sharedPref.edit().putString(MyConstant.PROGRESS_SAVE.toString(), "setZero").apply()
    }
}