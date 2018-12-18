package personal.gj.myapplication.utils

import android.widget.Toast
import personal.gj.myapplication.NanApp

/**
 *Created by GJ
 *on 2018/12/17 -上午 10:07
 */

fun showShortToast(msg: String) {
    Toast.makeText(NanApp.application, msg, Toast.LENGTH_SHORT)
        .show()
}

fun showLongToast(msg: String) {
    Toast.makeText(NanApp.application, msg, Toast.LENGTH_LONG)
        .show()
}

var singleToast: Toast? = null
fun showSingleToast(msg: String) {
    singleToast = if (singleToast == null) {
        Toast.makeText(NanApp.application, msg, Toast.LENGTH_LONG)
    } else {
        singleToast?.setText(msg)
        singleToast?.duration = Toast.LENGTH_LONG
        singleToast
    }
    singleToast?.show()
}