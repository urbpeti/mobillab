package com.example.brewie

import com.example.brewie.interactor.InteractorModule
import com.example.brewie.mock.MockDatabaseModule
import com.example.brewie.mock.MockNetworkModule
import com.example.brewie.test.BrewDetailsTest
import com.example.brewie.test.MainTest
import com.example.brewie.test.NewBrewTest
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [MockDatabaseModule::class, MockNetworkModule::class, TestModule::class, InteractorModule::class])
interface TestComponent : BrewieApplicationComponent {
    fun inject(mainTest: MainTest)
    fun inject(newBrewTest: NewBrewTest)
    fun inject(brewDetailsTest: BrewDetailsTest)
}