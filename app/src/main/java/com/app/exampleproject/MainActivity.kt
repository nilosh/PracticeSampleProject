package com.app.exampleproject

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.provider.ContactsContract
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var btnSignUpFacebook: Button
    private lateinit var btnSignUpPhoneOrEmail: Button
    private lateinit var btnLogin: TextView
    private lateinit var btnTwitter: ImageButton
    private lateinit var btnLinkedin: ImageButton
    private lateinit var btnGooglePlus: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Hide the status bar.
//        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
//        actionBar?.hide()
        setContentView(R.layout.activity_main)

        btnSignUpFacebook = findViewById<Button>(R.id.buttonFacebook)
        btnSignUpPhoneOrEmail = findViewById<Button>(R.id.buttonPhoneEmail)
        btnLogin = findViewById<TextView>(R.id.buttonLogin)
        btnTwitter = findViewById<ImageButton>(R.id.imageButtonTwitter)
        btnGooglePlus = findViewById<ImageButton>(R.id.imageButtonGooglePlus)
        btnLinkedin = findViewById<ImageButton>(R.id.imageButtonLinkedin)

        // Set on click listeners to buttons.
        setButtonActions()
    }

    // Sets on click listeners for buttons.
    private fun setButtonActions() {
        btnSignUpFacebook.setOnClickListener(View.OnClickListener {
            Toast.makeText(this, "Facebook Sign Up Clicked", Toast.LENGTH_SHORT).show()
        })

        btnSignUpPhoneOrEmail.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, Chats::class.java)
            Toast.makeText(this, "Email or Phone Sign Up Clicked", Toast.LENGTH_SHORT).show()
            startActivity(intent)
        })

        btnLogin.setOnClickListener(View.OnClickListener {
            Toast.makeText(this, "Login Clicked", Toast.LENGTH_SHORT).show()
        })

        btnTwitter.setOnClickListener(View.OnClickListener {
            Toast.makeText(this, "Twitter icon Clicked", Toast.LENGTH_SHORT).show()
        })

        btnGooglePlus.setOnClickListener(View.OnClickListener {
            Toast.makeText(this, "Google Plus icon Clicked", Toast.LENGTH_SHORT).show()
        })

        btnLinkedin.setOnClickListener(View.OnClickListener {
            Toast.makeText(this, "LinkedIn icon Clicked", Toast.LENGTH_SHORT).show()
        })

    }
}