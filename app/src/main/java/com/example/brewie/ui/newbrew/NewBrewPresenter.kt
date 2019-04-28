package com.example.brewie.ui.newbrew

import com.example.brewie.interactor.brews.BrewsInteractor
import com.example.brewie.model.Beer
import com.example.brewie.ui.Presenter
import javax.inject.Inject

class NewBrewPresenter @Inject constructor(private val brewsInteractor: BrewsInteractor) : Presenter<NewBrewScreen>() {
    fun addBrew(beer: Beer) {
        brewsInteractor.addBeer(beer)
    }
}