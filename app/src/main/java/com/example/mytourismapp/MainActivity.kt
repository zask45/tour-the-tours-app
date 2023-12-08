package com.example.mytourismapp

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvPlaces: RecyclerView
    private val listPlaces = ArrayList<AttractionPlace>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvPlaces = findViewById(R.id.rv_places)
        rvPlaces.setHasFixedSize(true)

        listPlaces.addAll(getListPlaces())
        showRecyclerList()

       val toolbar = findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)
    }

    private fun showRecyclerList() {
        rvPlaces.layoutManager = GridLayoutManager(this, 2)
        val listPlacesAdapter = ListAttractionAdapter(listPlaces)
        rvPlaces.adapter = listPlacesAdapter
    }

    private fun getListPlaces(): ArrayList<AttractionPlace> {
        val name = resources.getStringArray(R.array.data_name)
        val desc = resources.getStringArray(R.array.data_description)
        val photo = resources.obtainTypedArray(R.array.data_photo)
        val places = ArrayList<AttractionPlace>()
        for (i in name.indices) {
            val place = AttractionPlace(name[i], desc[i], photo.getResourceId(i, -1))
            places.add(place)
        }

        return places
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val intent = Intent(this@MainActivity, AboutActivity::class.java)
        startActivity(intent)
        return super.onOptionsItemSelected(item)
    }
}