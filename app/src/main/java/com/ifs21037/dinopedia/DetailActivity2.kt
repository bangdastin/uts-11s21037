package com.ifs21037.dinopedia

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.ifs21037.dinopedia.databinding.ActivityDetail2Binding

class DetailActivity2 : AppCompatActivity() {
    private lateinit var binding: ActivityDetail2Binding
    private var dino2: Dino2? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetail2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        dino2 = intent.getParcelableExtra(EXTRA_DINO)
        if (dino2 != null) {
            supportActionBar?.title = dino2!!.nama
            loadData(dino2!!)
        } else {
            finish()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_detail, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                finish()
                return true
            }
            R.id.menu_share -> {
                val shareIntent = Intent(Intent.ACTION_SEND)
                shareIntent.type = "text/plain"
                shareIntent.putExtra(Intent.EXTRA_TEXT, "${dino2!!.nama}: ${dino2!!.deskripsi}")
                startActivity(Intent.createChooser(shareIntent, "Share via"))
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }

    private fun loadData(dino2: Dino2) {
        binding.iikon.setImageResource(dino2.dinoss)
        binding.namaDino.text = dino2.nama
        binding.desc.text = dino2.deskripsi
        binding.Detailkarakterr.text = dino2.karakteristik
        binding.DetailHabitat.text = dino2.kelompok
        binding.DetailProsesss.text = dino2.habitatt
        binding.Detailperilaku.text = dino2.makanan
        binding.Detailpanjang.text = dino2.panjang
        binding.Detailtinggi.text = dino2.tinggi
        binding.Detailbobot.text = dino2.bobot
        binding.Detailkelemahan.text = dino2.kelemahan
    }

    companion object {
        const val EXTRA_DINO = "extra_dino"
    }
}
