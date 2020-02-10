package com.example.mwproto1

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.SearchView
import androidx.appcompat.app.AppCompatActivity

import kotlinx.android.synthetic.main.activity_wymienniki.*

class Wymienniki : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wymienniki)
        setSupportActionBar(toolbar)

        val search = findViewById<SearchView>(R.id.search_View) as SearchView
        val list = findViewById<ListView>(R.id.ListView)as ListView
        val listaWymienniki = arrayOf("Arbuz 100 g 19kcal 0,4WW", "Banan 1 szt. 180 g 108kcal 2,7WW"," Brzoskwinie z puszki 1/2 szt. 60 g 33kcal 0,8WW", "Grapefruit 1/2 szt. 150 g 35kcal 1WW", "Gruszka 1 szt. średnia 150 g 62kcal 1,6WW", "Jabłko 1 szt. średnia 150 g 51kcal 1,3WW", "Melon 1/2 szt. 750 g 143kcal 3,2WW", "Morele suszone 3 szt. 24 g 68kcal 1,8WW", "Pomarańcze 1 szt. średnia 200 g 64kcal 1,6WW","Rodzynki suszone 1/4 szklanki 75 g 208kcal 5,3WW", "Śliwki suszone 6 szt. 30 g 68kcal 1,8WW", "Truskawki 10 szt. 140 g 38kcal 1WW", "Mandarynki 2 szt. 100 g 32kcal 0,8WW", "Kiwi 1 szt. 88 g 42kcal 1WW", "Maliny 100 g 29kcal 1,2WW", "Czarna porzeczka 1 szklanka 112 g 52kcal 1,6WW", "Winogrona 1 szt. 100 g 68kcal 1,7WW","WARZYWA","Brokuły 100 g 16kcal 0,3WW", "Burak 100 g 28kcal 0,7WW", "Cebula 100 g 27kcal 0,6WW", "Fasola biała 50 g such. ziar. 144kcal 3,1WW","Fasola szparagowa 100 g 24kcal 0,7WW", "Frytki 10 szt. 30 g 76kcal 1WW", "Groszek zielony 50 g 32kcal 0,8WW", "Kalafior 100 g 14kcal 0,3WW", "Kapusta biała 100 g 24kcal 0,6WW", "Kukurydza gotowana 1 kolba 250 g 145kcal 3,1WW", "Marchew 100 g 20kcal 0,6WW", "Papryka konserwowa 100 g 30kcal 0,5WW","Pomidor 100 g 15kcal 0,4WW","Szparagi 6 szt. 100 g 59kcal 1,2WW","Szpinak 100 g 13kcal 0,2WW","Por 1 szt 124 g 17kcal 0,4WW","Kapusta kiszona 100 g 11kcal 0,3WW","Kapusta pekińska 1 porcja 70 g 7kcal 0,2WW",
            "Sałata 200 g 20kcal 0,4WW","Kalarepa 140 g 28kcal 0,6WW","Brukselka 100 g 28kcal 0,7WW","Zielony ogórek 100 g 10kcal 0,2WW","Konserwowy ogórek 50 g 8 0,2","Chipsy 10 szt. 45g 242kcal 2,4WW","Kukurudza w puszce 100 g 23kcal 0,2WW","Ziemniak 100 g 60kcal 1,4WW","SŁODYCZE I PRZEKĄSKI", "Babeczka śmietankowa 1 szt. 60 g 199kcal 2,6WW","Baton SNICKERS 1 szt. 60 g 298lkcal 3,2WW","Cukier 1 łyż 10 g 41kcal 1WW","Dżem wysokosłodzony 1 łyż 20 g 50kcal 1,3WW","Dżem niskosłodzony 1 łyż 20 g 31kcal 0,8WW","Ekler czekoladowy 1 szt. 50 g 164kcal 1,8WW", "Galaretka owocowa 1/2 szklanki 100 g 70kcal 1,5WW","Herbatnik 1 szt. 10 g 44kcal 0,8WW","Karmelek 5 szt. 20 g 80kcal 2WW","Keks owocowy 50 g 194kcal 2,7WW","Miód naturalny 1 łyż 20 g 65kcal 1,6WW","Pączek 1 szt. 50 g 189kcal 2,6WW","Pierniki czekoladowe 3 szt. 50 g 189kcal 3,5WW","Ptyś z bitą śmietaną 50 g 174kcal 1,3WW","Sernik wiedeński 100 g 344kcal 3,2WW","Syrop truskawkowy 1 łyż 20 g 52kcal 1,3WW","Szarlotka 80 g 222kcal 4,2WW","Orzechy kokosowe 100 g 606kcal 2,7WW","Orzeszki ziemne 140 g 791kcal 2,7WW","Orzeszki laskowe 100 g 646kcal 1,5WW","Orzeszki włoskie 100 g 651kcal 1,8WW","ZUPY","Grzybowa zabielana 250 g 75kcal 0,5WW","Ogórkowa 250 g 108kcal 1,2WW","Krupnik 250 g 110kcal 1,9WW","Pomidorowa z makaronem 250 g 90kcal 0,8WW","Kapuśniak 250 g 58kcal 0,4WW",
            "Jarzynowa 250 g 83kcal 1,1WW","Zupa grochowa 250 g 188kcal 2,2WW","żurek z ziemniakami 250 g 320kcal 5,6WW","Barszcz czerwony 250 g 88kcal 0,9WW","Rosół z drobiu 250 g 72kcal 1,5WW","Ziemniaczana 250 g 103kcal 1,6WW","NAPOJE","Cola 250 ml 105kcal 2,6WW","Herbata bez cukru 250 g 0kcal 0WW","Kawa bez cukru 250 g 5kcal 0,1WW","Kakao na mleku 250 g 163kcal 2,1WW","Sok jabłkowy 120 g 50kcal 1,2WW","Sok pomarańczowy 120 g 52kcal 1,2WW","Sok pomidorowy 120 g 16kcal 0,3WW","NABIAŁ","Jajko 50 g 67kcal", "żółtko jajka 17 g 60kcal","Białko jajka 33 g 16kcal","Jogurt nat. 2% tł 250 ml. 150kcal 1,6WW","Mleko kwaszone 2% tł. 250 ml. 128kcal 1,2WW","Jogurt z owocami 250 ml. 150kcal 2,1WW","Kefir 2 % tł 250 ml. 128kcal 1,2WW","Lody owocowe 100 g 116kcal 1,9WW","Lody śmietankowe 100 g 160kcal 1,8WW","Mleko odtłuszczone 0,5 tł. 250 g 98kcal 1,3WW","Mleko 2 % tł. 250 g 128kcal 1,2WW","Mleko zagęszczone niesłodz 100 g 131kcal 0,9WW","Serek topiony 100 g 299kcal 0,1WW","Serek twarogowy chudy 100 g 99kcal 0,4WW","Serek homogen. 100 g 161kcal 0,3WW","Serek twar tłusty 100 g 175kcal 0,4WW","Ser żółty  20 g 58kcal 0WW","Śmietana 12 % tł 100 g 133kcal 0,4WW","Śmietana 18 % tł 100 g 184cal 0,4WW",
            "Śmietana 30 % 100 g 287kcal 0,4WW","RYBY I DRÓB","Dorsz 100 g 70kcal 0WW","Halibut 100 g 99kcal 0WW","Karp 100 g 111kcal 0WW","Krewetki 100 g 73kcal 0WW","Makrela w oleju 100 g 339kcal 0,1WW","Szproty w pomidorach 100 g 173kcal 0,7WW","Śledź w oleju 100 g 340kcal 0WW","Śledź marynowany 100 g 183kcal 0,3WW","Pierś indyka 100 g 84kcal 0WW","Uda indyka 100 g 93kcal 0WW","Pierś kurczaka 100 g 99kcal 0WW","Uda Kurczaka 100 g 101kcal 0WW","Wątróbki drobiowe 100 g 136kcal 0WW","MIĘSO I WĘDLINY","Boczek surowy 20 g 103kcal 0WW","Pasztetowa 100 g 345kcal 0,4WW","Salceson 100 g 255kcal 0WW","Kiełbasa zwyczajna 100 g 195kcal 0WW","Kotlet miel.-wołowy 100 g 210kcal 1,2WW","Kotlet schabowy 100 g 357kcal 1,6WW","Parowki 1 sztuka 45 g 106kcal 0WW","Szynka gotowana  20 g 45kcal 0WW","Wątróbka cielęca 100 g 104kcal 0WW","Kabanosy 1 sztuka 10 g 32kcal 0WW","Kiełbasa myśliwska 100 g 285kcal 0WW ","Polędwica 100 g 165kcal 0,1WW","Szynka z drobiu 100 g 119kcal 0WW","Golonka 100 g 247kcal 0WW","Cielęcina bez kości 100 g 104kcal 0WW","Wołowina 100 g 117kcal 0WW","TŁUSZCZE Majonez 20 g 143kcal 0WW","Margaryna  15 g 107kcal 0WW", "Masło 5 g 37kcal 0WW","Masło roślinne  5 g 36kcal 0WW","Oleje roślinne  15 g 133kcal 0WW",
            "Smalec  15 g 132kcal 0WW","PRZETWORY ZBOŻOWE","Bułka grahamka 1 szt. 50 g 129kcal 2,9WW","Chleb pszenny 1 kromka 40 g 100kcal 2,2WW","Chleb żytni 1 kromka 40 g 96kcal 2,3WW","Kasza jęczmienna 22 g 28kcal 0,5WW","Kasza manna 30 g 37kcal 0,7WW","Kopytka 100 g 148kcal 3,2WW","Naleśniki 100 g 239kcal 4,1WW","Pierogi leniwe 100 g 217kcal 2WW","Makaron 2-jajeczny 50 g 53kcal 1WW","Mąka pszenna 30 g 103kcal 2,3WW","Otręby pszenne 30 g 56kcal 1,9WW","Platki kukurydziane 20 g 73kcal 1,7WW","Płatki owsiane 26 g 95kcal 1,8WW","Pumpernikiel 1 kromka 50 g 126kcal 2,9WW","Paluszki slone 100 g 385kcal 7,5WW","Pieczywo chrupkie 8 g 28kcal 0,6WW","Bułka zwykła 50 g 136kcal 2,9WW","Ryż  20 g 27kcal 0,6WW","DODATKI","Musztarda 15 g 24kcal 0,3WW","Ketchup 20 g 19kcal 0,5WW","Sosy sałatkowe 15 g 69kcal 0WW","ALKOHOL","Likier 1 kieliszek 25 g 66kcal 0,8WW","Piwo jasne 0,5 l 245kcal 1,9WW","Wino deserowe 100 g 96kcal 0,6WW","Wino wytrawne 100 g 65kcal 0WW","Szampan 100g 76kcal 0,1WW","Wódka czysta 40 g 88kcal 0WW" )

        val listaWymiennikiAdap : ArrayAdapter<String> = ArrayAdapter(this,android.R.layout.simple_list_item_1,listaWymienniki)
        list.adapter = listaWymiennikiAdap
        search.setOnQueryTextListener(object: SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                listaWymiennikiAdap.filter.filter(newText)
                return false
            }
        })
        //Ustawienie widoku w formie kolumn
        //recyclerView.layoutManager = GridLayoutManager(this,4)
        //recyclerView.adapter

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

}
