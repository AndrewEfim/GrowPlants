package com.neversaydie.andreii.growplants.presentation.screen.logo

import android.arch.lifecycle.ViewModelProviders
import android.content.SharedPreferences
import android.os.Bundle
import android.preference.PreferenceManager
import android.view.View
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds
import com.neversaydie.andreii.growplants.R
import com.neversaydie.andreii.growplants.databinding.FragmentGameLogoBinding
import com.neversaydie.andreii.growplants.presentation.app.App
import com.neversaydie.andreii.growplants.presentation.base.BaseMvvmFragment
import com.neversaydie.andreii.growplants.presentation.screen.GameRouter
import kotlinx.android.synthetic.main.fragment_game_logo.*


class LogoFragment : BaseMvvmFragment<LogoViewModel, GameRouter, FragmentGameLogoBinding>() {


    var sharedPref: SharedPreferences = PreferenceManager.getDefaultSharedPreferences(App.instance)

    override fun provideViewModel(): LogoViewModel {
        return ViewModelProviders.of(this).get(LogoViewModel::class.java)
    }

    override fun provideLayoutId(): Int {
        return R.layout.fragment_game_logo
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // mAdView = findViewById(R.id.adView)
        //ca-app-pub-2168756955488044~9307750241
        MobileAds.initialize(App.instance.applicationContext, "ca-app-pub-2168756955488044~9307750241")

        val mAdView: AdView = adView
        val adRequest: AdRequest = AdRequest.Builder().build()

        mAdView.loadAd(adRequest)

        button_go_to_game.setOnClickListener {
            if (viewModel.pregressLevel.get().equals("BeanToPlant")
                    && (viewModel.goToSecondPlant.get().equals("na"))
                    && (viewModel.goToThierdPlant.get().equals("na"))
                    && (viewModel.goToFourthPlant.get().equals("na"))) {
                router?.goToGame()
            } else if ((viewModel.pregressLevel.get().equals("BeanToPlant"))
                    && (viewModel.goToSecondPlant.get().equals("plantOne")) &&
                    ((viewModel.goToThierdPlant.get().equals("na")))) {
                router?.goToPlantSecond()

            } else if ((viewModel.pregressLevel.get().equals("BeanToPlant"))
                    && (viewModel.goToSecondPlant.get().equals("plantOne"))
                    && ((viewModel.goToThierdPlant.get().equals("plantTwo")))
                    && ((viewModel.goToFourthPlant.get().equals("na")))) {
                router?.goToPlantThird()
            } else if ((viewModel.pregressLevel.get().equals("BeanToPlant"))
                    && (viewModel.goToSecondPlant.get().equals("plantOne"))
                    && ((viewModel.goToThierdPlant.get().equals("plantTwo")))
                    && ((viewModel.goToFourthPlant.get().equals("plantThree")))) {
                router?.goToPlantFour()

            } else if ((viewModel.pregressLevel.get().equals("na")//setZero
                            && (viewModel.goToSecondPlant.get().equals("na"))
                            && (viewModel.goToThierdPlant.get().equals("na"))
                            && (viewModel.goToFourthPlant.get().equals("na")))) {
                router?.goToPlant()
            }
        }
    }
}