package de.mchllngr.androidboilerplatekotlin.base

import android.support.annotation.StringRes
import android.support.v4.app.Fragment

abstract class BaseFragment : Fragment() {

    /**
     * Sets the title for the [android.support.v7.app.ActionBar].
     *
     * @param titleResId [StringRes] for the title
     */
    fun setActionBarTitle(@StringRes titleResId: Int) {
        if (activity is BaseActivity) (activity as BaseActivity).setActionBarTitle(titleResId)
    }
}
