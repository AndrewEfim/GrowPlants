package com.neversaydie.andreii.growplants.presentation.base

import android.support.v4.app.FragmentManager
import android.widget.Toast

abstract class BaseRouter<A : BaseActivity>(val activity: A) {

    fun goBack() {
        activity.onBackPressed()
    }

    fun showError(e: Throwable) {
        Toast.makeText(activity, "Error" + e.toString(), Toast.LENGTH_SHORT).show()
    }

    fun replaceFragment(
            fragmentManager: FragmentManager,
            fragment: BaseFragment,
            containerResId: Int, addToBackStack: Boolean = false) {

        val fragmentTransition = fragmentManager.beginTransaction()
        // fragmentTransition.setCustomAnimations(R.animator.slide_left, R.animator.slide_right)//
        fragmentTransition.replace(containerResId, fragment, fragment::class.java.canonicalName)

        //Log.d(TAG, "containerResId" + containerResId.toString())
        if (addToBackStack) {
            fragmentTransition.addToBackStack(null)
        }
        fragmentTransition.commit()
    }
}