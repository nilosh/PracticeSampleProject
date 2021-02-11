package com.app.exampleproject.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.app.exampleproject.fragments.ChatsFragment
import com.app.exampleproject.R

class Chats : AppCompatActivity() {    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        actionBar?.title
        setContentView(R.layout.activity_chats)
        
        // Open fragment by default.
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragmentFrame, ChatsFragment())
            .commit()
    }
}