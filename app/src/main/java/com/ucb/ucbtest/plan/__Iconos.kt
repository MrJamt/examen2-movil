package com.ucb.ucbtest.plan

import androidx.compose.ui.graphics.vector.ImageVector
import com.ucb.ucbtest.plan.iconos.Facebook
import com.ucb.ucbtest.plan.iconos.Instagram
import com.ucb.ucbtest.plan.iconos.Messenger
import com.ucb.ucbtest.plan.iconos.Snapchat
import com.ucb.ucbtest.plan.iconos.Telegram
import com.ucb.ucbtest.plan.iconos.Whatsapp
import com.ucb.ucbtest.plan.iconos.WhatsappGreen
import com.ucb.ucbtest.plan.iconos.X
import kotlin.String
import kotlin.collections.List as ____KtList
import kotlin.collections.Map as ____KtMap

public object Iconos

private var __AllIcons: ____KtList<ImageVector>? = null

public val Iconos.AllIcons: ____KtList<ImageVector>
  get() {
    if (__AllIcons != null) {
      return __AllIcons!!
    }
    __AllIcons= listOf(Facebook, Instagram, Messenger, Snapchat, Telegram, Whatsapp, WhatsappGreen,
        X)
    return __AllIcons!!
  }

private var __AllIconsNamed: ____KtMap<String, ImageVector>? = null

public val Iconos.AllIconsNamed: ____KtMap<String, ImageVector>
  get() {
    if (__AllIconsNamed != null) {
      return __AllIconsNamed!!
    }
    __AllIconsNamed= mapOf("facebook" to Facebook, "instagram" to Instagram, "messenger" to
        Messenger, "snapchat" to Snapchat, "telegram" to Telegram, "whatsapp" to Whatsapp,
        "whatsappgreen" to WhatsappGreen, "x" to X)
    return __AllIconsNamed!!
  }
