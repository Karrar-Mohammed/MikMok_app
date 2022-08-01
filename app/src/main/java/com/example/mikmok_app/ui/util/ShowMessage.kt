package com.example.mikmok_app.ui.util

import android.content.Context
import android.widget.Toast

fun showMessage(context: Context,message: Int) {
    Toast.makeText(context, context.resources.getString(message), Toast.LENGTH_SHORT).show()
}


