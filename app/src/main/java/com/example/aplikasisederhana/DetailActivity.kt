package com.example.aplikasisederhana

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        val android = intent.getParcelableExtra<Android>("android")
        if (android != null) {
            val textView: TextView = findViewById(R.id.tv_item_name)
            val textDescriptionView: TextView = findViewById(R.id.tv_item_description)
            val imageView: ImageView = findViewById(R.id.img_item_photo)
            val releaseDateView: TextView = findViewById(R.id.tv_item_release)
            val btnShare: Button = findViewById(R.id.btn_share)

            textView.text = android.name
            textDescriptionView.text = android.description
            imageView.setImageResource(android.photo)
            releaseDateView.text = "Release Date: " + android.release

            btnShare.setOnClickListener {
                onShareClick()
            }
        }
    }

    private fun onShareClick() {
        val intent = Intent(Intent.ACTION_SEND)
        intent.setType("text/plain")
        val android = intent.getParcelableExtra<Android>("android")
        if (android != null) {
            intent.putExtra(Intent.EXTRA_TEXT, "Cek versi android ini: ${android.name}")
        }
        startActivity(Intent.createChooser(intent, "Share"))
    }

    fun onShareClick(view: View) {}
}
