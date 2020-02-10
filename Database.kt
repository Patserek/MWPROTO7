package com.example.mwproto1.ROOM

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = arrayOf(Pomiar::class),
    version = 1
)
abstract class Database:RoomDatabase(){
    abstract fun getPomiarDao():PomiarDao

    companion object{
        @Volatile private var instance:com.example.mwproto1.ROOM.Database?=null
        private val LOCK = Any()

        operator fun invoke(context: Context)= instance?: synchronized(LOCK){
            instance ?: buildDatabase(context).also{ it ->
                instance = it
            }
        }
        fun buildDatabase(context: Context) = Room.databaseBuilder(
            context.applicationContext,
            com.example.mwproto1.ROOM.Database::class.java,
            "pomiardatabase"
        ).build()

    }


}