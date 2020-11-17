package cvmakerr.advance.cvmakepro.MainClass

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import cvmakerr.advance.cvmakepro.Adapters.MainLoaderAdapter
import cvmakerr.advance.cvmakepro.Fragments.PersonalInfo_Fragment
import cvmakerr.advance.cvmakepro.Model_Classes.Typemodel
import cvmakerr.advance.cvmakepro.R


class MainHome : AppCompatActivity(), MainLoaderAdapter.CellClickListener{

    lateinit var mainbg: ConstraintLayout

    @SuppressLint("WrongConstant")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getSupportActionBar()!!.hide();
        setContentView(R.layout.activity_main_home)
        setTitle("Home")
        val recyclerView = findViewById(R.id.recyclertype) as RecyclerView
        mainbg=findViewById(R.id.mainbg) as ConstraintLayout
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)
        val typesmodels = ArrayList<Typemodel>()

        typesmodels.add(Typemodel("Personal Info", 1, R.drawable.img_persoanlinfo, R.color.info))
        typesmodels.add(Typemodel("Objective", 2, R.drawable.img_objective, R.color.obj))
        typesmodels.add(Typemodel("Experience", 3, R.drawable.img_experience, R.color.expi))
        typesmodels.add(Typemodel("Qualification", 4, R.drawable.img_qualification, R.color.qua))
        typesmodels.add(Typemodel("Skills", 5, R.drawable.img_skills, R.color.skill))
        typesmodels.add(Typemodel("Achivements", 6, R.drawable.img_achivement, R.color.achieve))
        typesmodels.add(Typemodel("Projects", 7, R.drawable.img_projects, R.color.project))
        typesmodels.add(Typemodel("Hobbies", 8, R.drawable.img_skills, R.color.hobby))
        typesmodels.add(Typemodel("Languages", 5, R.drawable.img_languge, R.color.lang))
        typesmodels.add(Typemodel("Reference", 10, R.drawable.img_reference, R.color.ref))
        //creating our adapter

        val adapter = MainLoaderAdapter(typesmodels, this, this)

        //now adding the adapter to recyclerview
      recyclerView.adapter = adapter
        switchToaboutmeFragment()
    }

    override fun onCellClickListener(position: Int, data: Typemodel) {
        Toast.makeText(this, "data" + data.name, Toast.LENGTH_SHORT).show()
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
            mainbg.setBackgroundColor(getColor(data.tintcolor))
        }
    }

    fun switchToaboutmeFragment() {
        val manager: FragmentManager = supportFragmentManager
        val transaction: FragmentTransaction = manager.beginTransaction()
        transaction.add(R.id.fragmentarea, PersonalInfo_Fragment())
        transaction.commit()

    }
}



