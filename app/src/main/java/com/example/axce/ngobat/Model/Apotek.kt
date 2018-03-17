package com.example.axce.ngobat.Model

import com.google.firebase.firestore.GeoPoint

/**
 * Created by AXCE on 17/03/2018.
 */
class Apotek(var nama : String,
             var location : GeoPoint,
             var tlp : String,
             var alamat : String){

    object Result{
        lateinit var nama:String
        lateinit var location: GeoPoint
        lateinit var tlp: String
        lateinit var alamat: String
    }
}