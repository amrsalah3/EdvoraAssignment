package com.narify.edvoraassessment

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint

class Drawer {
    private var previewing: Boolean = false
    private val shapes: ArrayList<Shape> = ArrayList()
    private lateinit var shape: Shape
    var color: Int = Color.BLACK
    var shapeType = PENCIL
        set(value) {
            createShape(value)
            field = value
        }

    private val paint = Paint().apply {
        style = Paint.Style.STROKE
        strokeWidth = 5f
    }

    init {
        createShape(shapeType)
    }


    private fun createShape(type: Int) {
        shape = when (type) {
            PENCIL -> Pencil(color)
            RECTANGLE -> Polygon(RECTANGLE, color)
            ELLIPSE -> Polygon(ELLIPSE, color)
            ARROW -> Arrow(color)
            else -> throw IllegalArgumentException()
        }
    }

    fun onTouch(x: Float, y: Float) {
        createShape(shapeType)
        shape.setStart(x, y)
        if (!isPencil()) previewing = true
    }


    fun onMove(x: Float, y: Float) {
        shape.setEnd(x, y)
        if (!isPencil()) previewing = true
    }

    fun onLift() {
        shapes.add(shape)
        previewing = false
    }

    fun draw(canvas: Canvas) {
        shapes.forEach {
            drawShape(it, canvas)
        }
        if (isPencil() || previewing) {
            drawShape(shape, canvas)
        }
    }

    private fun drawShape(shape: Shape, canvas: Canvas) {
        paint.color = shape.color
        canvas.drawPath(shape.path, paint)
    }

    private fun isPencil() = (shape is Pencil)

    companion object {
        const val PENCIL = 1
        const val ARROW = 2
        const val RECTANGLE = 3
        const val ELLIPSE = 4
    }

}