package net.iessochoa.pablolopez.practica1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.SimpleExpandableListAdapter
import android.widget.TextView
import android.widget.Toast
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

class MainActivity : AppCompatActivity() {
    private lateinit var etNombre:EditText
    private lateinit var btAceptar:Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //buscamos los views
        etNombre=findViewById(R.id.etNombre)
        btAceptar=findViewById(R.id.btAceptar)
        //Asignamos accion lambda
        btAceptar.setOnClickListener{enviarSaludo()}

        //Definimos el textview tvHora para pasarle informacion
        val horaTextView: TextView = findViewById(R.id.tvHora)
        val horaActual = obtenerHoraActual()
        horaTextView.text = getString(R.string.hora_label, horaActual)

        //Definimos el boton btParte2
        val parte2Button = findViewById<Button>(R.id.btParte2)
        parte2Button.setOnClickListener {
            val intent = Intent(this, Parte2Activity::class.java)
            intent.putExtra(Parte2Activity.EXTRA_HORA_INICIO, horaActual)
            startActivity(intent)
        }
    }
    //Obtengo la hora actual con Calendar
    private fun obtenerHoraActual(): String{
        val cal = Calendar.getInstance()
        val año = cal.get(Calendar.YEAR)
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
    fun enviarSaludo() {
        //comprobamos si el campo está vacío
        if (!etNombre.text.isEmpty()) {
            val intent = Intent(this, SaludoActivity::class.java)
            intent.putExtra(SaludoActivity.EXTRA_NOMBRE,
                etNombre.text.toString())
            startActivity(intent)
        } else
            Toast.makeText(this, getString(R.string.msj_nombre),
                Toast.LENGTH_LONG).show()
    }
}