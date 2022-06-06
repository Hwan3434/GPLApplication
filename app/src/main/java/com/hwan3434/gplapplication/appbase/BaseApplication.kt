package com.hwan3434.gplapplication.appbase

import android.app.Application
import androidx.lifecycle.*
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
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