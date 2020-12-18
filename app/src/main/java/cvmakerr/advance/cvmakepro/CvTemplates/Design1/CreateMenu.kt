package cvmakerr.advance.cvmakepro.CvTemplates.Design1

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.util.Base64
import android.util.Log
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import cvmakerr.advance.cvmakepro.R
import cvmakerr.advance.cvmakepro.Room_Database.Entities.*
import cvmakerr.advance.cvmakepro.Room_Database.ViewModel.ViewModel_Class
import cvmakerr.advance.cvmakepro.Shared_Prefrence.SharedPrefMain
import cvmakerr.advance.cvmakepro.TemplateAdapter.*


class CreateMenu : AppCompatActivity() {
    private var viewModelClass: ViewModel_Class? = null

    /////
    lateinit var qualification_adapter: Qualification_Adapter_Template
    lateinit var skills_adapter2: Skill_Adapter_Template2
    lateinit var skills_adapter: Skill_Adapter_Template
    lateinit var hobbies_adapter: Hobbie_Adapter_Template
    lateinit var lang_adapter: Language_Adapter_Template
    lateinit var expi_adapter: Experience_Adapter_Template
    lateinit var project_adapter: Project_Adapter_Template
    lateinit var achi_adapter: Achievements_Adapter_Template

    ////
    var sharedPrefMain: SharedPrefMain? = null;

    ///layout
    private lateinit var lytnameimg: LinearLayout
    private lateinit var lytcontact: LinearLayout
    private lateinit var lytskills: LinearLayout
    private lateinit var lythobbie: LinearLayout
    private lateinit var lytlang: LinearLayout
    private lateinit var lytabout: LinearLayout
    private lateinit var lytqualification: LinearLayout
    private lateinit var lytexpi: LinearLayout
    private lateinit var lytproject: LinearLayout
    private lateinit var lytachieve: LinearLayout
    private lateinit var lytref: LinearLayout
    ////viewabout
    private lateinit var name: TextView
    private lateinit var dob: TextView
    private lateinit var profession: TextView
    private lateinit var img: ImageView

    ///viewcontact
    private lateinit var phone: TextView
    private lateinit var email: TextView
    private lateinit var cnic: TextView
    private lateinit var natinality: TextView
    private lateinit var status: TextView
    private lateinit var address: TextView
    private lateinit var web: TextView
    private lateinit var ref: TextView
    //about
    private lateinit var about: TextView

    ///recyclersview
    private lateinit var recylerqualification: RecyclerView
    private lateinit var recyclerexpi: RecyclerView
    private lateinit var recylerproject: RecyclerView
    private lateinit var recylerlytachieve: RecyclerView
    private lateinit var recyclerskills: RecyclerView
    private lateinit var recyclerhobby: RecyclerView
    private lateinit var recyclerlang: RecyclerView
    var which :String ="1"
    ///
    override fun onCreate(savedInstanceState: Bundle?) {
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        super.onCreate(savedInstanceState)
        supportActionBar!!.hide();
        val bundle :Bundle ?=intent.extras
        if (bundle!=null){
          val  layout_to_load = bundle["idd"].toString().toInt()
            which = bundle["number"].toString()
            setContentView(layout_to_load)
        }
//



        getviews();

        ///
        sharedPrefMain = SharedPrefMain(this)
        viewModelClass = ViewModelProviders.of(this).get(ViewModel_Class::class.java)
        Setnameprofessionimg()
        SetContactinfo()
        SetAbout()
        SetRef()
        setviewmodels()
    }

    private fun getviews() {
        //contact
        phone = findViewById(R.id.phone)
        email = findViewById(R.id.email)
        address = findViewById(R.id.address)
        web = findViewById(R.id.web)
        cnic = findViewById(R.id.cnic)
        natinality = findViewById(R.id.natinality)
        status = findViewById(R.id.status)
        ref = findViewById(R.id.reference)
        //info
        name = findViewById(R.id.name)
        dob = findViewById(R.id.dob)
        profession = findViewById(R.id.profession)
        img = findViewById(R.id.img)
        //about
        about = findViewById(R.id.about)

        //recyler
        recylerqualification = findViewById(R.id.recylerqualification)
        recyclerexpi = findViewById(R.id.recyclerexpi)
        recylerproject = findViewById(R.id.recylerproject)
        recylerlytachieve = findViewById(R.id.recylerlytachieve)
        recyclerskills = findViewById(R.id.recyclerskills)
        recyclerhobby = findViewById(R.id.recyclerhobby)
        recyclerlang = findViewById(R.id.recyclerlang)
        //lyts
        lytnameimg = findViewById(R.id.lytnameimg)
        lytcontact = findViewById(R.id.lytcontact)
        lytskills = findViewById(R.id.lytskills)
        lythobbie = findViewById(R.id.lythobbie)
        lytlang = findViewById(R.id.lytlang)
        lytabout = findViewById(R.id.lytabout)
        lytqualification = findViewById(R.id.lytqualification)
        lytexpi = findViewById(R.id.lytexpi)
        lytproject = findViewById(R.id.lytproject)
        lytachieve = findViewById(R.id.lytachieve)
        lytref=findViewById(R.id.lytref)

    }


    private fun setviewmodels() {
        //qualification
        viewModelClass?.getQualification()?.observe(this, Observer<List<Qualification>> {
            if (it.size == 0) {
                Log.e("size", "zero")
                lytqualification.visibility = View.GONE
                this.setQualificationRecyler(it)
            } else {

                Log.e("size", "" + it.size)
                this.setQualificationRecyler(it)

            }

        })
        viewModelClass?.getSkills()?.observe(this, Observer<List<Skills>> {
            if (it.size == 0) {
                Log.e("size", "zero")
                lytskills.visibility = View.GONE
                if (which == "1") {
                    this.setSkillsRecyler(it)
                } else {
                    this.setSkillsRecyler2(it)
                }

            } else {


                if (which == "1") {
                    this.setSkillsRecyler(it)
                } else {
                    this.setSkillsRecyler2(it)
                }

            }

        })
        viewModelClass?.getHobbies()?.observe(this, Observer<List<Hobbies>> {
            if (it.size == 0) {
                Log.e("size", "zero")
                lythobbie.visibility = View.GONE
                this.setHobbiesRecyler(it)
            } else {

                Log.e("size", "" + it.size)
                this.setHobbiesRecyler(it)

            }

        })
        viewModelClass?.getLanguages()?.observe(this, Observer<List<Languages>> {
            if (it.size == 0) {
                Log.e("size", "zero")
                lytlang.visibility = View.GONE
                this.setLangRecyler(it)
            } else {

                Log.e("size", "" + it.size)
                this.setLangRecyler(it)
                //   imgempty.visibility=View.GONE
            }

        })
        viewModelClass?.getExperience()?.observe(this, Observer<List<Experience>> {
            if (it.size == 0) {
                Log.e("size", "zero")
                lytexpi.visibility = View.GONE
                this.setExpiRecyler(it)
            } else {

                Log.e("size", "" + it.size)
                this.setExpiRecyler(it)
                //   imgempty.visibility=View.GONE
            }

        })
        viewModelClass?.getProjects()?.observe(this, Observer<List<Projects>> {
            if (it.size == 0) {
                Log.e("size", "zero")
                lytproject.visibility = View.GONE
                this.seprojectRecyler(it)
            } else {

                Log.e("size", "" + it.size)
                this.seprojectRecyler(it)

            }

        })
        viewModelClass?.getAchievements()?.observe(this, Observer<List<Achievements>> {
            if (it.size == 0) {
                Log.e("size", "zero")
                lytachieve.visibility = View.GONE
                this.setAchievementRecyler(it)
            } else {

                Log.e("size", "" + it.size)
                this.setAchievementRecyler(it)

            }

        })
    }


    private fun Setnameprofessionimg() {
        name.setText("" + sharedPrefMain?.getname())
        profession.setText("" + sharedPrefMain?.getprofession())
        dob.setText("" + sharedPrefMain?.getdob())
        if (sharedPrefMain?.getimg().equals("0")) {
            img.setImageResource(R.drawable.icon_profile)
        } else {
            img.setImageBitmap(
                decodeBase642(
                    sharedPrefMain?.getimg()
                )
            )
        }
    }

    private fun SetContactinfo() {
        //phone
        if (sharedPrefMain?.getphone() == "") {
            phone.visibility = View.GONE
        } else {
            phone.setText("" + sharedPrefMain?.getphone())
        }
        //email
        if (sharedPrefMain?.getemail() == "") {
            email.visibility = View.GONE
        } else {
            email.setText("" + sharedPrefMain?.getemail())
        }
        //cnic
        if (sharedPrefMain?.getnic() == "") {
            cnic.visibility = View.GONE
        } else {
            cnic.setText("" + sharedPrefMain?.getnic())
        }
        //natinality
        if (sharedPrefMain?.getnatinality() == "") {
            natinality.visibility = View.GONE
        } else {
            natinality.setText("" + sharedPrefMain?.getnatinality())
        }
        //status
        if (sharedPrefMain?.getstatus() == "") {
            status.visibility = View.GONE
        } else {
            status.setText("" + sharedPrefMain?.getstatus())
        }
        //web
        if (sharedPrefMain?.getweb() == "") {
            web.visibility = View.GONE
        } else {
            web.setText("" + sharedPrefMain?.getweb())
        }
        //address
        if (sharedPrefMain?.getaddress() == "") {
            address.visibility = View.GONE
        } else {
            address.setText("" + sharedPrefMain?.getaddress())
        }

    }

    private fun SetAbout() {
        //about
        if (sharedPrefMain?.getaboutme() == "") {
            lytabout.visibility = View.GONE
        } else {
            about.setText("" + sharedPrefMain?.getaboutme())
        }


    }
    private fun SetRef() {
        //about
        if (sharedPrefMain?.getref() == "") {
            lytref.visibility = View.GONE
        } else {
           ref.setText("" + sharedPrefMain?.getref())
        }


    }

    ///////////////////////////////////////////////
    private fun setQualificationRecyler(qualification: List<Qualification>?) {
        // adapter = qualification?.Qualification_Adapter(it1, it,this,this) } }!!
        qualification_adapter =
            qualification?.let { this?.let { it1 -> Qualification_Adapter_Template(it1, it) } }!!
        val layoutManager = LinearLayoutManager(this)
        layoutManager.stackFromEnd = true
        layoutManager.reverseLayout = true

        recylerqualification.layoutManager = layoutManager

        recylerqualification.adapter = qualification_adapter

    }

    private fun setSkillsRecyler(skills: List<Skills>?) {
        skills_adapter = skills?.let { this?.let { it1 -> Skill_Adapter_Template(it1, it) } }!!
        val layoutManager = LinearLayoutManager(this)
        layoutManager.stackFromEnd = true
        layoutManager.reverseLayout = true

        recyclerskills.layoutManager = layoutManager

        recyclerskills.adapter = skills_adapter

    }
    private fun setSkillsRecyler2(skills: List<Skills>?) {
        skills_adapter2 = skills?.let { this?.let { it1 -> Skill_Adapter_Template2(it1, it) } }!!
        val layoutManager = LinearLayoutManager(this)
        layoutManager.stackFromEnd = true
        layoutManager.reverseLayout = true

        recyclerskills.layoutManager = layoutManager

        recyclerskills.adapter = skills_adapter2

    }
    private fun setHobbiesRecyler(hobby: List<Hobbies>?) {

        hobbies_adapter = hobby?.let { this?.let { it1 -> Hobbie_Adapter_Template(it1, it, which) } }!!
        val layoutManager = LinearLayoutManager(this)
        layoutManager.stackFromEnd = true
        layoutManager.reverseLayout = true
        recyclerhobby.layoutManager = layoutManager
        recyclerhobby.adapter = hobbies_adapter
    }

    private fun setLangRecyler(lang: List<Languages>?) {
        lang_adapter = lang?.let { this?.let { it1 -> Language_Adapter_Template(it1, it, which) } }!!
        val layoutManager = LinearLayoutManager(this)
        layoutManager.stackFromEnd = true
        layoutManager.reverseLayout = true

        recyclerlang.layoutManager = layoutManager

        recyclerlang.adapter = lang_adapter
    }

    private fun setExpiRecyler(expi: List<Experience>?) {
        expi_adapter = expi?.let { this?.let { it1 -> Experience_Adapter_Template(it1, it) } }!!
        val layoutManager = LinearLayoutManager(this)
        layoutManager.stackFromEnd = true
        layoutManager.reverseLayout = true

        recyclerexpi.layoutManager = layoutManager
        recyclerexpi.adapter = expi_adapter
    }

    private fun seprojectRecyler(project: List<Projects>?) {
        project_adapter = project?.let { this?.let { it1 -> Project_Adapter_Template(it1, it) } }!!
        val layoutManager = LinearLayoutManager(this)
        layoutManager.stackFromEnd = true
        layoutManager.reverseLayout = true

        recylerproject.layoutManager = layoutManager
        recylerproject.adapter = project_adapter
    }

    private fun setAchievementRecyler(project: List<Achievements>?) {
        achi_adapter =
            project?.let { this?.let { it1 -> Achievements_Adapter_Template(it1, it) } }!!
        val layoutManager = LinearLayoutManager(this)
        layoutManager.stackFromEnd = true
        layoutManager.reverseLayout = true

        recylerlytachieve.layoutManager = layoutManager
        recylerlytachieve.adapter = achi_adapter
    }

    ////////////////////////////////////////////////
    fun decodeBase642(input: String?): Bitmap? {
        val decodedByte = Base64.decode(input, 0)
        return BitmapFactory
            .decodeByteArray(decodedByte, 0, decodedByte.size)
    }

}