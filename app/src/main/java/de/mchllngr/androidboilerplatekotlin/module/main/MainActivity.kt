package de.mchllngr.androidboilerplatekotlin.module.main

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.app.FragmentActivity
import de.mchllngr.androidboilerplatekotlin.R
import de.mchllngr.androidboilerplatekotlin.base.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*

/**
 * [android.app.Activity] for KotlinTest.
 */
class MainActivity : BaseActivity<MainView, MainPresenter>(), MainView {

    override val activity: FragmentActivity
        get() = this

    companion object {
        /**
         * Static factory method that initializes and starts the [android.app.Activity].
         */
        fun start(context: Context) {
            val starter = Intent(context, MainActivity::class.java)
            context.startActivity(starter)
        }
    }

    override fun createPresenter(): MainPresenter {
        return MainPresenter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
    }
}
