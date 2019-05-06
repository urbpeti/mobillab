package com.example.brewie.test

import com.example.brewie.model.Beer
import com.example.brewie.testInjector
import com.example.brewie.ui.main.MainPresenter
import com.example.brewie.ui.main.MainScreen
import com.example.brewie.utils.argumentCaptor
import com.example.brewie.utils.mock
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.verify
import org.robolectric.RobolectricTestRunner
import javax.inject.Inject

@RunWith(RobolectricTestRunner::class)
class MainTest {
    @Inject
    lateinit var mainPresenter: MainPresenter
    private lateinit var mainScreen: MainScreen

    @Throws(Exception::class)
    @Before
    fun setup() {
        testInjector.inject(this)
        mainScreen = mock()
        mainPresenter.attachScreen(mainScreen)
    }

    @Test
    fun testRefreshBrews() {
        mainPresenter.refreshBrews("")

        val list = argumentCaptor<MutableList<Beer>>()
        verify(mainScreen).showBrews(list.capture())
        assert(list.value.size > 0)
    }

    @Test
    fun testShowBrewDetails() {
        val beer = Beer(1)
        mainPresenter.showBrewDetails(beer)

        verify(mainScreen).showBrewDetails(beer)
    }

    @Test
    fun testShowNewBrew() {
        mainPresenter.showNewBrew()

        verify(mainScreen).showNewBrew()
    }

    @After
    fun tearDown() {
        mainPresenter.detachScreen()
    }
}