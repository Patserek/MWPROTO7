package com.example.mwproto1

import android.content.Context
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity

import kotlinx.android.synthetic.main.activity_karta_pacjenta.*

class KartaPacjenta : AppCompatActivity() {


    lateinit var zapisz: Button
    lateinit var  Wiek: EditText
    lateinit var Waga: EditText
    lateinit var Choroba: EditText
    lateinit var Insulina: EditText



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_karta_pacjenta)
        setSupportActionBar(toolbar)


        // Shared Preferrence


        Wiek = findViewById(R.id.KartaWiek)
        Waga = findViewById(R.id.KartaWaga)
        Choroba = findViewById(R.id.KartaChoroba)
        Insulina = findViewById(R.id.KartaInsulina)




        zapisz = findViewById(R.id.btn_zapisz)



        readInfo()


        zapisz.setOnClickListener {
            saveInfo()
        }


        //-----------------------------------MECHANIKA FUNKCJI--------------------------------




    }

    // zapis Imienia i Nazwiska
    private fun saveInfo() {


        if(Wiek.text.isEmpty()) {
            Wiek.error="Wpisz wiek"
        }
        if(Waga.text.isEmpty()){
            Waga.error = "Wpisz wagę"
        }
        if(Choroba.text.isEmpty()){
            Choroba.error = "Wpisz rodzaj choroby"
        }
        if(Insulina.text.isEmpty()){
            Insulina.error = "Wpisz rodzaj przyjowanej insuliny"
        }



        val sp = getSharedPreferences("sp", Context.MODE_PRIVATE)
        val editSp = sp.edit()
        editSp.putString("Wiek", Wiek.text.toString())
        editSp.putString("Waga",Waga.text.toString())
        editSp.putString("Choroba",Choroba.text.toString())
        editSp.putString("Insulina",Insulina.text.toString())
        editSp.apply()

        Toast.makeText(this, "Zapisano", Toast.LENGTH_LONG).show()
    }

    private fun readInfo() {
        val sp = getSharedPreferences("sp", Context.MODE_PRIVATE)
        val wiek = sp.getString("Wiek","")
        val waga = sp.getString("Wiek","")
        val choroba = sp.getString("Choroba","")
        val insulina = sp.getString("Insulina","")




        Wiek.setText(wiek)
        Waga.setText(waga)
        Choroba.setText(choroba)
        Insulina.setText(insulina)


    }

}



