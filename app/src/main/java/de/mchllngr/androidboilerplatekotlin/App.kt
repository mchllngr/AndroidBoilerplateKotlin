package de.mchllngr.androidboilerplatekotlin

import android.support.v7.app.AppCompatDelegate

import de.mchllngr.androidboilerplatekotlin.base.BaseApp
import de.mchllngr.androidboilerplatekotlin.injection.ApplicationComponent
import de.mchllngr.androidboilerplatekotlin.injection.ApplicationModule
import de.mchllngr.androidboilerplatekotlin.injection.DaggerApplicationComponent

/**
 * [App] for the [android.app.Application]
 */
class App : BaseApp() {

    companion object {
        /**
         * Sets the default night mode to follow system.
         */
        init {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM)
        }

        /**
         * Dagger2-component used for injection.
         */
        @JvmStatic lateinit var applicationComponent: ApplicationComponent
    }

    override fun onCreate() {
        super.onCreate()
        applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(ApplicationModule)
                .build()
    }
}
