package com.example.wehelpyoubook.notification

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.example.wehelpyoubook.MainActivity
import com.example.wehelpyoubook.R
import com.example.wehelpyoubook.accountcontrol.HomeSignInActivity
import com.example.wehelpyoubook.databinding.ActivityMainBinding
import com.example.wehelpyoubook.databinding.ActivityNotificationBinding
import com.example.wehelpyoubook.databinding.ActivityUpdateDataBinding
import com.example.wehelpyoubook.model.Orders
import com.example.wehelpyoubook.mybooking.db
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.ktx.toObjects
import com.google.firebase.ktx.Firebase

class NotificationActivity() : AppCompatActivity() {
    private val CHANNEL_ID = "1234"
    private val notificationId = 101
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_notification)
        //createNotificationChannel()

//        val btn_click_me = findViewById(R.id.btn_Notify) as Button
//
//        btn_click_me.setOnClickListener {
//            sendNotify()
//            Toast.makeText(this@NotificationActivity, "You clicked me.", Toast.LENGTH_SHORT).show()
//        }


        //R.id.btn_Notify.apply {
        sendNotify()
        //}

        //startActivity(Intent(this, MainActivity::class.java))
    }

    private fun sendNotify(){
        val intent = Intent(this, NotificationActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        }
        val pendingIntent: PendingIntent = PendingIntent
            .getActivity(this, 0, intent, PendingIntent.FLAG_IMMUTABLE)
        var builder = NotificationCompat.Builder(this, CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_launcher_background)
            .setContentTitle("My notification")
            .setContentText("Booking successfully")
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .setContentIntent(pendingIntent)
            .setAutoCancel(true)

        with(NotificationManagerCompat.from(this)) {
            // notificationId is a unique int for each notification that you must define
            notify(notificationId, builder.build())
        }
    }

}