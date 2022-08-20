package me.asiimwedismas.startelecom.core.actions

import android.content.Context
import android.content.Intent

object Actions {
    fun openLoginIntent(context: Context) = internalIntent(context, "me.asiimwedismas.startelecom.login.open")

    private fun internalIntent(context: Context, action: String) = Intent(action).setPackage(context.packageName)
}