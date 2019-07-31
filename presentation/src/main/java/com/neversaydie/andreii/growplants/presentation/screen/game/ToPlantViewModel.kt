package com.neversaydie.andreii.growplants.presentation.screen.game

import android.content.SharedPreferences
import android.preference.PreferenceManager
import android.util.Log
import com.neversaydie.andreii.growplants.presentation.app.App
import com.neversaydie.andreii.growplants.presentation.base.BaseViewModel
import com.neversaydie.andreii.growplants.presentation.screen.GameRouter
import com.neversaydie.andreii.growplants.presentation.util.MyConstant
import java.util.*

class ToPlantViewModel : BaseViewModel<GameRouter>() {
    var sharedPref: SharedPreferences = PreferenceManager.getDefaultSharedPreferences(App.instance)
    var calendar: Calendar = Calendar.getInstance()

    fun saveProgress() {
        sharedPref.edit().putString(MyConstant.PROGRESS_SAVE.toString(), "BeanToPlant").apply()
        sharedPref.edit().putInt("START", calendar.get(Calendar.DAY_OF_YEAR)).apply()//DAY_OF_YEAR
    }
}