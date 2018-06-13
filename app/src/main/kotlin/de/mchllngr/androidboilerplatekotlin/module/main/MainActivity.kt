package de.mchllngr.androidboilerplatekotlin.module.main

import android.arch.lifecycle.Observer
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import de.mchllngr.androidboilerplatekotlin.R
import de.mchllngr.androidboilerplatekotlin.base.BaseActivity

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>(MainViewModel::class) {

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
        setSupportActionBar(binding.toolbar)
        binding.viewModel = viewModel

        viewModel.snackbar.observe(this, Observer { showSnackbar() })
    }

    private fun showSnackbar() {
        Snackbar.make(binding.root, "Replace with your own action", Snackbar.LENGTH_LONG).show()
    }
}

