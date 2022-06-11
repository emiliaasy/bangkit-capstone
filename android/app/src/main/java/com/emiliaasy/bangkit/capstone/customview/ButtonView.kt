package com.emiliaasy.bangkit.capstone.customview

import android.content.Context
import android.graphics.Canvas
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatButton
import androidx.core.content.ContextCompat
import com.emiliaasy.bangkit.capstone.R

class ButtonView: AppCompatButton {
    private lateinit var enabledBackground: Drawable
    private lateinit var disabledBackground: Drawable
    private var txtColor: Int = 0

    constructor(context: Context) : super(context) {
        init()
    }
    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init()
    }
    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init()
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        background = if(isEnabled) enabledBackground else disabledBackground
        setTextColor(txtColor)
//        textSize = 12f
//        gravity = Gravity.CENTER
//        text = if(isEnabled) "Submit" else "Isi Dulu"
    }

    private fun init() {
        txtColor = ContextCompat.getColor(context, R.color.pink_gray)
        enabledBackground = ContextCompat.getDrawable(context, R.drawable.button_shape) as Drawable
        disabledBackground = ContextCompat.getDrawable(context, R.drawable.button_shape_disable) as Drawable
    }
}