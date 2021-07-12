package com.giovanna.events.util

import android.content.Context
import androidx.appcompat.app.AlertDialog
import com.giovanna.events.R

class Utils {

    fun showAlert(context: Context?, title: String?, message: String?) {
        val builder = AlertDialog.Builder(
            context!!, R.style.AlertDialogCustom
        )
        builder.setTitle(title)
        builder.setMessage(message)
        builder.setPositiveButton(
            "OK"
        ) { dialog, which -> dialog.dismiss() }
        builder.show()
    }
}