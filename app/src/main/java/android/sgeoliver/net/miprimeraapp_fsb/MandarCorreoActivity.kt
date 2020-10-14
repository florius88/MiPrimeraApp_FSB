package android.sgeoliver.net.miprimeraapp_fsb

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_mandar_correo.*

class MandarCorreoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mandar_correo)

        btnMandarCorreoMandar.setOnClickListener { sendMail() }
    }

    private fun sendMail() {
        val sendIntent = Intent(Intent.ACTION_SENDTO)
        sendIntent.data = Uri.parse("mailto:" )
        sendIntent.putExtra(Intent.EXTRA_EMAIL, arrayOf(txtEmailMandarCorreoDestinatario.text.toString()))
        sendIntent.putExtra(Intent.EXTRA_SUBJECT, txtMandarCorreoAsunto.text.toString())
        sendIntent.putExtra(Intent.EXTRA_TEXT, txtMandarCorreoTexto.text.toString())

        startActivity(sendIntent)
    }

}