package com.example.mwproto1.ROOM

import android.app.Application
import androidx.lifecycle.LiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async

class Repository(application: Application) {


    private  var pomiardao: PomiarDao

    init {
        val database = Database
            .buildDatabase(application.applicationContext)
        pomiardao = database.getPomiarDao()

    }


    fun averageasync(): Deferred<Float> =
        CoroutineScope(Dispatchers.IO).async {
            pomiardao.average()
        }

}