package de.mchllngr.androidboilerplatekotlin.util.debug

import android.support.v7.app.AppCompatActivity
import android.support.v7.app.AppCompatDelegate
import de.mchllngr.androidboilerplatekotlin.R
import io.palaima.debugdrawer.DebugDrawer
import io.palaima.debugdrawer.actions.ActionsModule
import io.palaima.debugdrawer.actions.SpinnerAction
import io.palaima.debugdrawer.commons.BuildModule
import io.palaima.debugdrawer.commons.DeviceModule
import io.palaima.debugdrawer.commons.NetworkModule
import io.palaima.debugdrawer.fps.FpsModule
import io.palaima.debugdrawer.location.LocationModule
import io.palaima.debugdrawer.scalpel.ScalpelModule
import jp.wasabeef.takt.Takt
import java.util.*

/**
 * Helper-class for easier use with [DebugDrawer].
 */
class DebugDrawerHelper(private val activity: AppCompatActivity) {
    /**
     * [String] used for initialising the NightMode-[ActionsModule].
     */
    private var debugNightModeSelect: String = activity.getString(R.string.debug_night_mode_select)
    /**
     * [String] used for initialising the NightMode-[ActionsModule].
     */
    private var debugNightModeYes: String = activity.getString(R.string.debug_night_mode_yes)
    /**
     * [String] used for initialising the NightMode-[ActionsModule].
     */
    private var debugNightModeNo: String = activity.getString(R.string.debug_night_mode_no)
    /**
     * [String] used for initialising the NightMode-[ActionsModule].
     */
    private var debugNightModeAuto: String = activity.getString(R.string.debug_night_mode_auto)
    /**
     * [String] used for initialising the NightMode-[ActionsModule].
     */
    private var debugNightModeFollowSystem: String = activity.getString(R.string.debug_night_mode_follow_system)
    /**
     * [DebugDrawer] reference to use.
     */
    private var debugDrawer: DebugDrawer? = null

    /**
     * Initialises the [DebugDrawer].
     */
    fun initDebugDrawer(withLocation: Boolean) {
        val debugDrawerBuilder: DebugDrawer.Builder = DebugDrawer.Builder(activity)

        if (withLocation)
            debugDrawerBuilder.modules(
                    ActionsModule(nightModeActionsModule),
                    ScalpelModule(activity),
                    LocationModule(activity),
                    NetworkModule(activity),
                    FpsModule(Takt.stock(activity.application)),
                    BuildModule(activity),
                    DeviceModule(activity)
            )
        else
            debugDrawerBuilder.modules(
                    ActionsModule(nightModeActionsModule),
                    ScalpelModule(activity),
                    NetworkModule(activity),
                    FpsModule(Takt.stock(activity.application)),
                    BuildModule(activity),
                    DeviceModule(activity)
            )

        debugDrawer = debugDrawerBuilder.build()
    }

    /**
     * Returns the [ActionsModule] for selecting the [android.support.v7.app.AppCompatDelegate.NightMode]
     */
    private val nightModeActionsModule: SpinnerAction<*>
        get() = SpinnerAction(
                Arrays.asList<String>(
                        debugNightModeSelect,
                        debugNightModeYes,
                        debugNightModeNo,
                        debugNightModeAuto,
                        debugNightModeFollowSystem
                ),
                SpinnerAction.OnItemSelectedListener<String> { value ->
                    var selectedMode = AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM

                    if (value == debugNightModeYes)
                        selectedMode = AppCompatDelegate.MODE_NIGHT_YES
                    else if (value == debugNightModeNo)
                        selectedMode = AppCompatDelegate.MODE_NIGHT_NO
                    else if (value == debugNightModeAuto)
                        selectedMode = AppCompatDelegate.MODE_NIGHT_AUTO

                    activity.delegate.setLocalNightMode(selectedMode)
                    activity.recreate()
                }
        )

    /**
     * Attach [DebugDrawer] to lifecycle.
     */
    fun onStart() {
        debugDrawer?.onStart()
    }

    /**
     * Attach [DebugDrawer] to lifecycle.
     */
    fun onResume() {
        debugDrawer?.onResume()
    }

    /**
     * Attach [DebugDrawer] to lifecycle.
     */
    fun onPause() {
        debugDrawer?.onPause()
    }

    /**
     * Attach [DebugDrawer] to lifecycle.
     */
    fun onStop() {
        debugDrawer?.onStop()
    }
}
