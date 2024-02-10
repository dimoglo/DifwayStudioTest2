package com.example.difwaystudioproject

import android.app.Application
import com.yandex.mapkit.MapKitFactory

class DifwayApplication: Application() {
    override fun onCreate() {
        MapKitFactory.setApiKey(BuildConfig.MAPKIT_API_KEY)
        super.onCreate()
    }
}