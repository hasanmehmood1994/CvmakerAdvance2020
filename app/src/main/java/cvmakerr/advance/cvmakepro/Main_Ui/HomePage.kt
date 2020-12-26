package cvmakerr.advance.cvmakepro.Main_Ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.ViewModelProviders
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.InterstitialAd
import com.google.android.gms.ads.MobileAds
import cvmakerr.advance.cvmakepro.R
import cvmakerr.advance.cvmakepro.Room_Database.Entities.History
import cvmakerr.advance.cvmakepro.Room_Database.Entities.Hobbies
import cvmakerr.advance.cvmakepro.Room_Database.ViewModel.ViewModel_Class


class HomePage : AppCompatActivity() {
    lateinit var mAdView : AdView
    private var viewModelClass: ViewModel_Class? = null
    private lateinit var mInterstitialAd: InterstitialAd
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getSupportActionBar()!!.hide();
        setContentView(R.layout.activity_home_page)
        viewModelClass = ViewModelProviders.of(this).get(ViewModel_Class::class.java)
        MobileAds.initialize(this) {}

        mAdView = findViewById(R.id.adView)
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)

        mInterstitialAd = InterstitialAd(this)
        mInterstitialAd.adUnitId = "ca-app-pub-3940256099942544/1033173712"
        mInterstitialAd.loadAd(AdRequest.Builder().build())
    }
    fun  showadd(){
        if (mInterstitialAd.isLoaded) {
            mInterstitialAd.show()
        } else {
            Log.d("TAG", "The interstitial wasn't loaded yet.")
        }
    }

    fun opensaved(view: View) {
        val i = Intent(this@HomePage,ViewHistory::class.java)
        startActivity(i)

    }
    fun createcv(view: View) {
        val i = Intent(this@HomePage, Form_Page::class.java)
    startActivity(i)

    }


}