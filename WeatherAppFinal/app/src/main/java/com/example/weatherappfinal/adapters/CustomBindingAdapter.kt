package com.example.weatherappfinal.adapters

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.example.weatherappfinal.getFormattedDate
import com.example.weatherappfinal.icon_prefix
import com.example.weatherappfinal.icon_suffix

@BindingAdapter("app:setWeatherIcon")
fun setIcon(imageView: ImageView, icon: String?) {
    icon?.let {
        val url = "$icon_prefix$icon$icon_suffix"
        Glide
            .with(imageView.context)
            .load(url)
            .into(imageView)
    }
}
@BindingAdapter("app:setDateTime")
fun setDateTime(textView: TextView, dt: Long){
    textView.text = getFormattedDate(dt, "EEE dd, yyyy HH:mm")
}

@BindingAdapter("app:setWeekdayTime")
fun setWeekdayTime(textView: TextView, dt: Long){
    textView.text = getFormattedDate(dt, "EEE, HH:mm")
}

@BindingAdapter("app:setWeekdayTime")
fun setSunriseTime(textView: TextView, dt: Long){
    textView.text = getFormattedDate(dt, "h:mm a")
}
