package com.narify.edvoraassessment

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View

class DrawingAreaView(context: Context, attrs: AttributeSet) : View(context, attrs) {
    private val drawer = Drawer()

    fun setShapeType(type: Int) {
        drawer.shapeType = type
    }

    fun setShapeColor(color: Int) {
        drawer.color = color
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        val x = event!!.x
        val y = event.y

        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                drawer.onTouch(x, y)
            }
            MotionEvent.ACTION_MOVE -> {
                drawer.onMove(x, y)
                invalidate()
            }
            MotionEvent.ACTION_UP -> {
                drawer.onLift()
                invalidate()
            }
            else -> return false
        }
        return true
    }


    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        drawer.draw(canvas)
    }

}
