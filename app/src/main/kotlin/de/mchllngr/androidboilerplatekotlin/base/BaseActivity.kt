package de.mchllngr.androidboilerplatekotlin.base

import android.support.annotation.StringRes
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import de.mchllngr.androidboilerplatekotlin.R

abstract class BaseActivity : AppCompatActivity() {

    /**
     * Overrides [android.support.v7.app.AppCompatActivity.setSupportActionBar] to allow setting the default title when called.
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
