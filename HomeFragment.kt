package com.example.mwproto1.UI


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mwproto1.R
import com.example.mwproto1.ROOM.Database
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.coroutines.launch


class   HomeFragment : BaseFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        buttonAdd.setOnClickListener{
            val action =
                HomeFragmentDirections.actionHomeFragmentToAddPomiarFragment()
            Navigation.findNavController(it).navigate(action)
        }
        PomiarRV.apply{
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context)
        }
        launch{
           context?.let{
               val pomiary = Database(it).getPomiarDao().getAllPomiar()
               PomiarRV.adapter = PomiarAdapter(pomiary)
           }
        }

        }
    }


