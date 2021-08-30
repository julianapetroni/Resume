package com.julianamongon.resume

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var urlLinkedin = "https://fr.linkedin.com/in/julianapetroni/fr"

        var workHistory = findViewById<Button>(R.id.workHistoryButton)
        workHistory.setOnClickListener {
            //var moveToWorkHistory = Intent(getApplicationContext(), WorkHistoryActivity:: class.java)
            var moveToWorkHistory = Intent(Intent.ACTION_VIEW)
            moveToWorkHistory.data = Uri.parse(urlLinkedin)
            startActivity(moveToWorkHistory)
        }

        var makeACall = findViewById<Button>(R.id.callButton)
        makeACall.setOnClickListener {
            println("Call me")

            var phoneUri = Uri.parse("tel:+33782550753")
            var callIntent = Intent(Intent.ACTION_DIAL, phoneUri)
            startActivity(callIntent)
        }

        var emailMe = findViewById<Button>(R.id.EmailButton)
        emailMe.setOnClickListener {
            println("Email me")

            var to = "julianamongon@gmail.com"
            var subject= "Contact: resume"
            var body="Hello Juliana, I really enjoyed your resume. "
            var mailTo = "mailto:" + to +
            "?&subject=" + Uri.encode(subject) +
                    "&body=" + Uri.encode(body)

            var emailIntent = Intent(Intent.ACTION_VIEW)
            emailIntent.setData(Uri.parse(mailTo))
            startActivity(emailIntent)

        }
    }
}