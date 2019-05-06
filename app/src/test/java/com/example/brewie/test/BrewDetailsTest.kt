package com.example.brewie.test

import com.example.brewie.data.db.dao.BeerDao
import com.example.brewie.model.Beer
import com.example.brewie.testInjector
import com.example.brewie.ui.brewdetails.BrewDetailsPresenter
import com.example.brewie.ui.brewdetails.BrewDetailsScreen
import com.example.brewie.utils.mock
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.verify
import org.robolectric.RobolectricTestRunner
import javax.inject.Inject

@RunWith(RobolectricTestRunner::class)
class BrewDetailsTest {
    @Inject
    lateinit var brewDetailsPresenter: BrewDetailsPresenter
    @Inject
    lateinit var beerDao: BeerDao

    private lateinit var brewDetailsScreen: BrewDetailsScreen

    @Throws(Exception::class)
    @Before
    fun setup() {
        testInjector.inject(this)
        brewDetailsScreen = mock()
        brewDetailsPresenter.attachScreen(brewDetailsScreen)
    }

    @Test
    fun testUpdateBrew() {
        val beer = Beer(1)
        brewDetailsPresenter.updateBeer(beer)
        verify(beerDao).updateBeer(com.example.brewie.data.db.entity.Beer(
            1, "Noname", "", "", 0.0f, "" ))
    }

    @Test
    fun testDeleteBrew() {
        brewDetailsPresenter.deleteBeer(1)
        verify(beerDao).deleteBeer(1)
    }

    @After
    fun tearDown() {
        brewDetailsPresenter.detachScreen()
    }
}
