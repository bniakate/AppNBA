package com.example.esiea3a.affichage

import android.app.Application
import android.content.Context

class LegendApplication : Application(){
    companion object{
       var context: Context? = null
    }

    override fun onCreate() {
        super.onCreate()
        context = this
    }
}