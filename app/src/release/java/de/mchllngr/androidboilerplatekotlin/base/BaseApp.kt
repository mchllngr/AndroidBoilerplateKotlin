package de.mchllngr.androidboilerplatekotlin.base

import android.app.Application

import de.mchllngr.androidboilerplatekotlin.util.timber.ReleaseTree
import timber.log.Timber

/**
 * Base-class used for initialising [Timber].
 */
open class BaseApp : Application() {

    override fun onCreate() {
        super.onCreate()

        initTimber()
    }

    /**
     * Initialises [Timber] with release configuration
     */
    private fun initTimber() {
        Timber.plant(ReleaseTree())
    }
}
