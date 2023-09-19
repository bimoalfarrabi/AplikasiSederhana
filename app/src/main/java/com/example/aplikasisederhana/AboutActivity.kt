package com.example.aplikasisederhana

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import de.hdodenhof.circleimageview.CircleImageView

class AboutActivity : AppCompatActivity() {
    private lateinit var imgPhoto: CircleImageView
    private lateinit var tvName: TextView
    private lateinit var tvEmail: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        imgPhoto = findViewById(R.id.about_photo)
        tvName = findViewById(R.id.about_name)
        tvEmail = findViewById(R.id.about_email)

    }
}