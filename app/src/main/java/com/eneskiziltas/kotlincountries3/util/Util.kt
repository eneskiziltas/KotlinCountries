package com.eneskiziltas.kotlincountries3.util

import android.content.Context
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.eneskiziltas.kotlincountries3.R

//Extension

/*
fun String.myExtension(myParameter: String) {

    println(myParameter)

}

 */

fun ImageView.downoadFromUrl(url: String?, progressDrawable: CircularProgressDrawable){

    //görsel inene kadar ne gösterilecek
    val options = RequestOptions()
        .placeholder(progressDrawable)
        .error(R.mipmap.ic_launcher_round)

    Glide.with(context)
        .setDefaultRequestOptions(options)
        .load(url)
        .into(this)

}

fun placeholderProgressBar(context: Context) : CircularProgressDrawable{
    return CircularProgressDrawable(context).apply {
        strokeWidth = 8f
        centerRadius = 40f
        start()
    }
}

@BindingAdapter("android:dowlandUrl")
fun dowlandImage(view : ImageView, url: String?) {
    view.downoadFromUrl(url, placeholderProgressBar(view.context))
}