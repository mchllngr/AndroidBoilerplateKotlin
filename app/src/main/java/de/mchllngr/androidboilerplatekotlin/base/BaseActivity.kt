package de.mchllngr.androidboilerplatekotlin.base

import android.support.annotation.StringRes
import android.support.v7.widget.Toolbar

import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter
import com.hannesdorfmann.mosby3.mvp.MvpView

import de.mchllngr.androidboilerplatekotlin.R

/**
 * Base-class for work concerning every [android.app.Activity].
 *
 * @param [V] view-interface for this activity
 * @param [P] presenter for this activity
 */
abstract class BaseActivity<V : MvpView, P : MvpBasePresenter<V>> : DebugBaseActivity<V, P>() {

    /**
     * Overrides [android.support.v7.app.AppCompatActivity.setSupportActionBar] to
     * allow setting the default title when called.
     *
     * @param toolbar toolbar to set
     */
    override fun setSupportActionBar(toolbar: Toolbar?) {
        super.setSupportActionBar(toolbar)
        setDefaultActionBarTitle()
    }

    /**
     * Sets the default title for the [android.support.v7.app.ActionBar].
     */
    private fun setDefaultActionBarTitle() {
        setActionBarTitle(R.string.app_name)
    }

    /**
     * Sets the title for the [android.support.v7.app.ActionBar].
     *
     * @param titleResId [StringRes] for the title
     */
    fun setActionBarTitle(@StringRes titleResId: Int) {
        supportActionBar?.setTitle(titleResId)
    }

    /**
     * Sets the visibility of the home-button (up-arrow).
     */
    fun setShowHomeButton(showHomeButton: Boolean) {
        supportActionBar?.setDisplayHomeAsUpEnabled(showHomeButton)
        supportActionBar?.setDisplayShowHomeEnabled(showHomeButton)
    }
}
