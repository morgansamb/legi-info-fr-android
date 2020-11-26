package com.example.legi_info.extension

import android.app.Activity
import android.view.View
import android.view.inputmethod.InputMethodManager
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.threeten.bp.LocalDate
import org.threeten.bp.Period
import java.time.temporal.ChronoUnit

fun View.hideKeyboard() {
    val imm: InputMethodManager =
        context.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.hideSoftInputFromWindow(this@hideKeyboard.windowToken, 0)
}

fun View.showKeyboard() {
    GlobalScope.launch(Dispatchers.Main) {
        runCatching {
            delay(100)
            val imm: InputMethodManager =
                context.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
            this@showKeyboard.requestFocus()
            imm.showSoftInput(this@showKeyboard, 0)
        }
    }
}

fun LocalDate.yearDiff(): Int {
    val dateNow = LocalDate.now()
    return Period.between(this, dateNow).years
}

fun View.visible() {
    this.visibility = View.VISIBLE
}

fun View.gone() {
    this.visibility = View.GONE
}