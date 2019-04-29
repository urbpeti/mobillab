package com.example.brewie.interactor.brews.event

import com.example.brewie.model.Beer

data class GetBeerEvent(
    var code: Int = 0,
    var brew: Beer? = null,
    var isMocked: Boolean = false,
    var throwable: Throwable? = null
)
