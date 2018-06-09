package de.mchllngr.androidboilerplatekotlin.debug.base

import android.os.Bundle
import de.mchllngr.androidboilerplatekotlin.base.BaseActivity
import de.mchllngr.androidboilerplatekotlin.debug.util.DebugDrawerHelper
import io.palaima.debugdrawer.DebugDrawer

/**
 * Debug-class used for initialization of the [DebugDrawer].
 */
abstract class DebugActivity : BaseActivity() {

    /**
     * [DebugDrawer] reference to use.
     */
    private lateinit var debugDrawer: DebugDrawer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        debugDrawer = DebugDrawerHelper(this).createDebugDrawer()
    }

    override fun onBackPressed() {
        if (debugDrawer.isDrawerOpen) {
            debugDrawer.closeDrawer()
            return
        }
        super.onBackPressed()
    }
}
