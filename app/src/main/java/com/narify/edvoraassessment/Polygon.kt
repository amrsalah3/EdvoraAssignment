package com.narify.edvoraassessment

import android.graphics.Path
import android.graphics.RectF

class Polygon(private val polygonType: Int, color: Int): Shape(color) {
    private val rectF = RectF()

    override fun setStart(x: Float, y: Float) {
        rectF.left = x
        rectF.top = y
    }

    override fun setEnd(x: Float, y: Float) {
        rectF.right = x
        rectF.bottom = y
        path.reset()
        addShapeToPath()
        path.close()
    }

    private fun addShapeToPath(){
        when(polygonType){
            Drawer.RECTANGLE ->  path.addRect(rectF, Path.Direction.CW)
            Drawer.ELLIPSE ->  path.addOval(rectF, Path.Direction.CW)
        }
    }
}