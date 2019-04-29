package com.example.brewie.ui.brewdetails

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.example.brewie.R
import com.example.brewie.injector
import com.example.brewie.model.Beer
import com.example.brewie.ui.main.MainActivity
import kotlinx.android.synthetic.main.activity_brewdetails.*
import javax.inject.Inject

class BrewDetailsActivity: AppCompatActivity(), BrewDetailsScreen {

    @Inject
    lateinit var brewPresenter: BrewDetailsPresenter

    private var isMocked = false
    private var beerId: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_brewdetails)
        injector.inject(this)

        beerId = intent.getIntExtra(MainActivity.KEY_BEER, 0)
        isMocked = intent.getBooleanExtra(MainActivity.KEY_BEER_MOCKED, false)

        btnBack.setOnClickListener { this.finish() }
    }

    override fun onStart() {
        super.onStart()
        brewPresenter.attachScreen(this)
        if(beerId != null){
            brewPresenter.refreshBeer(beerId!!, isMocked)
        }
    }

    override fun onStop() {
        super.onStop()
        brewPresenter.detachScreen()
    }

    override fun showNetworkError(errMsg: String) {
        Toast.makeText(this, errMsg, Toast.LENGTH_LONG).show()
    }

    override fun showBrew(beer: Beer) {
        name.setText(beer.name)
        alcohol.setText(beer.abv.toString())
        imgUrlInput.setText(beer.image_url)
    }
}

