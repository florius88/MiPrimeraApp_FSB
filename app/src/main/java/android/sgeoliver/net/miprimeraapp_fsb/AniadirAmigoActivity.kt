package android.sgeoliver.net.miprimeraapp_fsb

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import kotlinx.android.synthetic.main.activity_acerca_de.*
import kotlinx.android.synthetic.main.activity_aniadir_amigo.*

class AniadirAmigoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_aniadir_amigo)

        btnAniaditAmigoAniadir.setOnClickListener { addContacto() }
    }

    private fun addContacto() {

        val intent = Intent(Intent.ACTION_INSERT, ContactsContract.Contacts.CONTENT_URI).apply {
            type = ContactsContract.RawContacts.CONTENT_TYPE
            putExtra(
                ContactsContract.Intents.Insert.NAME,
                editTxtAniadirAmigoNombre.text.toString()
            )
            putExtra(
                ContactsContract.Intents.Insert.PHONE,
                editTxtAniadirAmigoTelefono.text
            )
            putExtra(
                ContactsContract.Intents.Insert.PHONE_TYPE,
                ContactsContract.CommonDataKinds.Phone.TYPE_WORK
            )
        }
        startActivity(intent)
    }

}