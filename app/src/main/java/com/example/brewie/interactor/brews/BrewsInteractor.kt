package com.example.brewie.interactor.brews

import android.util.Log
import com.example.brewie.data.db.dao.BeerDao
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
                first_brewed = it.firstBrewed
            )}

            val apiBeers = response.body()
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

}