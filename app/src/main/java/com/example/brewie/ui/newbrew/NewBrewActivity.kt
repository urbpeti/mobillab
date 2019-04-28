package com.example.brewie.ui.newbrew

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.brewie.R
import com.example.brewie.injector
import com.example.brewie.model.Beer
import kotlinx.android.synthetic.main.activity_newbrew.*
import javax.inject.Inject

class NewBrewActivity: AppCompatActivity(), NewBrewScreen {

    @Inject
    lateinit var newBrewPresenter: NewBrewPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_newbrew)
        injector.inject(this)

        btnBack.setOnClickListener { this.finish() }

        newBeerButton.setOnClickListener { addBrew() }
    }

    override fun onStart() {
        super.onStart()
        newBrewPresenter.attachScreen(this)
    }

    override fun onStop() {
        super.onStop()
        newBrewPresenter.detachScreen()
    }

    override fun addBrew() {
        if(name.text != null && alcohol.text != null) {
            val alcoholValue = if (alcohol.text.toString() == "") "0" else alcohol.text.toString()
            newBrewPresenter.addBrew(
                Beer(
                    name = name.text.toString(),
                    abv = alcoholValue.toFloat()
                )
            )
        }
    }
}
