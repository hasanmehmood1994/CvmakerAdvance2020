package cvmakerr.advance.cvmakepro

import android.Manifest.permission
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.os.Environment
import android.os.Handler
import android.util.Log
import androidx.appcompat.app.AlertDialog
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import cvmakerr.advance.cvmakepro.Main_Ui.Form_Page
import cvmakerr.advance.cvmakepro.Main_Ui.HomePage
import java.io.File

class SplashScreen : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        setTitle("Splash")
        funhandler();

    }
    private fun createfolder() {



            val direct2 = File(Environment.getExternalStorageDirectory().toString() + "/cvimages")
            if (!direct2.exists()) {
                if (direct2.mkdir());
            }


        val direct = File(Environment.getExternalStorageDirectory().toString() + "/cvpdfs")
        if (!direct.exists()) {
            if (direct.mkdir());
        }

    }
    private fun funhandler() {
        Handler().postDelayed({
            checkPermission()
            requestPermissionAndContinue()

        }, 2000)
    }
    private fun runActivity() {
        val i = Intent(this@SplashScreen, HomePage::class.java)
        startActivity(i)
        finish()
    }

    private val PERMISSION_REQUEST_CODE = 200

    private fun checkPermission(): Boolean {
        return  ContextCompat.checkSelfPermission(this, permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED && ContextCompat.checkSelfPermission(this, permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED
    }


    private fun requestPermissionAndContinue() {
        if ( ContextCompat.checkSelfPermission(this, permission.WRITE_EXTERNAL_STORAGE
            ) != PackageManager.PERMISSION_GRANTED && ContextCompat.checkSelfPermission(
                this,
                permission.READ_EXTERNAL_STORAGE
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            if ( ActivityCompat.shouldShowRequestPermissionRationale(
                    this,
                    permission.WRITE_EXTERNAL_STORAGE
                )
                && ActivityCompat.shouldShowRequestPermissionRationale(
                    this,
                    permission.READ_EXTERNAL_STORAGE
                )
            ) {
                val alertBuilder = AlertDialog.Builder(this)
                alertBuilder.setCancelable(true)
                alertBuilder.setTitle(getString(R.string.permission_necessary))
                alertBuilder.setMessage(R.string.storage_permission_is_encessary_to_wrote_event)
                alertBuilder.setPositiveButton(
                    android.R.string.yes
                ) { dialog, which ->
                    ActivityCompat.requestPermissions(
                        this@SplashScreen,
                        arrayOf(
                            permission.WRITE_EXTERNAL_STORAGE,
                            permission.READ_EXTERNAL_STORAGE
                        ),
                        PERMISSION_REQUEST_CODE
                    )
                }
                val alert = alertBuilder.create()
                alert.show()
                Log.e("", "permission denied, show dialog")
            } else {
                ActivityCompat.requestPermissions(
                    this@SplashScreen, arrayOf(
                        permission.WRITE_EXTERNAL_STORAGE,
                        permission.READ_EXTERNAL_STORAGE
                    ), PERMISSION_REQUEST_CODE
                )
            }
        } else {
            runActivity()
        }
    }


    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String?>,
        grantResults: IntArray
    ) {
        when (requestCode) {
            PERMISSION_REQUEST_CODE -> if (grantResults.size > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                createfolder()
                runActivity()
            }
        }
    }

}
