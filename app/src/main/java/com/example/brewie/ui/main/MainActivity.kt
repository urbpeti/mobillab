package com.example.brewie.ui.main

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.example.brewie.R
import com.example.brewie.injector
import com.example.brewie.model.Beer
import com.example.brewie.ui.brewdetails.BrewDetailsActivity
import com.example.brewie.ui.newbrew.NewBrewActivity
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity(), MainScreen {

    @Inject
    lateinit var mainPresenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        injector.inject(this)

        btnShowBrews.setOnClickListener { mainPresenter.refreshBrews("TODO") }
        btnShowDetails.setOnClickListener { mainPresenter.showBrewDetails() }
        btnAddNewBrew.setOnClickListener { mainPresenter.showNewBrew() }
    }

    override fun onStart() {
        super.onStart()
        mainPresenter.attachScreen(this)
    }

    override fun onStop() {
        super.onStop()
        mainPresenter.detachScreen()
    }

    override fun showBrews(brews: List<Beer>?) {
        if(brews != null) {
            var beersWithAlk = ""
            brews.forEach { beersWithAlk += it.name + "" + it.abv + "\n"}
            tarea.text = beersWithAlk
        }
    }

    override fun showBrewDetails() {
        startActivity(Intent(this, BrewDetailsActivity::class.java))
    }

    override fun showNewBrew() {
        startActivity(Intent(this, NewBrewActivity::class.java))
    }

    override fun showNetworkError(errorMsg: String) {
        Toast.makeText(this, errorMsg, Toast.LENGTH_LONG).show()
    }

}