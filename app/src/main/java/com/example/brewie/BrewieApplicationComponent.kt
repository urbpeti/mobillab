package com.example.brewie

import dagger.Component
import com.example.brewie.ui.UIModule
import com.example.brewie.ui.main.MainActivity
import javax.inject.Singleton

@Singleton
@Component(modules = [UIModule::class])
interface BrewieApplicationComponent {
    fun inject(mainActivity: MainActivity)
}