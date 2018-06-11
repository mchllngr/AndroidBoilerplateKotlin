package de.mchllngr.androidboilerplatekotlin.module.main

import org.koin.android.architecture.ext.viewModel
import org.koin.dsl.module.applicationContext

val MainModule = applicationContext {
    viewModel { MainViewModel() }
}
