package com.example.brewie

import android.app.Activity
import android.support.v4.app.Fragment


val Activity.injector: BrewieApplicationComponent
    get() {
        return (this.applicationContext as BrewieApplication).injector
    }

val Fragment.injector: BrewieApplicationComponent
    get() {
        return (this.context!!.applicationContext as BrewieApplication).injector
    }