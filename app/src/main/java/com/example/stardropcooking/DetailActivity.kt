package com.example.stardropcooking

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.bumptech.glide.Glide
import com.example.stardropcooking.databinding.ActivityDetailBinding
import java.util.zip.Inflater

class DetailActivity : AppCompatActivity() {
    companion object{
        const val EXTRA_COOKING = ""
    }

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val cooking = if(Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra(EXTRA_COOKING, Cooking::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra(EXTRA_COOKING)
        }

        Glide.with(binding.imgGold.context)
            .load(getString(R.string.photo_gold))
            .into(binding.imgGold)

        Glide.with(binding.imgEnergy.context)
            .load(getString(R.string.photo_energy))
            .into(binding.imgEnergy)

        Glide.with(binding.imgHealth.context)
            .load(getString(R.string.photo_health))
            .into(binding.imgHealth)

        if(cooking != null) {
            binding.tvName.text = cooking.name
            Glide.with(binding.imgPhoto.context)
                .load(cooking.photo)
                .into(binding.imgPhoto)

            binding.tvGold.text = cooking.gold
            binding.tvEnergy.text = cooking.energy
            binding.tvHealth.text = cooking.health

            binding.tvDescr.text = cooking.descr
            binding.tvDescr2.text = cooking.descr2
        }

    }
}