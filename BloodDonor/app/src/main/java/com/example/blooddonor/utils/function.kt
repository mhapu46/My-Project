package com.example.blooddonor.utils

import java.text.SimpleDateFormat
import java.util.*

fun getFormattedDateTime(value: Long, format: String) : String {
    return SimpleDateFormat(format).format(Date(value))
}