package com.app.exampleproject.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.app.exampleproject.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Set on click listeners to buttons.
        setButtonActions()
    }

    // Sets on click listeners for buttons.
    private fun setButtonActions() {
        buttonFacebook.setOnClickListener(View.OnClickListener {
            Toast.makeText(this, "Facebook Sign Up Clicked", Toast.LENGTH_SHORT).show()
        })

        buttonPhoneEmail.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, Chats::class.java)
            Toast.makeText(this, "Email or Phone Sign Up Clicked", Toast.LENGTH_SHORT).show()
            startActivity(intent)
        })

        buttonLogin.setOnClickListener(View.OnClickListener {
            Toast.makeText(this, "Login Clicked", Toast.LENGTH_SHORT).show()
        })

        imageButtonTwitter.setOnClickListener(View.OnClickListener {
            Toast.makeText(this, "Twitter icon Clicked", Toast.LENGTH_SHORT).show()
        })

        imageButtonGooglePlus.setOnClickListener(View.OnClickListener {
            Toast.makeText(this, "Google Plus icon Clicked", Toast.LENGTH_SHORT).show()
        })

        imageButtonLinkedin.setOnClickListener(View.OnClickListener {
            Toast.makeText(this, "LinkedIn icon Clicked", Toast.LENGTH_SHORT).show()
        })
    }
}