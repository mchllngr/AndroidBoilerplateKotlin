package de.mchllngr.androidboilerplatekotlin.module.main

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import timber.log.Timber

class MainViewModel : ViewModel() {

    val helloWorld: MutableLiveData<String> = MutableLiveData()

    init {
        helloWorld.value = "Hello, World!"
    }

    fun onTextClick() {
        Timber.d("DEBUG: onTextClick")
    }
}
