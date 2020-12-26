package cvmakerr.advance.cvmakepro.CvTemplates.Design1

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.*
import android.graphics.pdf.PdfDocument
import android.graphics.pdf.PdfDocument.PageInfo
import android.media.MediaScannerConnection
import android.net.Uri
import android.os.*
import android.text.format.DateFormat
import android.util.Base64
import android.util.DisplayMetrics
import android.util.Log
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.app.ActivityCompat
import androidx.core.content.FileProvider
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import cvmakerr.advance.cvmakepro.R
import cvmakerr.advance.cvmakepro.Room_Database.Entities.*
import cvmakerr.advance.cvmakepro.Room_Database.ViewModel.ViewModel_Class
import cvmakerr.advance.cvmakepro.Shared_Prefrence.SharedPrefMain
import cvmakerr.advance.cvmakepro.TemplateAdapter.*
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.util.*

class CreateMenu2 : AppCompatActivity() {
    private var layout_to_load: Int = 0
    private var viewModelClass: ViewModel_Class? = null

    /////
    lateinit var qualification_adapter: Qualification_Adapter_Template
    lateinit var skills_adapter3: Skill_Adapter_Template3
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
    private lateinit var savecard: CardView
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
           layout_to_load = bundle["idd"].toString().toInt()
            which = bundle["number"].toString()
            setContentView(layout_to_load)

        }
//

        createfolder()
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
    private fun takeScreenshot() {
        val now = Date()
        DateFormat.format("yyyy-MM-dd_hh:mm:ss", now)
        try {
            // image naming and path  to include sd card  appending name you choose for file
            val mPath = Environment.getExternalStorageDirectory()
                .toString() + "/cvimages/" + now + ".jpg"
            val mPath2 = Environment.getExternalStorageDirectory()
                .toString() + "/cvpdfs/" ;
            // create bitmap screen capture
            val v1 = window.decorView.rootView
            v1.isDrawingCacheEnabled = true
            val bitmap = Bitmap.createBitmap(v1.drawingCache)
            v1.isDrawingCacheEnabled = false
            val imageFile = File(mPath)
            val outputStream = FileOutputStream(imageFile)
            val quality = 100
            bitmap.compress(Bitmap.CompressFormat.JPEG, quality, outputStream)
            outputStream.flush()
            outputStream.close()
            refreshGallery(mPath)

            // Create a PdfDocument with a page of the same size as the image
            val document: PdfDocument = PdfDocument()
            val pageInfo: PdfDocument.PageInfo  = PdfDocument.PageInfo.Builder(
                bitmap.width,
                bitmap.height,
                1
            ).create()
            val page: PdfDocument.Page  = document.startPage(pageInfo)

            // Draw the bitmap onto the page
            val canvas: Canvas = page.canvas
            canvas.drawBitmap(bitmap, 0f, 0f, null)
            document.finishPage(page)

            // Write the PDF file to a file
            val directoryPath: String  = android.os.Environment.getExternalStorageDirectory().toString()
            document.writeTo(
                FileOutputStream(
                    mPath2
                            + "/" + now + ".pdf"
                )
            )
            document.close()
            Toast.makeText(this, "Cv Saved In Gallery", Toast.LENGTH_SHORT).show()
        } catch (e: Throwable) {
            // Several error may come out with file handling or DOM
            e.printStackTrace()
        }
    }
    private fun refreshGallery(file: String) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            val mediaScanIntent = Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE)
            val f1 =
                File("file://" + Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES))
            val contentUri = Uri.fromFile(f1)
            mediaScanIntent.data = contentUri
            sendBroadcast(mediaScanIntent)
        } else {
            sendBroadcast(
                Intent(
                    Intent.ACTION_MEDIA_MOUNTED,
                    Uri.parse("file://" + Environment.getExternalStorageDirectory())
                )
            )
        }
        sendBroadcast(Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE, Uri.fromFile(File(file))))
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
        savecard= findViewById(R.id.savecard)
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
                } else if (which == "2") {
                    this.setSkillsRecyler3(it)
                } else if (which == "3") {
                    this.setSkillsRecyler3(it)
                } else {

                }

            } else {

                if (which == "1") {
                    this.setSkillsRecyler(it)
                } else if (which == "2") {
                    this.setSkillsRecyler2(it)
                } else if (which == "3") {
                    this.setSkillsRecyler3(it)
                } else {

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
    private fun setSkillsRecyler3(skills: List<Skills>?) {
        skills_adapter3 = skills?.let { this?.let { it1 -> Skill_Adapter_Template3(it1, it) } }!!
        val layoutManager = LinearLayoutManager(this)
        layoutManager.stackFromEnd = true
        layoutManager.reverseLayout = true

        recyclerskills.layoutManager = layoutManager

        recyclerskills.adapter = skills_adapter3

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
////////////////////////////////////////////////////



    fun onclicksavecvimgae(view: View)
    {
        Savecvpermission()

     //
     //   takeScreenshot()
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
///////////////////////


    private lateinit var bitmap: Bitmap

    var dirpath: String? = null
    fun layoutToImage() {
        // get view group using reference
        val constraintLayout: ConstraintLayout = findViewById(R.id.mainlyt) as ConstraintLayout
        // convert view group to bitmap
        constraintLayout.setDrawingCacheEnabled(true)
        constraintLayout.buildDrawingCache()
        val bm: Bitmap = constraintLayout.getDrawingCache()
        val share = Intent(Intent.ACTION_SEND)
        share.type = "image/jpeg"
        val bytes = ByteArrayOutputStream()
        bm.compress(Bitmap.CompressFormat.JPEG, 100, bytes)
        val f = File(
            Environment.getExternalStorageDirectory().toString() + File.separator + "image.jpg"
        )
        try {
            f.createNewFile()
            val fo = FileOutputStream(f)
            fo.write(bytes.toByteArray())
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    private fun Savecvpermission() {
        val storageWritePermissionGranted =
            ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) ===
                    PackageManager.PERMISSION_GRANTED
        if (!storageWritePermissionGranted) {
            ActivityCompat.requestPermissions(this, SAVE_PERMISSION, REQUEST_CODE_SAVE)
        } else {

            cvLayout = findViewById(R.id.mainlyt)
            Handler().postDelayed({
                savecv();
                Savecvpermission2()

            }, 200)

            Handler().postDelayed({
                savecard.visibility = View.VISIBLE;
            }, 1000)
        }
    }

    private fun Savecvpermission2() {

        val storageWritePermissionGranted =
            ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) ===
                    PackageManager.PERMISSION_GRANTED
        if (!storageWritePermissionGranted) {
            ActivityCompat.requestPermissions(this, SAVE_PERMISSION, REQUEST_CODE_SAVE)
        } else {

            val direct =
                File(Environment.getExternalStorageDirectory().toString() + "/cvpdfs")
            if (!direct.exists()) {
                if (direct.mkdir());
            }
            createPdf()

        }
    }

    private val SAVE_PERMISSION = arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE)
    private val REQUEST_CODE_SAVE = 44
    var cvLayout: ConstraintLayout? = null
    private fun savecv() {

        savecard.visibility=View.GONE;
        cvLayout!!.isDrawingCacheEnabled = true
        cvLayout!!.buildDrawingCache()
        val full = cvLayout!!.drawingCache
        if (Environment.getExternalStorageState().equals("mounted", ignoreCase = true)) {
            val imageFolder = File(Environment.getExternalStorageDirectory(), "cvimages")
            imageFolder.mkdirs()
            var out: FileOutputStream? = null
            val imageFile = File(imageFolder, System.currentTimeMillis().toString() + ".png")
            try {
                out = FileOutputStream(imageFile)
                full.compress(Bitmap.CompressFormat.JPEG, 100, out)
                out.flush()
                out.close()
            } catch (e: IOException) {
                e.printStackTrace()
            } finally {
                out = null
                MediaScannerConnection.scanFile(this, arrayOf(imageFile.absolutePath), null, null)
            }
        }
        cvLayout!!.destroyDrawingCache()
        cvLayout!!.isDrawingCacheEnabled = false

        Toast.makeText(this, "Saved to cvimages folder in Gallery!", Toast.LENGTH_LONG).show()
        historyofintents("cv")

    }
    fun historyofintents(cname: String?) {

        cvLayout!!.buildDrawingCache()
        val bmap = cvLayout!!.drawingCache
        viewModelClass?.setHistory(History(0, profileImage(bmap)))
        try {
            saveImage(bmap)

//            val intent = Intent(Intent.ACTION_SEND)
//            intent.type = "image/png"
//            intent.putExtra(Intent.EXTRA_STREAM, bmap)
         //   startActivity(Intent.createChooser(intent, "Share"))
        }
        catch (ex: Exception)
        {
            Toast.makeText(this, "" + ex, Toast.LENGTH_LONG).show()
        }



    }
    private fun saveImage(image: Bitmap): Uri? {
        //TODO - Should be processed in another thread
        val imagesFolder = File(cacheDir, "images")
        var uri: Uri? = null
        try {
            imagesFolder.mkdirs()
            val file = File(imagesFolder, "shared_image.jpg")
            val stream = FileOutputStream(file)
            image.compress(Bitmap.CompressFormat.JPEG, 100, stream)
            stream.flush()
            stream.close()
            uri = FileProvider.getUriForFile(this, "cvmakerr.advance.cvmakepro", file)
            val intent = Intent(Intent.ACTION_SEND)
            intent.putExtra(Intent.EXTRA_STREAM, uri)
            intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
            intent.type = "image/png"
            startActivity(intent)
        } catch (e: IOException) {
            Log.d("TAG", "IOException while trying to write file for sharing: " + e.message)
        }
        return uri
    }
    private fun profileImage(b: Bitmap): ByteArray? {
        val bos = ByteArrayOutputStream()
        b.compress(Bitmap.CompressFormat.JPEG, 100, bos)
        return bos.toByteArray()
    }

    private fun createPdf() {
        bitmap = loadBitmapFromView(cvLayout, cvLayout!!.width, cvLayout!!.height)
        val wm = getSystemService(WINDOW_SERVICE) as WindowManager
        //  Display display = wm.getDefaultDisplay();
        val displaymetrics = DisplayMetrics()
        this.windowManager.defaultDisplay.getMetrics(displaymetrics)
        val hight = displaymetrics.heightPixels.toFloat()
        val width = displaymetrics.widthPixels.toFloat()
        val convertHighet = hight.toInt()
        val convertWidth = width.toInt()

//        Resources mResources = getResources();
//        Bitmap bitmap = BitmapFactory.decodeResource(mResources, R.drawable.screenshot);
        val document = PdfDocument()
        val pageInfo = PageInfo.Builder(convertWidth, convertHighet, 1).create()
        val page = document.startPage(pageInfo)
        val canvas = page.canvas
        val paint = Paint()
        canvas.drawPaint(paint)
        bitmap = Bitmap.createScaledBitmap(bitmap, convertWidth, convertHighet, true)
        paint.color = Color.BLUE
        canvas.drawBitmap(bitmap, 0f, 0f, null)
        document.finishPage(page)

        // write the document content
        val d = Date()
        val s = DateFormat.format("hh:mm:ss yyyy:MM:dd", d.time)

        // File direct = new File(Environment.getExternalStorageDirectory()+"/my cvpdf folder/my cv"+s+".pdf");

        // targetPdf = "/sdcard/bangyafolder/"+"my cv "+s+".pdf";
        val filePath: File
        filePath = File(
            Environment.getExternalStorageDirectory()
                .toString() + "/cvpdfs/my cv" + s + ".pdf"
        )
        try {
            document.writeTo(FileOutputStream(filePath))
            Toast.makeText(this, "PDF is created!!!", Toast.LENGTH_SHORT).show()
            object : CountDownTimer(1000, 1000) {
                override fun onFinish() {
                    Toast.makeText(
                        this@CreateMenu2,
                        "PDF is saved in directory  'cvpdfs' folder !!",
                        Toast.LENGTH_SHORT
                    ).show()
                }

                override fun onTick(millisUntilFinished: Long) {
                    //      Toast.makeText(CreateCV2.this, "saving!!!", Toast.LENGTH_SHORT).show();
                }
            }.start()
        } catch (e: IOException) {
            e.printStackTrace()
            Toast.makeText(this, "Something wrong: $e", Toast.LENGTH_LONG).show()
        }


        document.close()


        //historyofintents("cv")
    }






    fun loadBitmapFromView(v: View?, width: Int, height: Int): Bitmap {
        val b = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)
        val c = Canvas(b)
        v!!.draw(c)
        return b
    }


    fun funsaveaspdf(view: View?) {
        Savecvpermission2()

    }


}