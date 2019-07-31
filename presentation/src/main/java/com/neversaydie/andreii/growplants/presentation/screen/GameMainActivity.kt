package com.neversaydie.andreii.growplants.presentation.screen

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import com.google.android.gms.ads.MobileAds
import com.neversaydie.andreii.growplants.R
import com.neversaydie.andreii.growplants.databinding.ActivityMainBinding
import com.neversaydie.andreii.growplants.presentation.base.BaseMvvmActivity

class GameMainActivity : BaseMvvmActivity<GameMainViewModel, GameRouter, ActivityMainBinding>() {


    override fun provideViewModel(): GameMainViewModel {
        return ViewModelProviders.of(this).get(GameMainViewModel::class.java)
    }

    override fun provideRouter(): GameRouter {
        return GameRouter(this)
    }

    override fun provideLayourId(): Int {
        return R.layout.activity_main
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Sample AdMob app ID: ca-app-pub-2168756955488044~9307750241
       // MobileAds.initialize(this, "ca-app-pub-2168756955488044~9307750241")
        if (savedInstanceState == null) {
            router?.goToLogo()
        }
    }
}