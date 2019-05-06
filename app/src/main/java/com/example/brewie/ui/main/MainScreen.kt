package com.example.brewie.ui.main

import com.example.brewie.model.Beer

interface MainScreen {
    fun showBrews(brews: List<Beer>?)
    fun showBrewDetails(beer: Beer)
    fun showNewBrew()
    fun showNetworkError(errorMsg: String)
}
