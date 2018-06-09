package de.mchllngr.androidboilerplatekotlin

import android.support.v7.app.AppCompatDelegate
import de.mchllngr.androidboilerplatekotlin.base.BaseApp

class App : BaseApp() {

    companion object {
        /**
         * Sets the default night mode to follow system.
         */
        init {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM)
        }
    }
}
