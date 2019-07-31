package com.neversaydie.andreii.growplants.presentation.screen.game.plantfour

import android.arch.lifecycle.ViewModelProviders
import android.graphics.drawable.AnimationDrawable
import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import android.view.View
import com.neversaydie.andreii.growplants.R
import com.neversaydie.andreii.growplants.databinding.FragmentPlantFourBinding
import com.neversaydie.andreii.growplants.presentation.base.BaseMvvmFragment
import com.neversaydie.andreii.growplants.presentation.screen.GameRouter
import kotlinx.android.synthetic.main.fragment_game.*
import kotlinx.android.synthetic.main.fragment_plant_four.*

import java.util.*

class PlantFourFragment : BaseMvvmFragment<PlantFourViewModel, GameRouter, FragmentPlantFourBinding>() {
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
            button_game_water_four.isClickable = true
            button_game_water_four.visibility = View.VISIBLE
        } else if (viewModel.waterIsEnable == false) {
            button_game_water_four.isClickable = false
            button_game_water_four.visibility = View.INVISIBLE
        }
    }


    override fun provideViewModel(): PlantFourViewModel {
        return ViewModelProviders.of(this).get(PlantFourViewModel::class.java)

    }

    override fun provideLayoutId(): Int = R.layout.fragment_plant_four

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activeWaterButton()
        view.setOnTouchListener(handleTouch)

        val drawone: BitmapDrawable = activity?.resources?.getDrawable(R.drawable.fourth_plant_one) as BitmapDrawable
        val drawtwo: BitmapDrawable = activity?.resources?.getDrawable(R.drawable.fourth_plant_two) as BitmapDrawable
        val drawtree: BitmapDrawable = activity?.resources?.getDrawable(R.drawable.fourth_plant_three) as BitmapDrawable
        val drawfour: BitmapDrawable = activity?.resources?.getDrawable(R.drawable.fourth_plant_four) as BitmapDrawable
        val drawfive: BitmapDrawable = activity?.resources?.getDrawable(R.drawable.fourth_plant_five) as BitmapDrawable
        val drawsix: BitmapDrawable = activity?.resources?.getDrawable(R.drawable.fourth_plant_six) as BitmapDrawable
        val drawseven: BitmapDrawable = activity?.resources?.getDrawable(R.drawable.fourth_plant_seven) as BitmapDrawable
        val drawseigth: BitmapDrawable = activity?.resources?.getDrawable(R.drawable.fourth_plant_eight) as BitmapDrawable

        imageView_leika_four.setBackgroundResource(R.drawable.water_animation)
        textView_next_water_four.visibility = View.INVISIBLE

        imageView_leika_four.visibility = View.INVISIBLE

        val animDraw: AnimationDrawable = imageView_leika_four.background as AnimationDrawable
        fun setImage() {
            if (viewModel.changePicture == 0) {
                imageView_plant_four.background = drawone

            } else if (viewModel.changePicture == 1) {
                imageView_plant_four.background = drawtwo

            } else if (viewModel.changePicture == 2) {
                imageView_plant_four.background = drawtree

            } else if (viewModel.changePicture == 3) {
                imageView_plant_four.background = drawfour
            } else if (viewModel.changePicture == 4) {
                imageView_plant_four.background = drawfive

            } else if (viewModel.changePicture == 5) {
                imageView_plant_four.background = drawsix
            } else if (viewModel.changePicture == 6) {
                imageView_plant_four.background = drawseven
            } else if (viewModel.changePicture >= 7) {
                imageView_plant_four.background = drawseigth

            }
        }


        button_game_water_four.isClickable = false
        fun activeWaterButton() {
            if (viewModel.waterIsEnable == true) {
                button_game_water_four.isClickable = true
                button_game_water_four.visibility = View.VISIBLE

            } else if (viewModel.waterIsEnable == false) {
                button_game_water_four.isClickable = false
                button_game_water_four.visibility = View.INVISIBLE

            }
        }

        if (viewModel.waterIsEnable) {
            button_game_water_four.isClickable = true
        } else {
            button_game_water_four.isClickable = false
        }

        button_game_water_four.setOnClickListener({
            imageView_leika_four.visibility = View.VISIBLE
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

        button_to_the_garden_four.setOnClickListener({
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
            textView_next_water_four.visibility = View.VISIBLE
        } else if (viewModel.textNextWater == false) {
            textView_next_water_four.visibility = View.INVISIBLE
        }
    }

    fun setVisibile() {
        if (viewModel.setVisibleGardenButton == true) {
            button_to_the_garden_four.visibility = View.VISIBLE

        } else if (viewModel.setVisibleGardenButton == false) {
            button_to_the_garden_four.visibility = View.INVISIBLE

        }
    }

    fun setTextToGrowth() {
        if (viewModel.setText == true) {
            textView_plant_is_grow_four.visibility = View.VISIBLE

        } else if (viewModel.setVisibleGardenButton == false) {
            textView_plant_is_grow_four.visibility = View.INVISIBLE

        }
    }

    private fun setImage() {

        val drawone: BitmapDrawable = activity?.resources?.getDrawable(R.drawable.fourth_plant_one) as BitmapDrawable
        val drawtwo: BitmapDrawable = activity?.resources?.getDrawable(R.drawable.fourth_plant_two) as BitmapDrawable
        val drawtree: BitmapDrawable = activity?.resources?.getDrawable(R.drawable.fourth_plant_three) as BitmapDrawable
        val drawfour: BitmapDrawable = activity?.resources?.getDrawable(R.drawable.fourth_plant_four) as BitmapDrawable
        val drawfive: BitmapDrawable = activity?.resources?.getDrawable(R.drawable.fourth_plant_five) as BitmapDrawable
        val drawsix: BitmapDrawable = activity?.resources?.getDrawable(R.drawable.fourth_plant_six) as BitmapDrawable
        val drawseven: BitmapDrawable = activity?.resources?.getDrawable(R.drawable.fourth_plant_seven) as BitmapDrawable
        val drawseigth: BitmapDrawable = activity?.resources?.getDrawable(R.drawable.fourth_plant_eight) as BitmapDrawable

        if (viewModel.changePicture == 0) {
            imageView_plant_four.background = drawone

        } else if (viewModel.changePicture == 1) {
            imageView_plant_four.background = drawtwo
        } else if (viewModel.changePicture == 2) {
            imageView_plant_four.background = drawtree
        } else if (viewModel.changePicture == 3) {
            imageView_plant_four.background = drawfour
        } else if (viewModel.changePicture == 4) {
            imageView_plant_four.background = drawfive
        } else if (viewModel.changePicture == 5) {
            imageView_plant_four.background = drawsix
        } else if (viewModel.changePicture == 6) {
            imageView_plant_four.background = drawseven
        } else if (viewModel.changePicture >= 7) {
            imageView_plant_four.background = drawseigth
        }
    }

}