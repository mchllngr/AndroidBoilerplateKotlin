package de.mchllngr.androidboilerplatekotlin.module.main

import android.content.Context
import android.content.Intent
import android.os.Bundle
import de.mchllngr.androidboilerplatekotlin.R
import de.mchllngr.androidboilerplatekotlin.debug.base.DebugActivity

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

    override fun getLayoutId() = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setSupportActionBar(toolbar) // TODO
        setSupportActionBar(findViewById(R.id.toolbar)) // TODO remove

//        fab.setOnClickListener { view ->  // TODO
//            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                    .setAction("Action", null).show()
//        }
    }
}
