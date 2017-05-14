package de.mchllngr.androidboilerplatekotlin.base

import com.hannesdorfmann.mosby3.mvp.MvpActivity
import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter
import com.hannesdorfmann.mosby3.mvp.MvpView

/**
 * BaseDebug-class used for debug initializations.
 *
 * Empty in Release-BuildVariant.
 */
abstract class DebugBaseActivity<V : MvpView, P : MvpBasePresenter<V>> : MvpActivity<V, P>()
