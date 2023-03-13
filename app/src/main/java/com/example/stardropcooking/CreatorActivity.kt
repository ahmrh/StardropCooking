package com.example.stardropcooking

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.stardropcooking.databinding.ActivityCreatorBinding

class CreatorActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCreatorBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreatorBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}