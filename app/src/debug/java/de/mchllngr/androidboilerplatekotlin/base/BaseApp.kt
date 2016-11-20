package de.mchllngr.androidboilerplatekotlin.base

import android.app.Application

import com.facebook.stetho.Stetho

import timber.log.Timber

/**
 * Base-class used for debug initializations.
 */
open class BaseApp : Application() {

    override fun onCreate() {
        super.onCreate()

        Stetho.initializeWithDefaults(this)

        initTimber()
    }

    /**
     * Initialises [Timber] with debug configuration.
     */
    private fun initTimber() {
        Timber.plant(object : Timber.DebugTree() {
            // Add the line number to the tag
            override fun createStackElementTag(element: StackTraceElement): String {
                return super.createStackElementTag(element) + '#' + element.lineNumber
            }
        })
    }
}
