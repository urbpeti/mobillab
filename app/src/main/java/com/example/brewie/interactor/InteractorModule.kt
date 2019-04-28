package com.example.brewie.interactor

import com.example.brewie.data.db.dao.BeerDao
import dagger.Module
import dagger.Provides
import com.example.brewie.interactor.brews.BrewsInteractor
import com.example.brewie.network.BrewApi
import javax.inject.Singleton

@Module
class InteractorModule {
    @Provides
    @Singleton
    fun provideArtistsInteractor(brewApi: BrewApi, beerDao: BeerDao) = BrewsInteractor(brewApi, beerDao)
}