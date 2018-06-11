package de.mchllngr.androidboilerplatekotlin.debug.base

import de.mchllngr.androidboilerplatekotlin.base.BaseActivity
import io.palaima.debugdrawer.DebugDrawer

/**
 * Debug-class used for initialization of the [DebugDrawer].
 */
abstract class DebugActivity : BaseActivity() {

//    /**
//     * [DebugDrawer] reference to use.
//     */
//    private lateinit var debugDrawer: DebugDrawer
//
//    override fun setContentView(layoutResID: Int) {
//        super.setContentView(layoutResID)
//        debugDrawer = DebugDrawerHelper(this).createDebugDrawer() // FIXME -> doesn't seem to work with data-binding ("view must have a tag")
//                                                                              -> setting after DataBindingUtils.setContentView() seems to work
//    }
//
//    override fun onBackPressed() {
//        if (debugDrawer.isDrawerOpen) {
//            debugDrawer.closeDrawer()
//            return
//        }
//        super.onBackPressed()
//    }
}
