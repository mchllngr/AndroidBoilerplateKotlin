package de.mchllngr.androidboilerplatekotlin.base

import android.Manifest.permission.ACCESS_FINE_LOCATION
import android.support.annotation.LayoutRes
import android.view.View
import android.view.ViewGroup
import com.hannesdorfmann.mosby3.mvp.MvpActivity
import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter
import com.hannesdorfmann.mosby3.mvp.MvpView
import com.maxcruz.reactivePermissions.ReactivePermissions
import com.maxcruz.reactivePermissions.entity.Permission
import de.mchllngr.androidboilerplatekotlin.R
import de.mchllngr.androidboilerplatekotlin.util.debug.DebugDrawerHelper

/**
 * BaseDebug-class used for initialization of the [DebugDrawer].
 */
abstract class DebugBaseActivity<V : MvpView, P : MvpBasePresenter<V>> : MvpActivity<V, P>() {

    /**
     * Request code for requesting the permission.
     */
    private val REQUEST_CODE = 1742
    /**
     * [Permission] to request.
     */
    private val location = Permission(
            ACCESS_FINE_LOCATION,
            R.string.debug_permission_location_rationale,
            true
    )
    /**
     * [ReactivePermissions] reference for requesting the permission.
     */
    private var reactive: ReactivePermissions? = null
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
        setDebugDrawerIfLocationPermission()
    }

    /**
     * Overrides [android.support.v7.app.AppCompatActivity.setContentView] to
     * allow setting the [DebugDrawer] when called.
     *
     * @param view [View] used for setting the ContentView
     */
    override fun setContentView(view: View) {
        super.setContentView(view)
        setDebugDrawerIfLocationPermission()
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
        setDebugDrawerIfLocationPermission()
    }

    /**
     * Initialises the [DebugDrawer] and sets it if the location permission is granted.
     */
    private fun setDebugDrawerIfLocationPermission() {
        if (reactive == null)
            reactive = ReactivePermissions(this, REQUEST_CODE)
        reactive?.evaluate(listOf(location))
        reactive?.observeResultPermissions()?.subscribe { event ->
            // event.second == isGranted
            setDebugDrawer(event.second)
        }
    }

    /**
     * Initialises the [DebugDrawer] and sets it.
     */
    private fun setDebugDrawer(withLocation: Boolean) {
        if (debugDrawerHelper == null)
            debugDrawerHelper = DebugDrawerHelper(this)
        debugDrawerHelper?.initDebugDrawer(withLocation)
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

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        if (requestCode == REQUEST_CODE)
            reactive?.receive(permissions, grantResults)
    }
}
