package edu.nmhu.coloractivity

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout

class ColorActivity : AppCompatActivity() {

    companion object {
        const val COLOR_REQUESTED: String = "edu.nmhuMultipleActivities.COLOR_REQUESTED"
    }

    private var col1: Int = 0
    private var col2: Int = 0
    private var col3: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_color)

        val getIntentDataButton = Button(this).apply {
            text = "Save"
            setOnClickListener {
                val passabaleData = Intent().apply {
                    putExtra(MainActivity.COLOR_RESULT, "EXIT")
                    putExtra("returnMessage", "Exit")
                }
                setResult(RESULT_OK, passabaleData)
                finish()
            }
        }
        val color1 = View(this).apply {
            layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                400
            )
            try {
                col1 = Color.parseColor(intent.getStringExtra(COLOR_REQUESTED))
                setBackgroundColor(col1)
            } catch (e: NumberFormatException) {
                setBackgroundColor(Color.WHITE)
                col1 = 0

            }
            setOnClickListener {
                col1 += 10
                it.setBackgroundColor(col1)
                var hexVal = "%X".format(col1)
                hexVal = hexVal.subSequence(2, hexVal.length).toString()
                Log.d("HEXVal", hexVal)
            }
        }

            val color2 = View(this).apply {
                layoutParams = ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    400
                )
                try {
                    col2 = Color.parseColor(intent.getStringExtra(COLOR_REQUESTED))
                    setBackgroundColor(col2)
                } catch (e: NumberFormatException) {
                    setBackgroundColor(Color.YELLOW)
                    col2 = 0

                }
                setOnClickListener {
                    col2 += 10
                    it.setBackgroundColor(col2)
                    var hexVal = "%X".format(col2)
                    hexVal = hexVal.subSequence(2, hexVal.length).toString()
                    Log.d("HEXVal", hexVal)
                }
            }

                val color3 = View(this).apply {
                    layoutParams = ViewGroup.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        400
                    )
                    try {
                        col3 = Color.parseColor(intent.getStringExtra(COLOR_REQUESTED))
                        setBackgroundColor(col3)
                    } catch (e: NumberFormatException) {
                        setBackgroundColor(Color.MAGENTA)
                        col3 = 0

                    }
                    setOnClickListener {
                        col3 += 10
                        it.setBackgroundColor(col3)
                        var hexVal = "%X".format(col3)
                        hexVal = hexVal.subSequence(2, hexVal.length).toString()
                        Log.d("HEXVal", hexVal)
                    }

                val bgc: Int? = Color.parseColor(intent.getStringExtra("message"))
                bgc?.let { setBackgroundColor(it) }
            }
            findViewById<ConstraintLayout>(R.id.color_layout).apply {
                addView(color1)
                addView(color2)
                addView(color3)
                addView(getIntentDataButton)
            }
        }
    }



