package com.hwan3434.gplapplication.base

import android.app.Application
import androidx.lifecycle.*

class BaseApplication : Application() {


    override fun onCreate() {
        super.onCreate()

        ProcessLifecycleOwner.get().lifecycle
            .addObserver(object : LifecycleEventObserver{
                override fun onStateChanged(source: LifecycleOwner, event: Lifecycle.Event) {

                    fun registerSensor() {

                    }

                    fun unregisterSensor() {

                    }

                    fun onStateChanged(source: LifecycleOwner, event: Lifecycle.Event) {
                        if (event == Lifecycle.Event.ON_RESUME) {
                            registerSensor()
                        } else if (event == Lifecycle.Event.ON_PAUSE) {
                            unregisterSensor()
                        }
                    }


                }

            })

    }
}