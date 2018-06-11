package de.mchllngr.androidboilerplatekotlin

import android.support.v7.app.AppCompatDelegate
import de.mchllngr.androidboilerplatekotlin.base.BaseApp
import de.mchllngr.androidboilerplatekotlin.module.main.MainModule
import org.koin.android.ext.android.startKoin

class App : BaseApp() {

    companion object {
        /**
         * Sets the default night mode to follow system.
         */
        init {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM)
        }
    }

    override fun onCreate() {
        super.onCreate()
        startKoin(this, listOf(MainModule))
    }
}
