package com.example.brewie

import android.app.Application
import com.example.brewie.ui.UIModule

class BrewieApplication : Application() {
    lateinit var injector: BrewieApplicationComponent

    override fun onCreate() {
        super.onCreate()
        injector = DaggerBrewieApplicationComponent.builder().uIModule(UIModule(this)).build()
    }
}
