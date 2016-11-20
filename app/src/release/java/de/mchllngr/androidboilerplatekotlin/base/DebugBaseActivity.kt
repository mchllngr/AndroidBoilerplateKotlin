package de.mchllngr.androidboilerplatekotlin.base

import com.hannesdorfmann.mosby.mvp.MvpActivity
import com.hannesdorfmann.mosby.mvp.MvpBasePresenter
import com.hannesdorfmann.mosby.mvp.MvpView

/**
 * BaseDebug-class used for debug initializations.
 *
 * Empty in Release-BuildVariant.
 */
abstract class DebugBaseActivity<V : MvpView, P : MvpBasePresenter<V>> : MvpActivity<V, P>()
