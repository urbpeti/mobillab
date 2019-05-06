package com.example.brewie.mock


import com.example.brewie.model.Beer
import com.example.brewie.network.BrewApi
import okhttp3.Request
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.IOException
import java.util.*

class MockBrewApi : BrewApi {
    override fun getBeers(page: Int, per_page: Int): Call<List<Beer>> {
        val beers = ArrayList<Beer>()

        val beer = Beer()
        beer.name = "MockNetworkBeer"
        beer.image_url = "https://i.scdn.co/image/a16c5d95ede008ec905d6ca6d1b5abbf39ad4566"
        beer.abv = 3.5f
        beer.isMock = false
        beer.first_brewed = "1823"
        beer.description = "Mock beer"

        beers.add(beer)

        val call = object : Call<List<Beer>> {
            @Throws(IOException::class)
            override fun execute(): Response<List<Beer>> {
                return Response.success(beers)
            }

            override fun enqueue(callback: Callback<List<Beer>>) {

            }

            override fun isExecuted(): Boolean {
                return false
            }

            override fun cancel() {

            }

            override fun isCanceled(): Boolean {
                return false
            }

            override fun clone(): Call<List<Beer>> {
                return this
            }

            override fun request(): Request? {
                return null
            }
        }

        return call
    }


}