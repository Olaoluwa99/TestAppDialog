package com.easit.testactivity

import android.app.Dialog
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.WindowManager
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatDelegate
import com.google.android.material.dialog.MaterialAlertDialogBuilder

//
class MyButtonReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        val action = intent.action
        if (action == "widget.buttonClick") {
            showDialog(context)
        }
    }

    private fun showDialog2(context: Context) {

        val builder = AlertDialog.Builder(context)
        val inflater = LayoutInflater.from(context)

        val dialogLayout = inflater.inflate(R.layout.edit_text_dialog, null)
        val editText = dialogLayout.findViewById<EditText>(R.id.testNew)
        AppCompatDelegate.create(builder.create(), null).apply {
            // Create and show your dialog here
            this.setContentView(dialogLayout)
        }

        builder.setView(dialogLayout)
            .setPositiveButton("OK") { dialog, which ->
                val userInput = editText.text.toString()
                // Do something with the user input
                dialog.dismiss()
            }
            .setNegativeButton("Cancel") { dialog, which ->
                dialog.cancel()
            }

        val dialog = builder.create()
        dialog.show()

        // Show keyboard when dialog is shown
        dialog.window?.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE)
    }

    private fun showDialog(context: Context) {

        val builder = MaterialAlertDialogBuilder(context)
        val inflater = LayoutInflater.from(context)

        val dialogLayout = inflater.inflate(R.layout.edit_text_dialog, null)
        val editText = dialogLayout.findViewById<EditText>(R.id.testNew)
        AppCompatDelegate.create(builder.create(), null).apply {
            // Create and show your dialog here
            this.setContentView(dialogLayout)
        }

        builder.setView(dialogLayout)
            .setPositiveButton("OK") { dialog, which ->
                val userInput = editText.text.toString()
                // Do something with the user input
                dialog.dismiss()
            }
            .setNegativeButton("Cancel") { dialog, which ->
                dialog.cancel()
            }

        val dialog = builder.create()
        dialog.show()

        // Show keyboard when dialog is shown
        dialog.window?.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE)
    }

    private fun showDialogT(context: Context) {
        val dialog = Dialog(context)
        val delegate = AppCompatDelegate.create(dialog, null)
        delegate.apply {
            val inflater = LayoutInflater.from(context)
            val dialogLayout = inflater.inflate(R.layout.edit_text_dialog, null)
            val editText = dialogLayout.findViewById<EditText>(R.id.testNew)

            val builder = AlertDialog.Builder(context)
            builder.setView(dialogLayout)
                .setPositiveButton("OK") { dialog, which ->
                    val userInput = editText.text.toString()
                    // Do something with the user input
                    dialog.dismiss()
                }
                .setNegativeButton("Cancel") { dialog, which ->
                    dialog.cancel()
                }

            val dialog = builder.create()
            dialog.show()

            // Show keyboard when dialog is shown
            dialog.window?.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE)
        }
    }
}