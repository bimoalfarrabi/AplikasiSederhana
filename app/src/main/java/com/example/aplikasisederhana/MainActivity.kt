package com.example.aplikasisederhana

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvAndroids: RecyclerView
    private val list = ArrayList<Android>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvAndroids = findViewById(R.id.rv_androids)
        rvAndroids.setHasFixedSize(true)

        list.addAll(getListAndroids())
        showRecyclerList()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.about, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_profile -> {
                val intent = Intent(this, AboutActivity::class.java)
                startActivity(intent)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun getListAndroids(): ArrayList<Android> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val dataRelease = resources.getStringArray(R.array.data_release)
        val listAndroid = ArrayList<Android>()
        for (i in dataName.indices) {
            val android = Android(dataName[i], dataDescription[i], dataPhoto.getResourceId(i, -1), dataRelease[i])
            listAndroid.add(android)
        }
        return listAndroid
    }

    private fun showRecyclerList() {
        rvAndroids.layoutManager = LinearLayoutManager(this)
        val listAndroidAdapter = ListAndroidAdapter(list)
        rvAndroids.adapter = listAndroidAdapter

        listAndroidAdapter.onItemClick = {
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("android", it)
            startActivity(intent)
        }
    }
}