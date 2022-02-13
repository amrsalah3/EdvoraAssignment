package com.narify.edvoraassessment

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var toolsView: LinearLayout
    private lateinit var paletteView: LinearLayout
    private lateinit var drawingView: DrawingAreaView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toolsView = findViewById(R.id.ll_tools)
        paletteView = findViewById(R.id.ll_palette)
        drawingView = findViewById(R.id.iv_drawing_area)
    }

    fun pickTool(view: View) {
        val shape: Int = when (view.id) {
            R.id.ib_pencil -> Drawer.PENCIL
            R.id.ib_arrow -> Drawer.ARROW
            R.id.ib_rectangle -> Drawer.RECTANGLE
            R.id.ib_ellipse -> Drawer.ELLIPSE
            R.id.ib_palette -> {
                triggerPalette()
                return
            }
            else -> throw IllegalArgumentException()
        }
        drawingView.setShapeType(shape)
    }

    private fun triggerPalette() {
        paletteView.run {
            visibility = if (visibility == VISIBLE) GONE
            else VISIBLE
        }
    }

    fun pickColor(view: View) {
        val color: Int = when (view.id) {
            R.id.ib_red -> Color.RED
            R.id.ib_green -> Color.GREEN
            R.id.ib_blue -> Color.BLUE
            R.id.ib_black -> Color.BLACK
            else -> throw IllegalArgumentException()
        }
        drawingView.setShapeColor(color)
    }


}