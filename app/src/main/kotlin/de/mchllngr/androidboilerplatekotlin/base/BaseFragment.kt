package de.mchllngr.androidboilerplatekotlin.base

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.annotation.StringRes
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.koin.android.architecture.ext.viewModelByClass
import kotlin.reflect.KClass

abstract class BaseFragment<B : ViewDataBinding, VM : BaseViewModel>(clazz: KClass<VM>) : Fragment() {

    protected val viewModel: VM by viewModelByClass(false, clazz)

    protected lateinit var binding: B

    @LayoutRes
    protected abstract fun getLayoutId(): Int

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(layoutInflater, getLayoutId(), container, false)
        return binding.root
    }

    /**
     * Sets the title for the [android.support.v7.app.ActionBar].
     *
     * @param titleResId [StringRes] for the title
     */
    fun setActionBarTitle(@StringRes titleResId: Int) {
        if (activity is BaseActivity<*, *>) (activity as BaseActivity<*, *>).setActionBarTitle(titleResId)
    }
}
