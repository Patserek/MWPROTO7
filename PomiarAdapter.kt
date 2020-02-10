package com.example.mwproto1.UI

import android.annotation.SuppressLint
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.mwproto1.R
import com.example.mwproto1.ROOM.Pomiar
import kotlinx.android.synthetic.main.fragment_add_pomiar.view.*
import kotlinx.android.synthetic.main.item_pomiar.view.*

class PomiarAdapter(val pomiary:List<Pomiar>):RecyclerView.Adapter<PomiarAdapter.PomiarViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PomiarViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_pomiar,parent,false)
        return PomiarViewHolder(view)

    }

    override fun getItemCount() = pomiary.size


    override fun onBindViewHolder(holder: PomiarViewHolder, position: Int) {

        holder.view.Stezenie.text = pomiary[position].Stezenie
        holder.view.Data.text = pomiary[position].Data
        holder.view.Zegar.text = pomiary[position].Zegar
        holder.view.Posiłek.text=pomiary[position].Posilek
        holder.view.Samopoczucie.text=pomiary[position].Samopoczucie
        holder.view.Stres.text=pomiary[position].Stres
        holder.view.Hiperglikemia.text=pomiary[position].Hiperglikemia
        holder.view.setOnClickListener{
            val action = HomeFragmentDirections.actionHomeFragmentToAddPomiarFragment()
            action.pomiar = pomiary[position]
            Navigation.findNavController(it).navigate(action)
        }
    }
    class PomiarViewHolder(val view: View) : RecyclerView.ViewHolder(view)
}