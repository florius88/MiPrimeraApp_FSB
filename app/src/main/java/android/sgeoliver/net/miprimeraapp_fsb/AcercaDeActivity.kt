package android.sgeoliver.net.miprimeraapp_fsb

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_acerca_de.*


class AcercaDeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_acerca_de)

        imgBtnAcercaDeTwitter.setOnClickListener { openURL("https://twitter.com/FlorSanBu") }
        imgBtnAcercaDeGithub.setOnClickListener { openURL("https://github.com/florius88") }
    }

    private fun openURL(url:String){
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(intent)
    }

}