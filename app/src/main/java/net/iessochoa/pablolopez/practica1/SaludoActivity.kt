package net.iessochoa.pablolopez.practica1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class SaludoActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_NOMBRE = "practica1.SaludoActivity.nombre"
    }

    private lateinit var tvSaludo: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_saludo)
        //asignamos la instancia de tvSaludo
        val nombre=intent.getStringExtra(EXTRA_NOMBRE)
        //mostramos el valor
        tvSaludo.text="Hola "+nombre+"!!"
    }


}