package net.iessochoa.pablolopez.practica1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

class Parte2Activity : AppCompatActivity() {
    companion object {
        const val EXTRA_HORA_INICIO = "extra_hora_inicio"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_parte2)

        val horaTextView: TextView = findViewById(R.id.tvHoras)
        val horaInicio = intent.getStringExtra(EXTRA_HORA_INICIO)
        val fechaYHoraActual = obtenerHoraActual()

        val horaDeInicio = getString(R.string.hora_de_inicio, horaInicio)
        val horaActualString = getString(R.string.hora_actual, fechaYHoraActual)
        horaTextView.text = "$horaDeInicio\n$horaActualString"
    }
    //obtengo la hora actual Con calendar
    private fun obtenerHoraActual():String {
        val cal = Calendar.getInstance()
        val año = cal.get(Calendar.YEAR)
        // Los meses comienzan desde 0
        val mes = cal.get(Calendar.MONTH) + 1
        val dia = cal.get(Calendar.DAY_OF_MONTH)
        val hora = cal.get(Calendar.HOUR_OF_DAY)
        val minuto = cal.get(Calendar.MINUTE)
        val segundo = cal.get(Calendar.SECOND)

        return String.format(
            "%04d-%02d-%02d %02d:%02d:%02d",
            año, mes, dia, hora, minuto, segundo
        )
    }
}