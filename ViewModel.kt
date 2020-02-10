package com.example.mwproto1.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.mwproto1.ROOM.Pomiar
import com.example.mwproto1.ROOM.Repository
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.runBlocking

class ViewModel(application: Application):AndroidViewModel(application) {

    private var PomiarRepository: Repository = Repository(application)

    private var allpomiar: Deferred<Float> =
        PomiarRepository.averageasync()


    fun AverageVM(): Float = runBlocking {
        allpomiar.await()
    }
}