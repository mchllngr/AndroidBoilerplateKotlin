package de.mchllngr.androidboilerplatekotlin.debug.util

import android.support.v7.app.AppCompatActivity
import android.support.v7.app.AppCompatDelegate
import de.mchllngr.androidboilerplatekotlin.R
import io.palaima.debugdrawer.DebugDrawer
import io.palaima.debugdrawer.actions.ActionsModule
import io.palaima.debugdrawer.actions.SpinnerAction
import io.palaima.debugdrawer.commons.BuildModule
import io.palaima.debugdrawer.commons.DeviceModule
import io.palaima.debugdrawer.commons.NetworkModule
import io.palaima.debugdrawer.commons.SettingsModule
import io.palaima.debugdrawer.scalpel.ScalpelModule
import java.util.*

/**
 * Helper-class for easier use with [DebugDrawer].
 */
class DebugDrawerHelper(private val activity: AppCompatActivity) {

    /**
     * [String] used for initialising the NightMode-[ActionsModule].
     */
    private val debugNightModeSelect: String = activity.getString(R.string.debug_night_mode_select)
    /**
     * [String] used for initialising the NightMode-[ActionsModule].
     */
    private val debugNightModeYes: String = activity.getString(R.string.debug_night_mode_yes)
    /**
     * [String] used for initialising the NightMode-[ActionsModule].
     */
    private val debugNightModeNo: String = activity.getString(R.string.debug_night_mode_no)
    /**
     * [String] used for initialising the NightMode-[ActionsModule].
     */
    private val debugNightModeAuto: String = activity.getString(R.string.debug_night_mode_auto)
    /**
     * [String] used for initialising the NightMode-[ActionsModule].
     */
    private val debugNightModeFollowSystem: String = activity.getString(R.string.debug_night_mode_follow_system)
    /**
     * [ActionsModule] for selecting the [android.support.v7.app.AppCompatDelegate.NightMode]
     */
    private val nightModeActionsModule
        get() = SpinnerAction(
                Arrays.asList<String>(
                        debugNightModeSelect,
                        debugNightModeYes,
                        debugNightModeNo,
                        debugNightModeAuto,
                        debugNightModeFollowSystem
                ),
                SpinnerAction.OnItemSelectedListener<String> { value ->
                    activity.delegate.setLocalNightMode(when (value) {
                        debugNightModeYes -> AppCompatDelegate.MODE_NIGHT_YES
                        debugNightModeNo -> AppCompatDelegate.MODE_NIGHT_NO
                        debugNightModeAuto -> AppCompatDelegate.MODE_NIGHT_AUTO
                        else -> AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM
                    })
                    activity.recreate()
                }
        )

    /**
     * Returns a new [DebugDrawer].
     */
    fun createDebugDrawer(): DebugDrawer = DebugDrawer.Builder(activity)
            .modules(
                    ActionsModule(nightModeActionsModule),
                    ScalpelModule(activity),
                    NetworkModule(),
                    BuildModule(),
                    DeviceModule(),
                    SettingsModule()
            )
            .withTheme(R.style.AppTheme)
            .build()
}
