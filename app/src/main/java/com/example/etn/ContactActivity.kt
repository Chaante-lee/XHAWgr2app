package com.example.etn

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class ContactActivity : AppCompatActivity() {

    private var popupWindow: PopupWindow? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact)

        findViewById<ImageView>(R.id.hamburger_menu).setOnClickListener { showDropdown(it) }

        findViewById<Button>(R.id.btnSendMessage).setOnClickListener {
            Toast.makeText(this, "Message Sent! We will contact you soon.", Toast.LENGTH_LONG).show()
            finish()
        }
    }

    private fun showDropdown(anchor: View) {

    }
}