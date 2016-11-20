package de.mchllngr.androidboilerplatekotlin.base

import com.hannesdorfmann.mosby.mvp.MvpBasePresenter
import com.hannesdorfmann.mosby.mvp.MvpPresenter

import de.mchllngr.androidboilerplatekotlin.App
import de.mchllngr.androidboilerplatekotlin.injection.ApplicationComponent

/**
 * Base-class for work concerning every [MvpPresenter].
 *
 * @param [V] view-interface for this fragment
 */
open class BasePresenter<V : BaseView> : MvpBasePresenter<V>() {

    /**
     * Gets the dagger-component for the whole application.
     *
     * @return dagger-component from the [App]
     */
    protected val applicationComponent: ApplicationComponent
        get() {
            return App.applicationComponent
        }
}
