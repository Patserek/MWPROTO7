package com.example.mwproto1

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.provider.CalendarContract
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import com.example.mwproto1.Note.BazaWynikow
import com.example.mwproto1.UI.Dzienniczek
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.components.AxisBase
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.components.YAxis
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.formatter.ValueFormatter
import com.github.mikephil.charting.highlight.Highlight
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet
import com.github.mikephil.charting.listener.OnChartValueSelectedListener

import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity(), OnChartValueSelectedListener {

    val xValsDateLabel = ArrayList<String>()
    private lateinit var Wykres:LineChart
    private var entries = java.util.ArrayList<Entry>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            val intent = Intent(this, Dzienniczek::class.java)
            startActivity(intent)
        }

        FabPrzypomnienia.setOnClickListener { view ->

            val startMillis: Long = Calendar.getInstance().run {
                set(2020, 2, 27, 7, 30)
                timeInMillis
            }
            val endMillis: Long = Calendar.getInstance().run {
                set(2019, 11, 10, 8, 30)
                timeInMillis
            }
            val intent = Intent(Intent.ACTION_INSERT)
                .setData(CalendarContract.Events.CONTENT_URI)
                .putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, startMillis)
                .putExtra(CalendarContract.EXTRA_EVENT_END_TIME, endMillis)
                .putExtra(CalendarContract.Events.TITLE, "")
                .putExtra(CalendarContract.Events.DESCRIPTION, "")
                .putExtra(CalendarContract.Events.EVENT_LOCATION, "")
                .putExtra(
                    CalendarContract.Events.AVAILABILITY,
                    CalendarContract.Events.AVAILABILITY_BUSY
                )
            startActivity(intent)
        }

        //Chart

        Wykres = findViewById(R.id.Wykres)
        entries.add(Entry(0f, 5f))
        entries.add(Entry(1f, 10f))
        entries.add(Entry(2f, 15f))
        entries.add(Entry(3f, 20f))
        entries.add(Entry(4f, 5f))
        entries.add(Entry(5f, 10f))

        val set1 = LineDataSet(entries, "Water")
        set1.fillAlpha = 110

        val dataSet = java.util.ArrayList<ILineDataSet>()
        dataSet.add(set1)

        val lineData = LineData(dataSet)
        Wykres.data = lineData

        set1.color = Color.RED
        set1.mode = LineDataSet.Mode.CUBIC_BEZIER
        Wykres.description.text = ""
        Wykres.legend.isEnabled = false
        Wykres.invalidate()
        Wykres.axisRight.isEnabled = false
        Wykres.axisLeft.setPosition(YAxis.YAxisLabelPosition.OUTSIDE_CHART)
        Wykres.axisRight.setPosition(YAxis.YAxisLabelPosition.OUTSIDE_CHART)


        val xAxis = Wykres.xAxis
        xAxis.position = XAxis.XAxisPosition.BOTTOM
        xAxis.setDrawGridLines(false)
        xAxis.labelCount = 4
        xAxis.granularity = 1f
        xAxis.isGranularityEnabled = true

        val xValsDateLabel = ArrayList<String>()

        val xValsOriginalMillis = ArrayList<Long>()
        xValsOriginalMillis.add(1554875423736L)
        xValsOriginalMillis.add(1555275494836L)
        xValsOriginalMillis.add(1585578525900L)
        xValsOriginalMillis.add(1596679626245L)
        xValsOriginalMillis.add(1609990727820L)

        for (i in xValsOriginalMillis.indices) {
            val mm = xValsOriginalMillis[i] / 60 % 60
            val hh = xValsOriginalMillis[i] / (60 * 60) % 24
            val mDateTime = "$hh:$mm"
            xValsDateLabel.add(mDateTime)
        }

        class MyValueFormatter(private val xValsDateLabel: ArrayList<String>) : ValueFormatter() {

            override fun getFormattedValue(value: Float): String {
                return value.toString()
            }

            override fun getAxisLabel(value: Float, axis: AxisBase): String {
                xAxis.valueFormatter = (MyValueFormatter(xValsDateLabel))
                if (value.toInt() >= 0 && value.toInt() <= xValsDateLabel.size - 1) {
                    return xValsDateLabel[value.toInt()]
                } else {
                    return ("").toString()
                }
            }
        }
    }



    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
             when (item.itemId) {
            R.id.Karta_Packenta -> {
                val intent = Intent(this, KartaPacjenta::class.java)
                startActivity(intent)
            }
            R.id.wymienniki->{
                val intent = Intent(this,Wymienniki::class.java)
                startActivity(intent)
                }
            R.id.Note->{
                val intent = Intent(this,BazaWynikow::class.java)
                startActivity(intent)
            }
                 R.id.average->{
                     val intent = Intent(this, Analiza::class.java)
                     startActivity(intent)
                 }


        }
        return super.onOptionsItemSelected(item)
    }

    override fun onNothingSelected() {
    }

    override fun onValueSelected(e: Entry?, h: Highlight?) {
    }
}
