package br.com.fiap.pokemonadventure.util

import android.app.Activity
import android.content.Intent
import android.support.v4.app.ShareCompat

class ShareIntent{
    companion object {
        fun share(activity: Activity, subject: String, text: String){
            val shareIntent =  ShareCompat.IntentBuilder.from(activity)
                .setType("text/plain")
                .setSubject(subject)
                .setText(text)
                .createChooserIntent()

            activity.startActivity(shareIntent)
        }
    }
}
