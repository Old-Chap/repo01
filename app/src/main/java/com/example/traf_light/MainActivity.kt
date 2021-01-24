package com.example.traf_light

import android.os.Bundle
import android.os.Handler
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

fun withDelay(delay : Long, block : () -> Unit) {
    Handler().postDelayed(Runnable(block), delay)
}


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val myButton: Button = findViewById(R.id.button)
        val myRed: ImageView = findViewById(R.id.imageView3)
        val myYel: ImageView = findViewById(R.id.imageView2)
        val myGre: ImageView = findViewById(R.id.imageView1)
        val sery = R.drawable.circle
        val kras = R.drawable.circle_r
        val jelt = R.drawable.circle_y
        val zeln = R.drawable.circle_g
        var flag = false
        val st = "СТАРТ"
        val sp = "СТОР"
        myButton.text = st

        fun buttontoColor(thebutton: ImageView, dr: Int){
            thebutton.setImageResource(dr)
        }

        myButton.setOnClickListener {
          if (!flag) {
            myButton.text = sp
            flag = !flag
            //do {
                //withDelay(0) { buttontoColor(myGre, sery) }
                withDelay(0) { buttontoColor(myRed, kras) }
                withDelay(2500) { buttontoColor(myYel, jelt) }

                withDelay(3500) { buttontoColor(myRed, sery) }
                withDelay(3500) { buttontoColor(myYel, sery) }
                withDelay(3500) { buttontoColor(myGre, zeln) }

                withDelay(6000) { buttontoColor(myGre, sery) }
                withDelay(6500) { buttontoColor(myGre, zeln) }
                withDelay(7000) { buttontoColor(myGre, sery) }
                withDelay(7500) { buttontoColor(myGre, zeln) }
                withDelay(8000) { buttontoColor(myGre, sery) }
                withDelay(8500) { buttontoColor(myGre, zeln) }
                withDelay(9000) { buttontoColor(myGre, sery) }

                withDelay(9000) { buttontoColor(myYel, jelt) }
                withDelay(10000) { buttontoColor(myYel, sery) }

                withDelay(10000) { buttontoColor(myRed, kras) }
            //} while (true)
          } else {
            myButton.text = st
            flag = !flag
            myRed.setImageResource(R.drawable.circle)
            myYel.setImageResource(R.drawable.circle)
            myGre.setImageResource(R.drawable.circle)

          }
        }
  }
}