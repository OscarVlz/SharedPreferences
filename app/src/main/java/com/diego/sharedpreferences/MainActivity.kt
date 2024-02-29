package com.diego.sharedpreferences

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.diego.sharedpreferences.PreferenceHelper.clearValues
import com.diego.sharedpreferences.PreferenceHelper.defaultPreference
import com.diego.sharedpreferences.PreferenceHelper.password
import com.diego.sharedpreferences.PreferenceHelper.userId


class MainActivity : AppCompatActivity(), View.OnClickListener {

    val CUSTOM_PREF_NAME = "User_data"
    lateinit var btnSave: Button
    lateinit var btnClear: Button
    lateinit var btnShow: Button
    lateinit var btnShowDefault: Button
    lateinit var inUserId: TextView
    lateinit var inPassword: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
         btnSave = findViewById(R.id.btnSave)
        btnClear = findViewById(R.id.btnClear)
        btnShow = findViewById(R.id.btnShow)
        btnShowDefault = findViewById(R.id.btnShowDefault)
         inUserId = findViewById(R.id.inUserId)
         inPassword= findViewById(R.id.inPassword)

        btnSave.setOnClickListener(this)
        btnClear.setOnClickListener(this)
        btnShow.setOnClickListener(this)
        btnShowDefault.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        val prefs = PreferenceHelper.customPreference(this, CUSTOM_PREF_NAME)
        when (v?.id) {
            R.id.btnSave -> {
                if(inPassword.text.toString().isEmpty()||inUserId.text.toString().isEmpty()){

                }else{
                    prefs.password = inPassword.text.toString()
                    prefs.userId = inUserId.text.toString().toInt()
                }
            }
            R.id.btnClear -> {
                prefs.clearValues()
            }
            R.id.btnShow -> {
                if (prefs.password.isNullOrEmpty()){
                    inUserId.setText("")
                    inPassword.setText(prefs.password)
                }else{
                    inUserId.setText(prefs.userId.toString())
                    inPassword.setText(prefs.password)
                }


            }
            R.id.btnShowDefault -> {

                val defaultPrefs = defaultPreference(this)
                if(defaultPrefs.userId==0){
                    inUserId.setText("")
                }else{
                    inUserId.setText(defaultPrefs.userId.toString())
                }

                inPassword.setText(defaultPrefs.password)
            }
        }
    }
}


