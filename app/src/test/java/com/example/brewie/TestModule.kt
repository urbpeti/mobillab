package com.example.brewie

import android.content.Context
import dagger.Module
import dagger.Provides
import com.example.brewie.interactor.brews.BrewsInteractor
import com.example.brewie.ui.brewdetails.BrewDetailsPresenter
import com.example.brewie.ui.main.MainPresenter
import com.example.brewie.ui.newbrew.NewBrewPresenter
import com.example.brewie.utils.UiExecutor
import java.util.concurrent.Executor
import javax.inject.Singleton

@Module
class TestModule(private val context: Context) {

    @Provides
    fun provideContext() = context

    @Provides
    @Singleton
    fun provideMainPresenter(executor: Executor, brewsInteractor: BrewsInteractor) = MainPresenter(executor, brewsInteractor)

    @Provides
    @Singleton
    fun newBrewPresenter(brewsInteractor: BrewsInteractor) = NewBrewPresenter(brewsInteractor)

    @Provides
    @Singleton
    fun brewDetailsPresenter(executor: Executor, brewsInteractor: BrewsInteractor) = BrewDetailsPresenter(executor, brewsInteractor)

    @Provides
    @Singleton
    fun provideNetworkExecutor(): Executor = UiExecutor()
}