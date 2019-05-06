package com.example.brewie.test

import com.example.brewie.data.db.dao.BeerDao
import com.example.brewie.model.Beer
import com.example.brewie.testInjector
import com.example.brewie.ui.newbrew.NewBrewPresenter
import com.example.brewie.ui.newbrew.NewBrewScreen
import com.example.brewie.utils.mock
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.verify
import org.robolectric.RobolectricTestRunner
import javax.inject.Inject

@RunWith(RobolectricTestRunner::class)
class NewBrewTest {
    @Inject
    lateinit var newBrewPresenter: NewBrewPresenter
    @Inject
    lateinit var beerDao: BeerDao

    private lateinit var newBrewScreen: NewBrewScreen

    @Throws(Exception::class)
    @Before
    fun setup() {
        testInjector.inject(this)
        newBrewScreen = mock()
        newBrewPresenter.attachScreen(newBrewScreen)
    }

    @Test
    fun testAddNewBrew() {
        val beer = Beer(1)
        newBrewPresenter.addBrew(beer)

        verify(beerDao).insert(com.example.brewie.data.db.entity.Beer(
            null, "", "", "", 0.0f, "" ))
    }

    @After
    fun tearDown() {
        newBrewPresenter.detachScreen()
    }
}
