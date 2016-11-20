package de.mchllngr.androidboilerplatekotlin.base

import android.support.v4.app.FragmentActivity

import com.hannesdorfmann.mosby.mvp.MvpView

/**
 * Base-interface for every view.
 */
interface BaseView : MvpView {

    /**
     * Allows the [BasePresenter] to get the associated Activity.
     *
     * @see BasePresenter
     */
    val activity: FragmentActivity
}
