package de.mchllngr.androidboilerplatekotlin.base

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.annotation.StringRes
import android.support.v7.widget.Toolbar
import de.mchllngr.androidboilerplatekotlin.R
import de.mchllngr.androidboilerplatekotlin.debug.base.DebugActivity
import org.koin.android.architecture.ext.viewModelByClass
import kotlin.reflect.KClass

abstract class BaseActivity<B : ViewDataBinding, VM : BaseViewModel>(clazz: KClass<VM>) : DebugActivity() {

    protected val viewModel: VM by viewModelByClass(true, clazz)

    protected lateinit var binding: B

    @LayoutRes
    protected abstract fun getLayoutId(): Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, getLayoutId())
        setDebugDrawer()
    }

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
