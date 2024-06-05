package com.adso.myapplicationsantes


data class Notification(
    val imageRes: Int,
    val description: String,
    val time: String,
    var isUnread: Boolean
)