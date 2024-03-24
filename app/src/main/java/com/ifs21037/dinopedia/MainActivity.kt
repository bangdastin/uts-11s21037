package com.ifs21037.dinopedia

import android.annotation.SuppressLint
import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.ifs21037.dinopedia.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val dataDinos = ArrayList<Dino>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.rvFruits.setHasFixedSize(false)
        dataDinos.addAll(getListFruits())
        showRecyclerList()
    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menu_about -> {
                val intent = Intent(this, ProfileActivity::class.java)
                startActivity(intent)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }

    }

    @SuppressLint("Recycle")
    private fun getListFruits(): ArrayList<Dino> {
        val dataName =
            resources.getStringArray(R.array.dino_name)
        val dataIcon =
            resources.obtainTypedArray(R.array.dino_icon)
        val dataDescription =
            resources.getStringArray(R.array.dino_description)
        val dataCharacteristic =
            resources.getStringArray(R.array.dino_characteristic)
        val dataHabitat =
            resources.getStringArray(R.array.dino_habitat)
        val dataProcess =
            resources.getStringArray(R.array.dino_proces)
        val dataperilaku =
            resources.getStringArray(R.array.dino_perilaku)
        val dataklasifikasi =
            resources.getStringArray(R.array.dino_klasifikasi)
        val listDino = ArrayList<Dino>()
        for (i in dataName.indices) {
            val dino = Dino(dataName[i],
                dataIcon.getResourceId(i, -1), dataDescription[i],
                dataCharacteristic[i], dataHabitat[i], dataProcess[i], dataperilaku[i], dataklasifikasi[i])
            listDino.add(dino)
        }
        return listDino
    }
    private fun showRecyclerList() {
        if (resources.configuration.orientation ==
            Configuration.ORIENTATION_LANDSCAPE) {
            binding.rvFruits.layoutManager =
                GridLayoutManager(this, 2)
        } else {
            binding.rvFruits.layoutManager =
                LinearLayoutManager(this)
        }
        val listDinoAdapter = ListDinoAdapter(dataDinos)
        binding.rvFruits.adapter = listDinoAdapter
        listDinoAdapter.setOnItemClickCallback(object :
            ListDinoAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Dino) {
                showSelectedFruit(data)

            }
        })
    }
    private fun showSelectedFruit(dino: Dino) {
        val intentWithData = Intent(this@MainActivity,
            DetailActivity::class.java)
        intentWithData.putExtra(DetailActivity.EXTRA_DINO, dino)
        startActivity(intentWithData)
    }
}