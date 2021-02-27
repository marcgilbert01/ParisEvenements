package com.example.imageView

import android.content.Context
import android.net.Uri
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatImageView
import com.bumptech.glide.Glide

class PeImageView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : AppCompatImageView(context, attrs, defStyleAttr) {

    override fun setImageURI(uri: Uri?) {
        super.setImageURI(uri)
        Glide.with(this.context)
            .load(uri)
            .into(this)
    }

    fun setImageUrl(url: String) {
        Uri.parse(url)?.let {
            setImageURI(it)
        }
    }
}