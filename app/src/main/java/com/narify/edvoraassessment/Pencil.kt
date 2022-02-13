package com.narify.edvoraassessment

class Pencil(color: Int) : Shape(color) {

    override fun setStart(x: Float, y: Float) {
        path.moveTo(x, y)
    }

    override fun setEnd(x: Float, y: Float) {
        path.lineTo(x, y)
    }

}