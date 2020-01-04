package com.example.janken

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {

    val gu = 0
    val choki = 1
    val pa = 2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        val id = intent.getIntExtra("MyHand",0)

        val myHand = when(id){
            R.id.gu -> {
                myHandImaege.setImageResource(R.drawable.janken_gu)
                gu
            }
            R.id.choki -> {
                myHandImaege.setImageResource(R.drawable.janken_choki)
                choki
            }
            R.id.pa -> {
                myHandImaege.setImageResource(R.drawable.janken_pa)
                pa
            }
            else -> gu
        }

        val comHand = (Math.random() * 3).toInt()
        when(comHand){
            gu -> comHandImage.setImageResource(R.drawable.janken_gu)
            choki -> comHandImage.setImageResource(R.drawable.janken_choki)
            pa -> comHandImage.setImageResource(R.drawable.janken_pa)
        }

        val gameResult = (comHand - myHand + 3) % 3

        when(gameResult){
            0 -> resultLabel.setText(R.string.result_draw)
            1 -> resultLabel.setText(R.string.result_win)
            2 -> resultLabel.setText(R.string.result_lose)
        }

        backButton.setOnClickListener { finish() }
    }
}
