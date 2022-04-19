package com.example.mynote

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import java.util.*
import kotlin.concurrent.schedule

@SuppressLint("CustomSplashScreen")
class SplashActivity:AppCompatActivity() {

   override fun onCreate(savedInstanceState: Bundle?) {
       super.onCreate(savedInstanceState)
       setContentView(R.layout.activity_splash)

       fun goLog(){
           startActivity((Intent(this, HomeActivity::class.java)))
       }

       Timer().schedule(3000){
           goLog()
       }
   }
}