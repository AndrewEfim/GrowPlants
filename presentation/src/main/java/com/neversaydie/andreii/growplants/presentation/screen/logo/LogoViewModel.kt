package com.neversaydie.andreii.growplants.presentation.screen.logo

import android.content.SharedPreferences
import android.databinding.ObservableField
import android.preference.PreferenceManager
import android.util.Log
import com.neversaydie.andreii.growplants.presentation.app.App
import com.neversaydie.andreii.growplants.presentation.base.BaseViewModel
import com.neversaydie.andreii.growplants.presentation.screen.GameRouter
import com.neversaydie.andreii.growplants.presentation.util.MyConstant

class LogoViewModel : BaseViewModel<GameRouter>() {
    var sharedPref: SharedPreferences = PreferenceManager.getDefaultSharedPreferences(App.instance)
    var pregressLevel = ObservableField<String>("")
    var goToSecondPlant = ObservableField<String>("")
    var goToThierdPlant = ObservableField<String>("")
    val goToFourthPlant = ObservableField<String>("")

    init {
        pregressLevel.set(sharedPref.getString(MyConstant.PROGRESS_SAVE.toString(), "na"))
        goToSecondPlant.set(sharedPref.getString("PLANT_ONE", "na"))
        goToThierdPlant.set(sharedPref.getString("PLANT_TWO", "na"))
        goToFourthPlant.set(sharedPref.getString("PLANT_THREE", "na"))
    }

    fun checkProgress() {
        if (pregressLevel.get().toString().equals("BeanToPlant")) {
            router?.goToGame()
        }

    }

}