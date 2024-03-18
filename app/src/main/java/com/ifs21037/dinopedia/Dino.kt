package com.ifs21037.dinopedia

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Dino(
    var name: String,
    var icon: Int,
    var description: String,
    var characteristic: String,
    var habitat: String,
    var process: String,

) : Parcelable
