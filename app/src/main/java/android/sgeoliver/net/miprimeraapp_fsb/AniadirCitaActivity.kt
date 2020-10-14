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
    private var cita: String = ""
    private var descrip: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_aniadir_cita)

        this.cita = editTextAniadirCitaCita.text.toString()
        this.descrip = editTextAniadirCitaDescripcion.text.toString()

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

    // Para salvar el estado por ejemplo es usando un Bundle en el ciclo de vida
    override fun onSaveInstanceState(outState: Bundle) {
        outState.run {
            putString("CITA", cita)
            putString("DESCRIPCION", descrip)
        }
        super.onSaveInstanceState(outState)
    }

    // Para recuperar el estado al volver al un estado de ciclo de vida de la Interfaz
    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        // Recuperamos en un bundle estas variables o estados de la interfaz
        super.onRestoreInstanceState(savedInstanceState)
        savedInstanceState.run {
            cita = getString("CITA").toString()
            descrip = getString("DESCRIPCION").toString()

        }
    }
}