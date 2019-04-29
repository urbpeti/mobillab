package com.example.brewie.ui.main

import com.example.brewie.interactor.brews.BrewsInteractor
import com.example.brewie.interactor.brews.event.GetBeersEvent
import com.example.brewie.model.Beer
import com.example.brewie.ui.Presenter
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
import java.util.concurrent.Executor
import javax.inject.Inject

class MainPresenter @Inject constructor(private val executor: Executor, private val brewsInteractor: BrewsInteractor ) : Presenter<MainScreen>() {
    override fun attachScreen(screen: MainScreen) {
        super.attachScreen(screen)
        EventBus.getDefault().register(this)
    }

    override fun detachScreen() {
        EventBus.getDefault().unregister(this)
        super.detachScreen()
    }


    fun refreshBrews(brewQuery: String) {
        executor.execute {
            brewsInteractor.getBrews(brewQuery)
        }
    }

    fun showBrewDetails(beer: Beer) {
        screen?.showBrewDetails(beer)
    }

    fun showNewBrew() {
        screen?.showNewBrew()
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onEventMainThread(event: GetBeersEvent) {
        if (event.throwable != null) {
            event.throwable?.printStackTrace()
            if (screen != null) {
                screen?.showNetworkError(event.throwable?.message.orEmpty())
            }
        } else {
            if (screen != null) {
                if (event.brews != null) {
                    screen?.showBrews(event.brews as MutableList<Beer>)
                }
            }
        }
    }
}
