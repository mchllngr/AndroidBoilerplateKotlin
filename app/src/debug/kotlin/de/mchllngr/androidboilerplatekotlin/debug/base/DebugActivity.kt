package de.mchllngr.androidboilerplatekotlin.debug.base

import android.support.v7.app.AppCompatActivity
import de.mchllngr.androidboilerplatekotlin.debug.util.DebugDrawerHelper
import io.palaima.debugdrawer.DebugDrawer

/**
 * Debug-class used for initialization of the [DebugDrawer].
 */
abstract class DebugActivity : AppCompatActivity() {

    private var debugDrawer: DebugDrawer? = null

    protected fun setDebugDrawer() {
        debugDrawer = DebugDrawerHelper(this).createDebugDrawer()
    }

    override fun onBackPressed() {
        if (debugDrawer?.isDrawerOpen == true) {
            debugDrawer?.closeDrawer()
            return
        }
        super.onBackPressed()
    }
}
