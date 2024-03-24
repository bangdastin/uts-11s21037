package com.ifs21037.dinopedia

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.ifs21037.dinopedia.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding
    private var dino: Dino? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        dino = intent.getParcelableExtra(EXTRA_DINO)
        if (dino != null) {
            supportActionBar?.title = dino!!.name
            loadData(dino!!)
        } else {
            finish()
        }

        binding.btn.setOnClickListener {
            val intent = Intent(this@DetailActivity, MainActivity2::class.java)
            startActivity(intent)
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
                shareIntent.putExtra(Intent.EXTRA_TEXT, "${dino!!.name}: ${dino!!.description}")
                startActivity(Intent.createChooser(shareIntent, "Share via"))
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }

    private fun loadData(dino: Dino) {
        binding.ivikon.setImageResource(dino.icon)
        binding.tvDetailnamasaya.text = dino.name
        binding.tvdetaildeks.text = dino.description
        binding.tvDetailkarakterr.text = dino.characteristic
        binding.tvDetailHabitat.text = dino.habitat
        binding.tvDetailProsesss.text = dino.process
        binding.tvDetailperilaku.text = dino.perilaku
        binding.tvDetailklasifikasi.text = dino.klasifikasi


    }

    companion object {
        const val EXTRA_DINO = "extra_dino"
    }



}
