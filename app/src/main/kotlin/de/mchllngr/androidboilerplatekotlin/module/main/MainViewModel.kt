package de.mchllngr.androidboilerplatekotlin.module.main

import android.arch.lifecycle.MutableLiveData
import de.mchllngr.androidboilerplatekotlin.base.BaseViewModel
import de.mchllngr.androidboilerplatekotlin.util.SingleLiveEvent
import timber.log.Timber

class MainViewModel : BaseViewModel() {

    val helloWorld: MutableLiveData<String> = MutableLiveData()
    val snackbar: SingleLiveEvent<Void> = SingleLiveEvent()

    init {
        helloWorld.value = "Hello, World!"
    }

    fun onTextClick() {
        Timber.d("DEBUG: onTextClick")
    }

    fun onFabClick() {
        snackbar.call()
    }
}
