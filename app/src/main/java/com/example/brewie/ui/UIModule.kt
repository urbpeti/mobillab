package com.example.brewie.ui

import android.content.Context
import com.example.brewie.interactor.brews.BrewsInteractor
import com.example.brewie.ui.brewdetails.BrewDetailsPresenter
import dagger.Module
import dagger.Provides
import com.example.brewie.ui.main.MainPresenter
import java.util.concurrent.Executor
import java.util.concurrent.Executors
import javax.inject.Singleton

@Module
class UIModule(private val context: Context) {

    @Provides
    fun context() = context

    @Provides
    @Singleton
    fun mainPresenter(executor: Executor, brewsInteractor: BrewsInteractor) = MainPresenter(executor, brewsInteractor)

    @Provides
    @Singleton
    fun brewDetailsPresenter() = BrewDetailsPresenter()

    @Provides
    @Singleton
    fun networkExecutor(): Executor = Executors.newFixedThreadPool(1)
}