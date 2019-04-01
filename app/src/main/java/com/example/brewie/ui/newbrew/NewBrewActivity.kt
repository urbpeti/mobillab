package com.example.brewie.ui.newbrew

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.brewie.R
import com.example.brewie.injector
import kotlinx.android.synthetic.main.activity_brewdetails.*
import javax.inject.Inject

class NewBrewActivity: AppCompatActivity(), NewBrewScreen {

    @Inject
    lateinit var newBrewPresenter: NewBrewPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_newbrew)
        injector.inject(this)

        btnBack.setOnClickListener { this.finish() }
    }

    override fun onStart() {
        super.onStart()
        newBrewPresenter.attachScreen(this)
    }

    override fun onStop() {
        super.onStop()
        newBrewPresenter.detachScreen()
    }
}
