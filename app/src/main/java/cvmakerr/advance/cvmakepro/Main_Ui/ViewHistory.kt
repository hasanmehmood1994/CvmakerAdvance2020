package cvmakerr.advance.cvmakepro.Main_Ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.Environment
import android.util.Log
import android.view.View
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.InterstitialAd
import cvmakerr.advance.cvmakepro.Adapters.History_Adapter
import cvmakerr.advance.cvmakepro.R
import cvmakerr.advance.cvmakepro.Room_Database.Entities.History
import cvmakerr.advance.cvmakepro.Room_Database.ViewModel.ViewModel_Class
import kotlinx.android.synthetic.main.activity_view_history.*
import java.io.File
import java.io.FileOutputStream


class ViewHistory : AppCompatActivity(),History_Adapter.OnClickListener_Recycler,History_Adapter.OnClickListener_RecyclerDelete {
    private var viewModelClass: ViewModel_Class?=null
    lateinit var adapter: History_Adapter
    lateinit var mAdView : AdView
    private lateinit var mInterstitialAd: InterstitialAd


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getSupportActionBar()!!.hide();
        setContentView(R.layout.activity_view_history)
        imgempty.visibility = View.GONE
        viewModelClass = ViewModelProviders.of(this).get(ViewModel_Class::class.java)
        viewModelClass?.getHistory()?.observe(this, Observer<List<History>> {
            if (it.size == 0) {
                Log.e("size", "zero")
                imgempty.visibility = View.VISIBLE
                this.setRecyler(it)

            } else {

                Log.e("size", "" + it.size)
                this.setRecyler(it)
                imgempty.visibility = View.GONE
                if(it.size>1)
                {
                    Toast.makeText(this,"Slide left to view more",Toast.LENGTH_SHORT).show()
                }
            }

        })
        mAdView = findViewById(R.id.adView)
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)

        mInterstitialAd = InterstitialAd(this)
        mInterstitialAd.adUnitId = "ca-app-pub-3940256099942544/1033173712"
        mInterstitialAd.loadAd(AdRequest.Builder().build())
    }


    @SuppressLint("WrongConstant")
    private fun setRecyler(skills: List<History>?){
        adapter = skills?.let { this@ViewHistory?.let { it1 -> History_Adapter(it1, it, this, this) } }!!

        recyler_view?.layoutManager = LinearLayoutManager(this, LinearLayout.HORIZONTAL, false)
        recyler_view.adapter = adapter

    }
    override fun click_listner(position: Int, get: History) {

    }

    override fun deleteclick_listner(position: Int, get: History, s: String) {

        if (s.equals("del"))
        {
            viewModelClass?.deleteSingleHistory(get.id)

        }
        else{
            SavePhotoTask(get.imagery)
        }
    }
    fun SavePhotoTask(jpeg: ByteArray?) {
        val imagesFolder = File(Environment.getExternalStorageDirectory(), "savedcvs")
        imagesFolder.mkdirs()
        val photo = File(imagesFolder, "name.jpg")
        try {
            val fos = FileOutputStream(photo.getPath())
            fos.write(jpeg)
            fos.close()
            Toast.makeText(this@ViewHistory,"Saved to savedcvs",Toast.LENGTH_LONG).show();
        } catch (e: Exception) {
            Toast.makeText(this@ViewHistory,"Some Error",Toast.LENGTH_LONG).show();
        }
    }
}