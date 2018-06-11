package de.mchllngr.androidboilerplatekotlin.module.main

import android.content.Context
import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import de.mchllngr.androidboilerplatekotlin.R
import de.mchllngr.androidboilerplatekotlin.databinding.ActivityMainBinding
import de.mchllngr.androidboilerplatekotlin.debug.base.DebugActivity
import org.koin.android.ext.android.inject

class MainActivity : DebugActivity() {

    companion object {
        /**
         * Static factory method that initializes and starts the [android.app.Activity].
         */
        fun start(context: Context) {
            val starter = Intent(context, MainActivity::class.java)
            context.startActivity(starter)
        }
    }

    private val viewModel: MainViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setSupportActionBar(binding.toolbar)
        binding.viewModel = viewModel

//        fab.setOnClickListener { view ->  // TODO
//            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                    .setAction("Action", null).show()
//        }
    }
}

