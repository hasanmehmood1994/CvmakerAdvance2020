package cvmakerr.advance.cvmakepro

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import cvmakerr.advance.cvmakepro.Main_Ui.MainHome

class SplashScreen : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        setTitle("Splash")
        funhandler();

    }

    private fun funhandler() {
        Handler().postDelayed({
            intent = Intent(this, MainHome::class.java)
            startActivity(intent)
            finish()

        }, 2000)
    }

}
