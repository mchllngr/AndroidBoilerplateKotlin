package de.mchllngr.androidboilerplatekotlin.debug.base

import android.support.v7.app.AppCompatActivity

/**
 * Debug-class used for debug initializations.
 *
 * Empty in Release-BuildVariant.
 */
abstract class DebugActivity : AppCompatActivity() {

    protected fun setDebugDrawer() = {}
}
