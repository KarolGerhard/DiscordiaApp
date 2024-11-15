package br.com.akgs.discordia.ui.splash

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import br.com.akgs.discordia.R
import br.com.akgs.discordia.ui.login.LoginActivity

class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        window.statusBarColor = Color.parseColor("#297BF5")


        Handler(Looper.getMainLooper()).postDelayed({
           val intent = Intent(this, LoginActivity::class.java)
           startActivity(intent)
           finish()
        }, 3000)
    }
}