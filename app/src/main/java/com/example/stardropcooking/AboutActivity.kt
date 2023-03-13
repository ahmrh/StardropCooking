package com.example.stardropcooking

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.bumptech.glide.Glide
import com.example.stardropcooking.databinding.ActivityAboutBinding

class AboutActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAboutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAboutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Glide.with(binding.imgPhoto.context)
            .load(getString(R.string.photo_saloon))
            .into(binding.imgPhoto)

        binding.btnCreator.setOnClickListener{
            var creatorIntent = Intent(this, CreatorActivity::class.java )
            startActivity(creatorIntent)
        }
    }
}