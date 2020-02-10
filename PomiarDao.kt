package com.example.mwproto1.ROOM

import androidx.lifecycle.LiveData
import androidx.room.*


@Dao
interface PomiarDao {

    @Insert
    suspend fun addPomiar(pomiar: Pomiar)

    @Query("SELECT * FROM pomiar ORDER BY id DESC")
    suspend fun getAllPomiar():List<Pomiar>

    @Insert
    suspend fun addMultiplePomiar(vararg pomiar: Pomiar)

    @Update
    suspend fun  updatePomiar(pomiar: Pomiar)

    @Delete
    suspend fun deletePomiar(pomiar: Pomiar )

    @Query("SELECT avg(Stezenie) FROM Pomiar ")
     fun average(): Float
}