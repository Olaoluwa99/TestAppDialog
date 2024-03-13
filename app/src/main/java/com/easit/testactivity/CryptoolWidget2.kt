package com.easit.testactivity

import android.app.PendingIntent
import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.WindowManager
import android.widget.EditText
import android.widget.RemoteViews
import androidx.appcompat.app.AlertDialog

/**
 * Implementation of App Widget functionality.
 */
class CryptoolWidget2 : AppWidgetProvider() {
    override fun onUpdate(
        context: Context,
        appWidgetManager: AppWidgetManager,
        appWidgetIds: IntArray
    ) {
        // There may be multiple widgets active, so update all of them
        for (appWidgetId in appWidgetIds) {

//            val remoteViews = RemoteViews(context.packageName, R.layout.cryptool_widget2)
//            val clickIntent = Intent(context, MyButtonReceiver::class.java)
//            clickIntent.action = "com.example.widget.buttonClick"
//            val pendingIntent = PendingIntent.getBroadcast(context, 0, clickIntent, PendingIntent.FLAG_UPDATE_CURRENT)
//            remoteViews.setOnClickPendingIntent(R.id.test, pendingIntent)
//            appWidgetManager.updateAppWidget(appWidgetId, remoteViews)


            updateAppWidget(context, appWidgetManager, appWidgetId)
        }
    }

    override fun onEnabled(context: Context) {
        // Enter relevant functionality for when the first widget is created
        val builder = AlertDialog.Builder(context)
        val inflater = LayoutInflater.from(context)
        val dialogLayout = inflater.inflate(R.layout.edit_text_dialog, null)
        builder.setView(dialogLayout)
        val dialog = builder.create()
        dialog.show()
        //dialog.window?.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE)
    }

    override fun onDisabled(context: Context) {
        // Enter relevant functionality for when the last widget is disabled
    }
}

internal fun updateAppWidget(
    context: Context,
    appWidgetManager: AppWidgetManager,
    appWidgetId: Int
) {
    val widgetText = context.getString(R.string.appwidget_text)
    // Construct the RemoteViews object
    val views = RemoteViews(context.packageName, R.layout.cryptool_widget2)
    //views.setTextViewText(R.id.appwidget_text, widgetText)

    val clickIntent = Intent(context, MyButtonReceiver::class.java)
    clickIntent.action = "widget.buttonClick"
    val pendingIntent = PendingIntent.getBroadcast(context, 0, clickIntent, PendingIntent.FLAG_UPDATE_CURRENT)
    views.setOnClickPendingIntent(R.id.test2, pendingIntent)

    // Instruct the widget manager to update the widget
    appWidgetManager.updateAppWidget(appWidgetId, views)
}
