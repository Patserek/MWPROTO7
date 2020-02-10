package com.example.mwproto1.UI


import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.navigation.Navigation
import com.example.mwproto1.R
import com.example.mwproto1.ROOM.Database
import com.example.mwproto1.ROOM.Pomiar
import kotlinx.android.synthetic.main.fragment_add_pomiar.*
import kotlinx.coroutines.launch


class AddPomiarFragment : BaseFragment() {

    private var pomiar: Pomiar? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setHasOptionsMenu(true)
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_pomiar, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        arguments?.let{
            pomiar = AddPomiarFragmentArgs.fromBundle(it).pomiar
            StezenieEd.setText(pomiar?.Stezenie)
            DataEd.setText(pomiar?.Data)
            ZegarEd.setText(pomiar?.Zegar)
            PosilekEd.setText(pomiar?.Posilek)
            SamopoczucieEd.setText(pomiar?.Samopoczucie)
            StresEd.setText(pomiar?.Stres)
            HiperglikemiaEd.setText(pomiar?.Hiperglikemia)
        }

        ButtonSave.setOnClickListener{
            val steznieEd = StezenieEd.text.toString().trim()
            val dataEd = DataEd.text.toString().trim()
            val zegarEd = ZegarEd.text.toString().trim()
            val posilekEd = PosilekEd.text.toString().trim()
            val SamopoczucieEd = SamopoczucieEd.text.toString().trim()
            val StresEd = StresEd.text.toString().trim()
            val HiperglikemiaEd = HiperglikemiaEd.text.toString().trim()

            if(steznieEd.isNullOrEmpty()){
                StezenieEd.error = "Wprowadź wynik pomiaru stęzenia"
                return@setOnClickListener
            }
            if(dataEd.isNullOrEmpty()){
                DataEd.error = "Wprowadź ponownie datę"
                return@setOnClickListener
            }
            if(zegarEd.isNullOrEmpty()){
                ZegarEd.error = "wprowadź ponownie godzinę"
                return@setOnClickListener
            }
            if(posilekEd.isNullOrEmpty()){
                PosilekEd.error = "Podaj jaki posiłek zjadłeś przed wynikiem"
                return@setOnClickListener
            }


            val newPomiar = Pomiar(steznieEd,dataEd,zegarEd,posilekEd,SamopoczucieEd,StresEd,HiperglikemiaEd)

            launch {
                if(pomiar==null){
                savePomiar(newPomiar)
                }else{
                    updatePomiar(newPomiar)
                }
            }

            navigateBack()

        }
    }

    private suspend fun updatePomiar(newPomiar:Pomiar){
        newPomiar.id=pomiar!!.id
        context?.let{
            Database(it).getPomiarDao().updatePomiar(newPomiar)
            Toast.makeText(it,"Pomiar zaktualizowany...",Toast.LENGTH_SHORT).show()
        }

    }


    private suspend fun savePomiar(pomiar: Pomiar){
        context?.let{
            Database(it).getPomiarDao().addPomiar(pomiar)
            Toast.makeText(it,"Pomiar dodany",Toast.LENGTH_SHORT).show()
        }

    }

    private fun navigateBack(){
        val action = AddPomiarFragmentDirections.addPomiar()
        Navigation.findNavController(ButtonSave).navigate(action)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.pomiar_menu,menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.delete->{
                pomiar?.let{
                    deletePomiar()
                }
            }
        }

        return super.onOptionsItemSelected(item)
    }

    private fun deletePomiar(){
        context?.let{
            AlertDialog.Builder(it).apply {
                setTitle("Czy na pewno chcesz usunąć pomiar ?? ")
                setMessage("Nie można cofnąć usuniętego pomiaru... ")
                setPositiveButton("OK"){dialog, which ->
                    launch {
                        Database(it).getPomiarDao().deletePomiar(pomiar!!)
                        navigateBack()
                    }
                }
                setNegativeButton("Cencel"){dialog, which ->  }
                show()
            }
        }

    }


}
