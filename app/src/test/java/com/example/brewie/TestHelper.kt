package com.example.brewie


import org.robolectric.RuntimeEnvironment
import org.robolectric.shadows.ShadowLog

val testInjector: TestComponent
    get() {
        ShadowLog.stream = System.out
        val application = RuntimeEnvironment.application as BrewieApplication
        val component = DaggerTestComponent.builder().testModule(TestModule(application.applicationContext)).build()
        application.injector = component
        return component
    }
