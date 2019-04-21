package com.konkidevs.deeplinksblog.alarm

import android.app.Notification
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.NotificationCompat
import android.support.v4.app.NotificationManagerCompat
import android.util.Log
import androidx.navigation.NavDeepLinkBuilder
import com.konkidevs.deeplinksblog.MainActivity
import com.konkidevs.deeplinksblog.R
import java.util.*

class AlarmBroadcastReceiver: BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        val calendar = Calendar.getInstance()
        calendar.timeInMillis = System.currentTimeMillis()

        Log.i("startedAt", "${calendar.time}")

        val pendingIntent = NavDeepLinkBuilder(context!!)
        pendingIntent.setComponentName(MainActivity::class.java)

        pendingIntent.setGraph(R.navigation.app_navigation)
        pendingIntent.setDestination(R.id.detailFragment)
        val args = Bundle()
        args.putLong("id", 10L)
        args.putString("name", "hello from notification")
        pendingIntent.setArguments(args)

        showNotification(context, pendingIntent)

        Log.i("startedAt", "send: ${calendar.time}")

    }

    private fun showNotification(context: Context, pendingIntent: NavDeepLinkBuilder){
        val notification: Notification = NotificationCompat
            .Builder(context, context.getString(R.string.default_notification_channel_id))
            .setSmallIcon(R.mipmap.ic_launcher)
            .setContentTitle("Mensaje de prueba")
            .setContentText("Cuerpo del mensaje")
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setContentIntent(pendingIntent.createPendingIntent())
            .setAutoCancel(true)
            .build()

        val notificationManager: NotificationManagerCompat = NotificationManagerCompat.from(context)

        notificationManager.notify(1012, notification)
    }
}