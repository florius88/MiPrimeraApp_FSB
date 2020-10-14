package android.sgeoliver.net.miprimeraapp_fsb

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    /**
     * Funcion para construir la Actividad
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        // Ciclo de vida. Nada mas crear salvamos el estado
        super.onCreate(savedInstanceState)
        // Le asignamos la actividad (su layout)
        setContentView(R.layout.activity_main)
    }

    /**
     * Creación del menu
     */
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    /**
     * Opciones del menu
     */
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menuMainItemAniadirNota -> {
                //mensajeToast("Botón Añadir Nota")
                abrirAniadirNota()
                true
            }

            R.id.menuMainItemMandarCorreo -> {
                //mensajeToast("Botón Mandar Correo")
                abrirSendMail()
                true
            }

            R.id.menuMainItemAniadirAmigo -> {
                //mensajeToast("Botón Añadir Amigo")
                abrirAddAmigo()
                true
            }

            R.id.menuMainItemAniadirCita -> {
                //mensajeToast("Botón Añadir Cita")
                abrirAddCita()
                true
            }

            R.id.menuMainItemAcercaDe -> {
                //mensajeToast("Botón Acerca De...")
                abrirAcercaDe()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }

    }

//    /**
//     * Funcion que muestra un mensaje en pantalla. Toast
//     */
//    private fun mensajeToast(mensaje: String) {
//        Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show()
//    }

    private fun abrirAniadirNota(){
        val intent = Intent(this,AniadirNotaActivity::class.java)
        startActivity(intent)
    }

    private fun abrirAcercaDe(){
        val intent = Intent(this,AcercaDeActivity::class.java)
        startActivity(intent)
    }

    private fun abrirSendMail(){
        val intent = Intent(this,MandarCorreoActivity::class.java)
        startActivity(intent)
    }

    private fun abrirAddAmigo(){
        val intent = Intent(this,AniadirAmigoActivity::class.java)
        startActivity(intent)
    }

    private fun abrirAddCita(){
        val intent = Intent(this,AniadirCitaActivity::class.java)
        startActivity(intent)
    }

}