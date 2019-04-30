package br.com.fiap.pokemonadventure.util

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.support.v4.app.ShareCompat
import android.support.v4.content.ContextCompat.startActivity



class CallIntent{
    companion object {
        fun call(activity: Activity, phoneNumber: String){
            val intent = Intent(Intent.ACTION_DIAL)
            val phoneWithoutFormat = Utils.getStringWithoutSpecialChars(phoneNumber)
            intent.data = Uri.parse("tel:$phoneWithoutFormat")
            activity.startActivity(intent)
        }
    }


}
