package com.example.mwproto1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.mwproto1.ROOM.Pomiar
import com.example.mwproto1.UI.PomiarAdapter
import kotlinx.android.synthetic.main.activity_analiza.*

class Analiza : AppCompatActivity() {

    private lateinit var textView: TextView
    private lateinit var viewModel: ViewModel
    private lateinit var daoAdapter:PomiarAdapter
    private lateinit var pomiar:LiveData<List<Pomiar>>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_analiza)

        viewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(application)
            .create(ViewModel::class.java)

        textView = findViewById(R.id.TV7)

        pomiar = viewModel.AverageMV()
        pomiar.observe(this, Observer {
            if(it.isEmpty()){
                daoAdapter = PomiarAdapter(it)
                textView.adapter = daoAdapter
            }
        })


}

}


