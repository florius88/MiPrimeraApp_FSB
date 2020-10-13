package android.sgeoliver.net.miprimeraapp_fsb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean{
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem):Boolean{
        var id = item.itemId

        if (id== R.id.menuMainItemAniadirNota)
            Toast.makeText(this, "Botón Añadir Nota", Toast.LENGTH_SHORT).show()
        else if (id== R.id.menuMainItemMandarCorreo)
            Toast.makeText(this, "Botón Mandar Correo", Toast.LENGTH_SHORT).show()
        else if (id== R.id.menuMainItemAniadirAmigo)
            Toast.makeText(this, "Botón Añadir Amigo", Toast.LENGTH_SHORT).show()
        else if (id== R.id.menuMainItemAniadirCita)
            Toast.makeText(this, "Botón Añadir Cita", Toast.LENGTH_SHORT).show()
        else
            Toast.makeText(this, "Botón Añadir Nota", Toast.LENGTH_SHORT).show()

        return super.onOptionsItemSelected(item)
    }

}