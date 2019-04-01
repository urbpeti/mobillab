package com.example.brewie.interactor.brews

import android.util.Log
import com.example.brewie.interactor.brews.event.GetBeersEvent
import com.example.brewie.network.BrewApi
import org.greenrobot.eventbus.EventBus
import javax.inject.Inject

class BrewsInteractor @Inject constructor(private var brewApi: BrewApi) {

    fun getBrews(brewQuery: String) {
        val event = GetBeersEvent()

        try {
            val artistsQueryCall = brewApi.getBeers(1,10)

            val response = artistsQueryCall.execute()
            Log.d("Reponse", response.body().toString())
            if (response.code() != 200) {
                throw Exception("Result code is not 200")
            }
            event.code = response.code()
            event.brews = response.body()
            EventBus.getDefault().post(event)
        } catch (e: Exception) {
            event.throwable = e
            EventBus.getDefault().post(event)
        }
    }
}