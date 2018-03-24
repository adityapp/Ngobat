package com.example.axce.ngobat.Object

import android.app.Activity
import android.R.drawable.btn_dialog
import android.app.Dialog
import android.view.Window
import android.widget.TextView
import android.view.Window.FEATURE_NO_TITLE
import android.widget.Button
import com.example.axce.ngobat.R
import android.content.Context.MODE_PRIVATE
import android.R.id.edit
import android.content.SharedPreferences


/**
 * Created by AXCE on 24/03/2018.
 */
class DialogBox{
    fun showDialog(activity : Activity){
        val dialog = Dialog(activity)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.dialog_box)

        val dialogButton = dialog.findViewById(R.id.btn_ngerti) as Button
        dialogButton.setOnClickListener({
            dialog.dismiss()
        })

        dialog.show()
    }
}