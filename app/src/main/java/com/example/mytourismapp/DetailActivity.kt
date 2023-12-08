package com.example.mytourismapp

import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.mytourismapp.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_PLACE = "extra_place"
    }

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val data = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra<AttractionPlace>(EXTRA_PLACE, AttractionPlace::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra<AttractionPlace>(EXTRA_PLACE)
        }

        binding.detailTitle.text = data?.name.toString()
        binding.detailText.text = data?.description
        binding.imgPlace.setImageResource(data!!.photo)
    }
}