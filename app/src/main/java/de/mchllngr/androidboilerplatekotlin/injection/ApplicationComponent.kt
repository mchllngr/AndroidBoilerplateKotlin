package de.mchllngr.androidboilerplatekotlin.injection

import dagger.Component
import de.mchllngr.androidboilerplatekotlin.module.main.MainPresenter
import javax.inject.Singleton

/**
 * Dagger2-component for the whole application.
 */
@Singleton
@Component(modules = arrayOf(ApplicationModule::class))
interface ApplicationComponent {

    fun inject(presenter: MainPresenter)
}
