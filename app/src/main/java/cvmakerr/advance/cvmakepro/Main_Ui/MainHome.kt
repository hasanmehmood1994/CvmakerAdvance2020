package cvmakerr.advance.cvmakepro.Main_Ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import cvmakerr.advance.cvmakepro.Adapters.Cv_Type_List_Adapter
import cvmakerr.advance.cvmakepro.Fragments.*

import cvmakerr.advance.cvmakepro.Model_Classes.Typemodel
import cvmakerr.advance.cvmakepro.R


class MainHome : AppCompatActivity(), Cv_Type_List_Adapter.CellClickListener{

    lateinit var mainbg: ConstraintLayout
    private lateinit var fragment: PersonalInfo_Fragment
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
        val adapter = Cv_Type_List_Adapter(typesmodels, this, this)

        //now adding the adapter to recyclerview
      recyclerView.adapter = adapter
        switchToPersonalInfoFragment()




    }

    override fun onCellClickListener(position: Int, data: Typemodel) {

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
            mainbg.setBackgroundColor(getColor(R.color.purple_200))
        }
        if (position==0)
        {

            switchFragment(PersonalInfo_Fragment())
        }
        else if (position==1)
        {

            switchFragment(About_Fragment())
        }
        else if(position==2)
        {

            switchFragment(Experience_Fragment())
        }
        else if(position==3)
        {
            switchFragment(Qualification_Fragment())
        }
        else if(position==4)
        {
            switchFragment(Skill_Fragment())
        }
        else if(position==5)
        {
            switchFragment(AchievementFragment())
        }
        else if(position==6)
        {
            switchFragment(Project_Fragment())
        }
        else if(position==7)
        {
            switchFragment(Hobbie_Fragment())
        }
        else if(position==8)
        {
            switchFragment(LanguageFragment())
        }
        else if(position==9)
        {

        }
    }

    private fun switchFragment(fragment: Fragment) {
        val manager: FragmentManager = supportFragmentManager
        val transaction: FragmentTransaction = manager.beginTransaction()
        transaction.replace(R.id.fragmentarea,fragment)
        transaction.commit()
    }


    fun switchToPersonalInfoFragment() {
        val manager: FragmentManager = supportFragmentManager
        val transaction: FragmentTransaction = manager.beginTransaction()
        transaction.replace(R.id.fragmentarea, PersonalInfo_Fragment())

        transaction.commit()

    }

}



