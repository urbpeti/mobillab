package com.example.brewie.ui.brewdetails

import com.example.brewie.model.Beer


interface BrewDetailsScreen {
    fun showNetworkError(errMsg: String)
    fun showBrew(beer: Beer)
}
