package com.narify.edvoraassessment

import android.graphics.Color
import android.graphics.Path

abstract class Shape(val color: Int = Color.BLACK) {
    val path: Path = Path()

    abstract fun setStart(x: Float, y: Float)
    abstract fun setEnd(x: Float, y: Float)
}