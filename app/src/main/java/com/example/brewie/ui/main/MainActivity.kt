package com.example.brewie.ui.main

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import com.example.brewie.R
import com.example.brewie.injector
import com.example.brewie.model.Beer
import com.example.brewie.ui.brewdetails.BrewDetailsActivity
import com.example.brewie.ui.newbrew.NewBrewActivity
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity(), MainScreen {
    private val displayedBeers: MutableList<Beer> = mutableListOf()
    private var beerAdapter: BeerAdapter? = null

    @Inject
    lateinit var mainPresenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        injector.inject(this)


        val llm = LinearLayoutManager(this@MainActivity)
        llm.orientation = LinearLayoutManager.VERTICAL
        beerList.layoutManager = llm
        beerAdapter = BeerAdapter(this@MainActivity, mainPresenter, displayedBeers)
        beerList.adapter = beerAdapter


        swipeRefreshLayoutBeers.setOnRefreshListener { mainPresenter.refreshBrews("") }
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
        swipeRefreshLayoutBeers.isRefreshing = false
        displayedBeers.clear()
        if (brews != null) {
            displayedBeers.addAll(brews)
        }

        beerAdapter?.notifyDataSetChanged()
    }

    override fun showBrewDetails(beer: Beer) {
        val intent = Intent(this, BrewDetailsActivity::class.java)
        intent.putExtra(KEY_BEER, beer.id)
        intent.putExtra(KEY_BEER_MOCKED, beer.isMock)
        startActivity(intent)
    }

    override fun showNewBrew() {
        startActivity(Intent(this, NewBrewActivity::class.java))
    }

    override fun showNetworkError(errorMsg: String) {
        Toast.makeText(this, errorMsg, Toast.LENGTH_LONG).show()
    }

    companion object {
        const val KEY_BEER = "KEY_BEER"
        const val KEY_BEER_MOCKED = "KEY_BEER_MOCKED"
    }

}