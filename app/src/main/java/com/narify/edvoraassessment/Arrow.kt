package com.narify.edvoraassessment

import android.graphics.PointF

class Arrow(color: Int) : Shape(color) {
    private val start = PointF()

    override fun setStart(x: Float, y: Float) {
        start.x = x
        start.y = y
    }

    override fun setEnd(x: Float, y: Float) {
        val dx: Float = x - start.x
        val dy: Float = y - start.y
        val arrowFraction = 0.1F // Arrow faction size of the base line
        /* Arrow two end points */
        val x1: Float = start.x + ((1 - arrowFraction) * dx + arrowFraction * dy)
        val y1: Float = start.y + ((1 - arrowFraction) * dy - arrowFraction * dx)
        val x2: Float = start.x + ((1 - arrowFraction) * dx - arrowFraction * dy)
        val y2: Float = start.y + ((1 - arrowFraction) * dy + arrowFraction * dx)

        path.reset()
        path.moveTo(start.x, start.y)
        path.lineTo(x, y)
        path.moveTo(x1, y1)
        path.lineTo(x, y)
        path.lineTo(x2, y2)

    }

}