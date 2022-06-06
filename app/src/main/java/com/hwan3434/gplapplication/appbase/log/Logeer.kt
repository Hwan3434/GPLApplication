package com.hwan3434.gplapplication.appbase.log

import android.util.Log
import com.hwan3434.gplapplication.BuildConfig

const val TAG = "😍"

fun Any.logd(log:String) {

    if(BuildConfig.DEBUG){
        Log.d(build(), "👻 $log");
    }

}


fun Any.loge(log:String) {

    if(BuildConfig.DEBUG){
        Log.e(build(), "❌ $log");
    }

}


fun Any.logw(log:String) {

    if(BuildConfig.DEBUG){
        Log.w(build(), "🚧 $log");
    }

}


private fun build(): String{
    val ste = Thread.currentThread().stackTrace[4]
    val sb = StringBuilder()
    sb.append("[")
    sb.append(ste.fileName)
    sb.append("::");
    sb.append(ste.methodName)
    sb.append("::");
    sb.append(ste.lineNumber)
    sb.append("]");
    sb.append(TAG);
    return sb.toString()
}
