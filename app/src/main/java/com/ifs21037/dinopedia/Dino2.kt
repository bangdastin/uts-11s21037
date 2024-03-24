package com.ifs21037.dinopedia

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Dino2(
    var nama: String,
    var dinoss: Int,
   var deskripsi: String,
    var karakteristik: String,
    var kelompok: String,
    var habitatt: String,
    var makanan: String,
    var panjang: String,
    var tinggi: String,
    var bobot: String,
    var kelemahan: String,
) : Parcelable
