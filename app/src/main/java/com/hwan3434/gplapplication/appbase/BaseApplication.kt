package com.hwan3434.gplapplication.appbase

import android.app.Application
import androidx.lifecycle.*
import com.hwan3434.gplapplication.appbase.log.logd
import com.hwan3434.gplapplication.appbase.log.loge
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class BaseApplication : Application(), LifecycleEventObserver {
    override fun onCreate() {
        super.onCreate()

        logd("BaseApplication @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@")

        ProcessLifecycleOwner.get().lifecycle.addObserver(this)

    }

    override fun onStateChanged(source: LifecycleOwner, event: Lifecycle.Event) {
        logd("event : " + event.name)

        when(event){
            Lifecycle.Event.ON_PAUSE -> {
                registerSensor()
            }
            Lifecycle.Event.ON_RESUME -> {
                unregisterSensor()
            }
            else -> {
                loge("error - onStateChanged");
            }
        }
    }

    fun registerSensor() {
        logd("registerSensor @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@")
    }

    fun unregisterSensor() {
        logd("unregisterSensor @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@")
    }
}