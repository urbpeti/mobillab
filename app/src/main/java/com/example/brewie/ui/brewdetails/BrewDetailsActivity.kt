package com.example.brewie.ui.brewdetails

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.brewie.R
import com.example.brewie.injector
import kotlinx.android.synthetic.main.activity_brewdetails.*
import javax.inject.Inject

class BrewDetailsActivity: AppCompatActivity(), BrewDetailsScreen {

    @Inject
    lateinit var brewPresenter: BrewDetailsPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_brewdetails)
        injector.inject(this)

        btnBack.setOnClickListener { this.finish() }
    }

    override fun onStart() {
        super.onStart()
        brewPresenter.attachScreen(this)
    }

    override fun onStop() {
        super.onStop()
        brewPresenter.detachScreen()
    }
}

