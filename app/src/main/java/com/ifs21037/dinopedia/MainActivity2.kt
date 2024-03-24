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
import com.ifs21037.dinopedia.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    private lateinit var binding: ActivityMain2Binding
    private val dataDinosDino2 = ArrayList<Dino2>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.mainact.setHasFixedSize(false)
        dataDinosDino2.addAll(getListDinos())
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
    private fun getListDinos(): ArrayList<Dino2> {
        val dataNama = resources.getStringArray(R.array.dino_nama)
        val dataDinoss = resources.obtainTypedArray(R.array.dino_dinoss)
        val datadeskripsi = resources.getStringArray(R.array.dino_description2)
        val dataKarakteristik = resources.getStringArray(R.array.dino_karakteristik)
        val dataKelompok = resources.getStringArray(R.array.dino_kelompok)
        val datahabitatt = resources.getStringArray(R.array.dino_habitatt)
        val datamakanan = resources.getStringArray(R.array.dino_makanan)
        val datapanjang = resources.getStringArray(R.array.dino_panjang)
        val datatinggi = resources.getStringArray(R.array.dino_tinggi)
        val databobot = resources.getStringArray(R.array.dino_bobot)
        val datakelemahan = resources.getStringArray(R.array.dino_kelemahan)

        val listDino2 = ArrayList<Dino2>()
        for (i in dataNama.indices) {
            val dino2 = Dino2(dataNama[i], dataDinoss.getResourceId(i, -1), datadeskripsi[i], dataKarakteristik[i], dataKelompok[i], datahabitatt[i], datamakanan[i], datapanjang[i],datatinggi[i], databobot[i], datakelemahan[i])
            listDino2.add(dino2)
        }
        return listDino2
    }

    private fun showRecyclerList() {
        if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            binding.mainact.layoutManager = GridLayoutManager(this, 2)
        } else {
            binding.mainact.layoutManager = LinearLayoutManager(this)
        }
        val listDinoAdapter2 = ListDinoAdapter2(dataDinosDino2)
        binding.mainact.adapter = listDinoAdapter2
        listDinoAdapter2.setOnItemClickCallback(object : ListDinoAdapter2.OnItemClickCallback {
            override fun onItemClicked(data: Dino2) {
                showSelectedDino(data)
            }
        })
    }

    private fun showSelectedDino(dino2: Dino2) {
        val intentWithData = Intent(this@MainActivity2, DetailActivity2::class.java)
        intentWithData.putExtra(DetailActivity2.EXTRA_DINO, dino2)
        startActivity(intentWithData)
    }
}
