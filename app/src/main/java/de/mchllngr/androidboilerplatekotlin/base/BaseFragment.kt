package de.mchllngr.androidboilerplatekotlin.base

import android.support.annotation.StringRes

import com.hannesdorfmann.mosby.mvp.MvpBasePresenter
import com.hannesdorfmann.mosby.mvp.MvpFragment
import com.hannesdorfmann.mosby.mvp.MvpView

/**
 * Base-class for work concerning every [android.support.v4.app.Fragment].
 *
 * @param [V] view-interface for this fragment
 * @param [P] presenter for this fragment
 */
abstract class BaseFragment<V : MvpView, P : MvpBasePresenter<V>> : MvpFragment<V, P>() {

    /**
     * Sets the title for the [android.support.v7.app.ActionBar] in the
     * [android.app.Activity] via the given [StringRes] if the
     * [android.app.Activity] is a subclass from [BaseActivity].
     *
     * @param titleResId [StringRes] for the title
     */
    fun setActionBarTitle(@StringRes titleResId: Int) {
        if (activity is BaseActivity<*, *>)
            (activity as BaseActivity<*, *>).setActionBarTitle(titleResId)
    }
}
