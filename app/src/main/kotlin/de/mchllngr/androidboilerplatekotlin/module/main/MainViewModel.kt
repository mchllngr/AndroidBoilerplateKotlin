package de.mchllngr.androidboilerplatekotlin.module.main

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    val helloWorld: MutableLiveData<String> = MutableLiveData()

    init {
        helloWorld.value = "Hello, World!"
    }

}
