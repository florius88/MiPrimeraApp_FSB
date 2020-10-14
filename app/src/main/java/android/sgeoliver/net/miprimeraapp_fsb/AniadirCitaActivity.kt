package android.sgeoliver.net.miprimeraapp_fsb

import android.content.Intent
import android.icu.number.IntegerWidth
import android.icu.util.GregorianCalendar
import android.os.Bundle
import android.provider.CalendarContract
import android.provider.CalendarContract.Events
import android.widget.CalendarView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_aniadir_cita.*


class AniadirCitaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_aniadir_cita)

        var dia: Int = 0
        var mes: Int = 0
        var anio: Int = 0

        val calendarView = findViewById<CalendarView>(R.id.calAniadirCitaCalendario)
        calendarView?.setOnDateChangeListener { view, year, month, dayOfMonth ->
            dia = dayOfMonth
            mes = month
            anio = year
        }

        btnAniadirCitaAniadir.setOnClickListener { addCita(dia, mes, anio) }
    }

    private fun addCita( dia: Int, mes: Int, anio: Int) {
        val calIntent = Intent(Intent.ACTION_INSERT)
        calIntent.type = "vnd.android.cursor.item/event"
        calIntent.putExtra(Events.TITLE, editTextAniadirCitaCita.text.toString())
        calIntent.putExtra(Events.DESCRIPTION, editTextAniadirCitaDescripcion.text.toString())


        val calDate = GregorianCalendar(anio, mes, dia)
        calIntent.putExtra(CalendarContract.EXTRA_EVENT_ALL_DAY, true)
        calIntent.putExtra(
            CalendarContract.EXTRA_EVENT_BEGIN_TIME,
            calDate.getTimeInMillis())

        startActivity(calIntent)

    }
}