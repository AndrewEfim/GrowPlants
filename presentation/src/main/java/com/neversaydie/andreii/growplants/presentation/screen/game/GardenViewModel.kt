package com.neversaydie.andreii.growplants.presentation.screen.game

import android.content.SharedPreferences
import android.preference.PreferenceManager
import com.neversaydie.andreii.growplants.presentation.app.App
import com.neversaydie.andreii.growplants.presentation.base.BaseViewModel
import com.neversaydie.andreii.growplants.presentation.screen.GameRouter
import com.neversaydie.andreii.growplants.presentation.util.MyConstant
import java.util.*

class GardenViewModel:BaseViewModel<GameRouter>() {

    var sharedPref: SharedPreferences = PreferenceManager.getDefaultSharedPreferences(App.instance)

    var drawPlantOne = sharedPref.getString("PLANT_ONE","na")
    var drawPlantTwo = sharedPref.getString("PLANT_TWO","na")
    var drawPlantThree = sharedPref.getString("PLANT_THREE","na")
    var drawPlantFour = sharedPref.getString("PLANT_FOUR","na")
    var calendar: Calendar = Calendar.getInstance()

    var setOne = false
    var setTwo = false
    var setThree = false
    var setFour = false

    fun setOne(){
        if(drawPlantOne.equals("plantOne")){
            setOne=true
        }
    }
    fun setTwo(){
        if(drawPlantTwo.equals("plantTwo")){
            setTwo=true
        }
    }
    fun setThree(){
        if(drawPlantThree.equals("plantThree")){
            setThree=true
        }
    }
    fun setFour(){
        if(drawPlantFour.equals("plantFour")){
            setFour=true
        }
    }

    fun startDaySecondPlant(){
        sharedPref.edit().putInt("START_DAY_SECOND_PLANT",calendar.get(Calendar.DAY_OF_YEAR)).apply()
    }

    fun startDayThirdPlant(){
        sharedPref.edit().putInt("START_DAY_THIRD_PLANT",calendar.get(Calendar.DAY_OF_YEAR)).apply()
    }

    fun startDayFourthPlant(){
        sharedPref.edit().putInt("START_DAY_FOURTH_PLANT",calendar.get(Calendar.DAY_OF_YEAR)).apply()
    }

    fun setAllZero(){
        sharedPref.edit().putInt("START", 0).apply()
        sharedPref.edit().putInt("PICTURE", 0).apply()
        sharedPref.edit().putInt("GAME_DAY", 0).apply()
        sharedPref.edit().putInt("START_DAY_SECOND_PLANT", 0).apply()
        sharedPref.edit().putInt("PICTURE_SECOND_PLANT", 0).apply()
        sharedPref.edit().putInt("GAME_DAY_SECOND_PLANT", 0).apply()
        sharedPref.edit().putInt("START_DAY__THIRD_PLANT", 0).apply()
        sharedPref.edit().putInt("PICTURE_THIRD_PLANT", 0).apply()
        sharedPref.edit().putInt("GAME_DAY_THIRD_PLANT", 0).apply()
        sharedPref.edit().putInt("START_DAY_PLANT_FOUR", 0).apply()
        sharedPref.edit().putInt("PICTURE_PLANT_FOUR", 0).apply()
        sharedPref.edit().putInt("GAME_DAY_PLANT_FOUR", 0).apply()
        sharedPref.edit().putString("PLANT_ONE", "na").apply()
        sharedPref.edit().putString("PLANT_TWO", "na").apply()
        sharedPref.edit().putString("PLANT_THREE", "na").apply()
        sharedPref.edit().putString("PLANT_FOUR", "na").apply()
        sharedPref.edit().putString(MyConstant.PROGRESS_SAVE.toString(), "na").apply()
    }
}