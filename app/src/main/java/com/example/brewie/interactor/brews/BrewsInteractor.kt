package com.example.brewie.interactor.brews

import android.util.Log
import com.example.brewie.data.db.dao.BeerDao
import com.example.brewie.interactor.brews.event.GetBeerEvent
import com.example.brewie.interactor.brews.event.GetBeersEvent
import com.example.brewie.model.Beer
import com.example.brewie.network.BrewApi
import org.greenrobot.eventbus.EventBus
import javax.inject.Inject

class BrewsInteractor @Inject constructor(private var brewApi: BrewApi, private var beerDao: BeerDao) {

    fun getBrews(brewQuery: String) {
        val event = GetBeersEvent()

        try {
            val brewQueryCall = brewApi.getBeers(1,10)
            val response = brewQueryCall.execute()
            Log.d("Reponse", response.body().toString())
            if (response.code() != 200) {
                throw Exception("Result code is not 200")
            }

            val mockBeers = beerDao.getBeers().map { Beer(
                id = it.id?.toInt(),
                name = it.name,
                abv = it.abv,
                description = it.description,
                image_url = it.imgUrl,
                first_brewed = it.firstBrewed,
                isMock = true
            )}

            val apiBeers = response.body()?.map {
                it.isMock = false
                it
            }
            if (apiBeers == null) {
                event.brews = mockBeers
            } else {
                event.brews = mockBeers + apiBeers
            }

            event.code = response.code()
            EventBus.getDefault().post(event)
        } catch (e: Exception) {
            event.throwable = e
            EventBus.getDefault().post(event)
        }
    }

    fun getBeer(id: Int, isMocked: Boolean) {
        val event = GetBeerEvent()

        try {
            var beer: Beer? = null

            val mockedBeer = beerDao.getBeer(id)
            beer = Beer(
                id = mockedBeer.id?.toInt(),
                name = mockedBeer.name,
                abv = mockedBeer.abv,
                description = mockedBeer.description,
                image_url = mockedBeer.imgUrl,
                first_brewed = mockedBeer.firstBrewed,
                isMock = true
            )
            event.isMocked = true

            event.brew = beer
            EventBus.getDefault().post(event)
        } catch (e: Exception) {
            event.throwable = e
            EventBus.getDefault().post(event)
        }
    }

    fun addBeer(beer: Beer) {
        val beerEntity = com.example.brewie.data.db.entity.Beer(
           id =  null,
           name = beer.name ?: "",
           abv = beer.abv ?: 0f,
           imgUrl = beer.image_url ?: "",
           firstBrewed = beer.first_brewed ?: "",
           description = beer.description ?: ""
        )

        beerDao.insert(beerEntity)
    }

}