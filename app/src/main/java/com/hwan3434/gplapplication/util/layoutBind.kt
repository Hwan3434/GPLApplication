package com.hwan3434.gplapplication.util

import android.widget.ImageView
import androidx.databinding.BindingAdapter

object layoutBind {


    @BindingAdapter("app:imageRes")
    @JvmStatic
    fun loadImage(imageView: ImageView, res: Int){
        imageView.setImageResource(res)
    }

}