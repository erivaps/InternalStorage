package com.kotlin.internal.internalstorage

import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val PREF = "myPref"
    var myPref: SharedPreferences?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        txtResultado.text = ""

        btnAlmacenar.setOnClickListener {

            myPref = getSharedPreferences(PREF, 0)

            var editor : SharedPreferences.Editor =
                    (myPref as SharedPreferences
                            ).edit()

            if (!TextUtils.isEmpty(txtNombre.text.toString())){
                editor.putString("misNombres",txtNombre.text.toString())
                editor.commit()
            } else{
                Toast.makeText(this,"Ingrese Nombres",
                        Toast.LENGTH_SHORT).show()
            }

            var retorno : SharedPreferences = getSharedPreferences(PREF,0)

            if (retorno.contains("misNombres")){
                txtResultado.text = retorno.getString("misNombres","no lo encontre")

            }

        }
    }
}
