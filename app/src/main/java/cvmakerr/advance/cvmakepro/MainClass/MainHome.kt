package cvmakerr.advance.cvmakepro.MainClass

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import cvmakerr.advance.cvmakepro.Adapters.MainLoaderAdapter
import cvmakerr.advance.cvmakepro.Model_Classes.Typemodel
import cvmakerr.advance.cvmakepro.R

class MainHome : AppCompatActivity(), MainLoaderAdapter.CellClickListener{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_home)
        setTitle("Home")
        val recyclerView = findViewById(R.id.recyclertype) as RecyclerView

        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)
        val typesmodels = ArrayList<Typemodel>()

        typesmodels.add(Typemodel("Personal Info", 1, R.drawable.icon_personalinfo))
        typesmodels.add(Typemodel("asda", 2, R.drawable.icon_personalinfo))
        typesmodels.add(Typemodel("asda", 3, R.drawable.icon_personalinfo))
        typesmodels.add(Typemodel("asda", 4, R.drawable.icon_personalinfo))
        //creating our adapter

        val adapter = MainLoaderAdapter(typesmodels, this, this)

        //now adding the adapter to recyclerview
      recyclerView.adapter = adapter
    }

    override fun onCellClickListener(position: Int, data: Typemodel) {
        Toast.makeText(this,"data"+data.name,Toast.LENGTH_SHORT).show()
    }


}

