package com.example.brewie.interactor.brews.event

import com.example.brewie.model.Beer

data class GetBeersEvent(
    var code: Int = 0,
    var brews: List<Beer>? = null,
    var throwable: Throwable? = null
)
