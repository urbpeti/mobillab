package com.example.brewie

import com.example.brewie.data.db.DatabaseModule
import com.example.brewie.interactor.InteractorModule
import com.example.brewie.network.NetworkModule
import dagger.Component
import com.example.brewie.ui.UIModule
import com.example.brewie.ui.brewdetails.BrewDetailsActivity
import com.example.brewie.ui.main.MainActivity
import com.example.brewie.ui.newbrew.NewBrewActivity
import javax.inject.Singleton

@Singleton
@Component(modules = [UIModule::class, NetworkModule::class, InteractorModule::class, DatabaseModule::class])
interface BrewieApplicationComponent {
    fun inject(mainActivity: MainActivity)
    fun inject(brewDetailsActivity: BrewDetailsActivity)
    fun inject(newBrewActivity: NewBrewActivity)
}