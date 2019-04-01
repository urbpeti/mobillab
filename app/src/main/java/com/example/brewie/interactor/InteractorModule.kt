package com.example.brewie.interactor

import dagger.Module
import dagger.Provides
import com.example.brewie.interactor.brews.BrewsInteractor
import com.example.brewie.network.BrewApi
import javax.inject.Singleton

@Module
class InteractorModule {
    @Provides
    @Singleton
    fun provideArtistsInteractor(brewApi: BrewApi) = BrewsInteractor(brewApi)
}