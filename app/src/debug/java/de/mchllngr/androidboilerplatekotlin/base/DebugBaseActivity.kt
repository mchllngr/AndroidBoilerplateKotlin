package de.mchllngr.androidboilerplatekotlin.base

import android.support.annotation.LayoutRes
import android.view.View
import android.view.ViewGroup

import com.hannesdorfmann.mosby.mvp.MvpActivity
import com.hannesdorfmann.mosby.mvp.MvpBasePresenter
import com.hannesdorfmann.mosby.mvp.MvpView

import de.mchllngr.androidboilerplatekotlin.util.debug.DebugDrawerHelper
import io.palaima.debugdrawer.DebugDrawer

/**
 * BaseDebug-class used for initialization of the [DebugDrawer].
 */
abstract class DebugBaseActivity<V : MvpView, P : MvpBasePresenter<V>> : MvpActivity<V, P>() {

    /**
     * [DebugDrawerHelper] reference to use.
     */
    private var debugDrawerHelper: DebugDrawerHelper? = null

    /**
     * Overrides [android.support.v7.app.AppCompatActivity.setContentView] to
     * allow setting the [DebugDrawer] when called.
     *
     * @param layoutResID [LayoutRes] used for setting the ContentView
     */
    override fun setContentView(@LayoutRes layoutResID: Int) {
        super.setContentView(layoutResID)
        setDebugDrawer()
    }

    /**
     * Overrides [android.support.v7.app.AppCompatActivity.setContentView] to
     * allow setting the [DebugDrawer] when called.
     *
     * @param view [View] used for setting the ContentView
     */
    override fun setContentView(view: View) {
        super.setContentView(view)
        setDebugDrawer()
    }

    /**
     * Overrides [android.support.v7.app.AppCompatActivity.setContentView]
     * to allow setting the [DebugDrawer] when called.
     *
     * @param view   [View] used for setting the ContentView
     * @param params [ViewGroup.LayoutParams] used for setting the ContentView
     */
    override fun setContentView(view: View, params: ViewGroup.LayoutParams) {
        super.setContentView(view, params)
        setDebugDrawer()
    }

    /**
     * Initialises the [DebugDrawer] and sets it.
     */
    private fun setDebugDrawer() {
        if (debugDrawerHelper == null)
            debugDrawerHelper = DebugDrawerHelper(this)
        debugDrawerHelper?.initDebugDrawer()
    }

    /**
     * Attach [DebugDrawer] to lifecycle.
     */
    override fun onStart() {
        super.onStart()
        debugDrawerHelper?.onStart()
    }


    /**
     * Attach [DebugDrawer] to lifecycle.
     */
    override fun onResume() {
        super.onResume()
        debugDrawerHelper?.onResume()
    }


    /**
     * Attach [DebugDrawer] to lifecycle.
     */
    override fun onPause() {
        super.onPause()
        debugDrawerHelper?.onPause()
    }


    /**
     * Attach [DebugDrawer] to lifecycle.
     */
    override fun onStop() {
        super.onStop()
        debugDrawerHelper?.onStop()
    }
}
