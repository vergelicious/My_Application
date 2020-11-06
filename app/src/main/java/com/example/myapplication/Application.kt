package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock
import android.provider.Settings
import android.widget.Button
import android.widget.Toast

class Application : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_application)

        findViewById<Button>(R.id.btnClock).setOnClickListener { openClock() }
        findViewById<Button>(R.id.btnCalendar).setOnClickListener { openCalendar() }
        findViewById<Button>(R.id.btnMessage).setOnClickListener { openMessages() }
        findViewById<Button>(R.id.btnSettings).setOnClickListener { openSettings() }
        findViewById<Button>(R.id.btnAlarm).setOnClickListener { openAlarm() }
    }

    private fun openClock() {
        val intent = Intent(Intent.ACTION_QUICK_CLOCK)
        startActivity(intent)
    }

    private fun openCalendar() {
        val intent = Intent(Intent.ACTION_MAIN)
        intent.addCategory(Intent.CATEGORY_APP_CALENDAR)
        startActivity(intent)
    }

    private fun openMessages() {
        val intent = Intent(Intent.ACTION_MAIN)
        intent.addCategory(Intent.CATEGORY_APP_MESSAGING)
        startActivity(intent)
    }

    private fun openSettings() {
        val intent = Intent(Settings.ACTION_SETTINGS)
        intent.addCategory(Intent.ACTION_ALL_APPS)
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        } else {
            Toast.makeText(this, "Unfortunately settings has stopped.", Toast.LENGTH_SHORT).show()
            //The intent failed due to ACTION_ALL_APPS is not present.
        }
    }

    private fun openAlarm() {
        val intent = Intent(AlarmClock.ACTION_SET_ALARM)
        intent.addCategory(Intent.CATEGORY_APP_CALCULATOR)
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        } else {
            Toast.makeText(this, "Cannot open clock.", Toast.LENGTH_SHORT).show()
            //The intent failed due to the category is not applicable to ACTION_SET_ALARM.
        }
    }


}