package com.example.stardropcooking

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.stardropcooking.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val list = ArrayList<Cooking>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvCooking.setHasFixedSize(true)

        binding.gridView.setOnClickListener{
            binding.rvCooking.layoutManager = GridLayoutManager(this, 2)
        }
        binding.listView.setOnClickListener{
            binding.rvCooking.layoutManager = LinearLayoutManager(this)
        }

        list.addAll(getListCooking())
        showRecyclerList()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.action_about -> {
                var aboutIntent = Intent(this@MainActivity, AboutActivity::class.java)
                startActivity(aboutIntent)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun getListCooking(): ArrayList<Cooking> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataPhoto = resources.getStringArray(R.array.data_photo)
        val dataShortDesc = resources.getStringArray(R.array.data_shortDesc)
        val dataGold = resources.getStringArray(R.array.data_gold)
        val dataEnergy = resources.getStringArray(R.array.data_energy)
        val dataHealth = resources.getStringArray(R.array.data_health)
        val dataDescr = resources.getStringArray(R.array.data_descr)
        val dataDescr2 = resources.getStringArray(R.array.data_descr2)

        val listCooking = ArrayList<Cooking>()
        for (i in dataName.indices) {
            val cooking = Cooking(dataName[i], dataPhoto[i], dataShortDesc[i], dataGold[i], dataEnergy[i], dataHealth[i], dataDescr[i], dataDescr2[i])
            listCooking.add(cooking)
        }

        return listCooking
    }

    private fun showRecyclerList(){
        binding.rvCooking.layoutManager = GridLayoutManager(this, 2)
        val listCookingAdapter = ListCookingAdapter(list)
        binding.rvCooking.adapter = listCookingAdapter

        listCookingAdapter.setOnItemClickCallback(object: ListCookingAdapter.OnItemClickCallback{
            override fun onItemClicked(data: Cooking, id: Int) {
                showSelectedCooking(data, id)
            }
        })
    }

    private fun showSelectedCooking(cooking: Cooking, id: Int){
        val detailIntent = Intent(this@MainActivity, DetailActivity::class.java)
        detailIntent.putExtra(DetailActivity.EXTRA_COOKING, cooking)
        startActivity(detailIntent)
        
        Toast.makeText(this, "${cooking.name}", Toast.LENGTH_SHORT).show()
    }
}