package de.mchllngr.androidboilerplatekotlin.module.main

import de.mchllngr.androidboilerplatekotlin.base.BasePresenter

/**
 * [com.hannesdorfmann.mosby3.mvp.MvpPresenter] for the [MainActivity]
 */
class MainPresenter : BasePresenter<MainView>() {

//    /**
//     * [Example]-class for an example for Dagger2-injection.
//     */
//    @Inject
//    lateinit var example: Example

    override fun attachView(view: MainView) {
        super.attachView(view)
        applicationComponent.inject(this)
    }

    override fun detachView(retainInstance: Boolean) {
        super.detachView(retainInstance)
    }
}
