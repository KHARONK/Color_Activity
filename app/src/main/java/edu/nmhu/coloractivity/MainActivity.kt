package edu.nmhu.coloractivity

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet

class MainActivity : AppCompatActivity() {

    companion object{
        const val COLOR_RESULT:String = "edu.nmhuMultipleActivities.COLOR_RESULT"
    }

    private val startForResult =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            result: ActivityResult ->
            if (result.resultCode ==Activity.RESULT_OK){
                val intent = result.data
                    //Handle the Intent
                Log.d("MACTResult", intent?.getStringExtra("retuenMessage").toString())
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        val color1 = EditText(this).apply{
            hint = "Enter Hex Color without #" }

        val color2 = EditText(this).apply {
            hint = "Enter Hex Color Without #"}

        val color3 = EditText(this).apply {
            hint = "Enter Hex Color Without #"
        }

        val submitButton = Button(this).apply {
            text = "Submit"
            setOnClickListener{
                val passableData = Intent(applicationContext, ColorActivity::class.java).apply {
                    putExtra(ColorActivity.COLOR_REQUESTED, "#"+color1.text.toString())
                    putExtra(ColorActivity.COLOR_REQUESTED, "#"+color2.text.toString())
                    putExtra(ColorActivity.COLOR_REQUESTED,"#"+color3.text.toString())
                }
                startForResult.launch(passableData)
            }

        }
        val linearLayout = LinearLayoutCompat(this).apply {
            layoutParams = LinearLayoutCompat.LayoutParams(
                LinearLayoutCompat.LayoutParams.MATCH_PARENT,
                LinearLayoutCompat.LayoutParams.MATCH_PARENT)
            orientation = LinearLayoutCompat.VERTICAL
            addView(color1)
            addView(color2)
            addView(color3)
            addView(submitButton)
        }

        // Look up the main layout by the id we just gave it
        findViewById<ConstraintLayout>(R.id.main_layout).apply {
            setBackgroundColor(Color.GREEN)
            addView(linearLayout)
        }
    }
}