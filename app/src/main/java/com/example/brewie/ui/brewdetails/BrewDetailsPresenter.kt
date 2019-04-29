package com.example.brewie.ui.brewdetails

import com.example.brewie.interactor.brews.BrewsInteractor
import com.example.brewie.interactor.brews.event.GetBeerEvent
import com.example.brewie.model.Beer
import com.example.brewie.ui.Presenter
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
import java.util.concurrent.Executor
import javax.inject.Inject

class BrewDetailsPresenter @Inject constructor(private val executor: Executor,private val brewsInteractor: BrewsInteractor): Presenter<BrewDetailsScreen>() {
    override fun attachScreen(screen: BrewDetailsScreen) {
        super.attachScreen(screen)
        EventBus.getDefault().register(this)
    }

    override fun detachScreen() {
        EventBus.getDefault().unregister(this)
        super.detachScreen()
    }

    fun refreshBeer(id: Int, isMocked: Boolean) {
        executor.execute {
            brewsInteractor.getBeer(id, isMocked)
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onEventMainThread(event: GetBeerEvent) {
        if (event.throwable != null) {
            event.throwable?.printStackTrace()
            if (screen != null) {
                screen?.showNetworkError(event.throwable?.message.orEmpty())
            }
        } else {
            if (screen != null) {
                if (event.brew != null) {
                    screen?.showBrew(event.brew as Beer)
                }
            }
        }
    }
}
