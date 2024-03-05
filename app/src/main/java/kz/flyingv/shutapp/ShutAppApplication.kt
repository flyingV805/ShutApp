package kz.flyingv.shutapp

import android.app.Application
import android.util.Log
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class ShutAppApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        Log.d("ShutAppApplication", "onCreate")
    }

}