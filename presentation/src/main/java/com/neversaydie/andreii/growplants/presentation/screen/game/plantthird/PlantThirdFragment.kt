package com.neversaydie.andreii.growplants.presentation.screen.game.plantthird

import android.arch.lifecycle.ViewModelProviders
import android.graphics.drawable.AnimationDrawable
import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import android.view.View
import com.neversaydie.andreii.growplants.R
import com.neversaydie.andreii.growplants.databinding.FragmentPlantThirdBinding
import com.neversaydie.andreii.growplants.presentation.base.BaseMvvmFragment
import com.neversaydie.andreii.growplants.presentation.screen.GameRouter
import kotlinx.android.synthetic.main.fragment_game.*
import kotlinx.android.synthetic.main.fragment_plant_third.*
import java.util.*

class PlantThirdFragment : BaseMvvmFragment<PlantThirdViewModel, GameRouter, FragmentPlantThirdBinding>() {
    val handleTouch = object : View.OnTouchListener {
        override fun onTouch(v: View, event: MotionEvent): Boolean {
            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                    viewModel.mainClik()
                    activeWaterButton()
                    nextWater()
                    setTextToGrowth()
                    setVisibile()
                }

            }
            return true
        }
    }

    private fun activeWaterButton() {
        if (viewModel.waterIsEnable == true) {
            button_game_water_third.isClickable = true
            button_game_water_third.visibility = View.VISIBLE
        } else if (viewModel.waterIsEnable == false) {
            button_game_water_third.isClickable = false
            button_game_water_third.visibility = View.INVISIBLE
        }
    }

    override fun provideViewModel(): PlantThirdViewModel {
        return ViewModelProviders.of(this).get(PlantThirdViewModel::class.java)
    }

    override fun provideLayoutId(): Int = R.layout.fragment_plant_third

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activeWaterButton()
        view.setOnTouchListener(handleTouch)

        val drawone: BitmapDrawable = activity?.resources?.getDrawable(R.drawable.third_plant_one) as BitmapDrawable
        val drawtwo: BitmapDrawable = activity?.resources?.getDrawable(R.drawable.third_plant_two) as BitmapDrawable
        val drawtree: BitmapDrawable = activity?.resources?.getDrawable(R.drawable.third_plant_three) as BitmapDrawable
        val drawfour: BitmapDrawable = activity?.resources?.getDrawable(R.drawable.third_plant_four) as BitmapDrawable
        val drawfive: BitmapDrawable = activity?.resources?.getDrawable(R.drawable.third_plant_five) as BitmapDrawable
        val drawsix: BitmapDrawable = activity?.resources?.getDrawable(R.drawable.third_plant_six) as BitmapDrawable
        val drawseven: BitmapDrawable = activity?.resources?.getDrawable(R.drawable.third_plant_seven) as BitmapDrawable

        imageView_leika_third.setBackgroundResource(R.drawable.water_animation)
        textView_next_water_third.visibility = View.INVISIBLE

        imageView_leika_third.visibility = View.INVISIBLE

        val animDraw: AnimationDrawable = imageView_leika_third.background as AnimationDrawable
        fun setImage() {
            if (viewModel.changePicture == 0) {
                imageView_plant_third.background = drawone

            } else if (viewModel.changePicture == 1) {
                imageView_plant_third.background = drawtwo

            } else if (viewModel.changePicture == 2) {
                imageView_plant_third.background = drawtree

            } else if (viewModel.changePicture == 3) {
                imageView_plant_third.background = drawfour
            } else if (viewModel.changePicture == 4) {
                imageView_plant_third.background = drawfive

            } else if (viewModel.changePicture == 5) {
                imageView_plant_third.background = drawsix
            } else if (viewModel.changePicture >= 6) {
                imageView_plant_third.background = drawseven
            }
        }


        button_game_water_third.isClickable = false
        fun activeWaterButton() {
            if (viewModel.waterIsEnable == true) {
                button_game_water_third.isClickable = true
                button_game_water_third.visibility = View.VISIBLE

            } else if (viewModel.waterIsEnable == false) {
                button_game_water_third.isClickable = false
                button_game_water_third.visibility = View.INVISIBLE

            }
        }

        if (viewModel.waterIsEnable) {
            button_game_water_third.isClickable = true
        } else {
            button_game_water_third.isClickable = false
        }

        button_game_water_third.setOnClickListener({
            imageView_leika_third.visibility = View.VISIBLE
            animDraw.start()
            Timer().schedule(object : TimerTask() {
                override fun run() {
                    animDraw.stop()
                }
            }, 1800)
            viewModel.mainWater()
            setImage()
            activeWaterButton()
            viewModel.saveMainProgress()
            nextWater()
            setTextToGrowth()
            setVisibile()
        })

        button_to_the_garden_third.setOnClickListener({
            router?.goToGaerden()
        })
    }

    override fun onStart() {
        super.onStart()
        viewModel.checkGameDay()
        setImage()
        setTextToGrowth()
        setVisibile()
    }

    fun nextWater() {
        if (viewModel.textNextWater == true) {
            textView_next_water_third.visibility = View.VISIBLE
        } else if (viewModel.textNextWater == false) {
            textView_next_water_third.visibility = View.INVISIBLE
        }
    }

    fun setVisibile() {
        if (viewModel.setVisibleGardenButton == true) {
            button_to_the_garden_third.visibility = View.VISIBLE
        } else if (viewModel.setVisibleGardenButton == false) {
            button_to_the_garden_third.visibility = View.INVISIBLE
        }
    }

    fun setTextToGrowth() {
        if (viewModel.setText == true) {
            textView_plant_is_grow_third.visibility = View.VISIBLE
        } else if (viewModel.setVisibleGardenButton == false) {
            textView_plant_is_grow_third.visibility = View.INVISIBLE
        }
    }

    private fun setImage() {

        val drawone: BitmapDrawable = activity?.resources?.getDrawable(R.drawable.third_plant_one) as BitmapDrawable
        val drawtwo: BitmapDrawable = activity?.resources?.getDrawable(R.drawable.third_plant_two) as BitmapDrawable
        val drawtree: BitmapDrawable = activity?.resources?.getDrawable(R.drawable.third_plant_three) as BitmapDrawable
        val drawfour: BitmapDrawable = activity?.resources?.getDrawable(R.drawable.third_plant_four) as BitmapDrawable
        val drawfive: BitmapDrawable = activity?.resources?.getDrawable(R.drawable.third_plant_five) as BitmapDrawable
        val drawsix: BitmapDrawable = activity?.resources?.getDrawable(R.drawable.third_plant_six) as BitmapDrawable
        val drawseven: BitmapDrawable = activity?.resources?.getDrawable(R.drawable.third_plant_seven) as BitmapDrawable

        if (viewModel.changePicture == 0) {
            imageView_plant_third.background = drawone
        } else if (viewModel.changePicture == 1) {
            imageView_plant_third.background = drawtwo
        } else if (viewModel.changePicture == 2) {
            imageView_plant_third.background = drawtree
        } else if (viewModel.changePicture == 3) {
            imageView_plant_third.background = drawfour
        } else if (viewModel.changePicture == 4) {
            imageView_plant_third.background = drawfive
        } else if (viewModel.changePicture == 5) {
            imageView_plant_third.background = drawsix
        } else if (viewModel.changePicture >= 6) {
            imageView_plant_third.background = drawseven

        }
    }

}