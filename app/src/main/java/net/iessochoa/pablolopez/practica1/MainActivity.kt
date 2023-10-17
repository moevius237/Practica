package net.iessochoa.pablolopez.practica1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    private lateinit var etNombre:EditText
    private lateinit var btAceptar:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //buscamos los views
        etNombre=findViewById(R.id.etNombre)
        btAceptar=findViewById(R.id.btAceptar)
    }
}