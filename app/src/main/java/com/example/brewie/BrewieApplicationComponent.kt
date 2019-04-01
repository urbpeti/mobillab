package com.example.brewie

import android.net.Network
import com.example.brewie.interactor.InteractorModule
import com.example.brewie.network.NetworkModule
import dagger.Component
import com.example.brewie.ui.UIModule
import com.example.brewie.ui.main.MainActivity
import javax.inject.Singleton

@Singleton
@Component(modules = [UIModule::class, NetworkModule::class, InteractorModule::class])
interface BrewieApplicationComponent {
    fun inject(mainActivity: MainActivity)
}