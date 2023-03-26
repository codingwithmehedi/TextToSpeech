package developers.world.texttospeech

import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.util.*


class MainActivity : AppCompatActivity() {
    var textToSpeech: TextToSpeech? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val button = findViewById<Button>(R.id.btnText)
        val text= findViewById<TextView>(R.id.inputText)

        //init bengali text to speak
        textToSpeech = TextToSpeech(this) { status ->
            if (status == TextToSpeech.SUCCESS) {
                val result = textToSpeech?.setLanguage(Locale("bn_BD"))
                if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                    Toast.makeText(this, "Language Not Support!", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Failed!", Toast.LENGTH_SHORT).show()
            }
        }


        button.setOnClickListener {
            textToSpeech!!.speak(text.text.toString(), TextToSpeech.QUEUE_FLUSH, null)

        }

    }
}