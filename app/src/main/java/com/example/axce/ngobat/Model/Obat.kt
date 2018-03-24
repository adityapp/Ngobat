package com.example.axce.ngobat.Model

import android.graphics.drawable.Drawable
import java.io.Serializable


/**
 * Created by AXCE on 17/03/2018.
 */
class Obat(
        var namaObat: String,
        var namaPerusahaan: String,
        var harga : String,
        var komposisi: ArrayList<String>,
        var efekSamping: ArrayList<String>,
        var menangani: ArrayList<String>,
        var image : Int): Serializable
        {
}