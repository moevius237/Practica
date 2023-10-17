package net.iessochoa.pablolopez.practica1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

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