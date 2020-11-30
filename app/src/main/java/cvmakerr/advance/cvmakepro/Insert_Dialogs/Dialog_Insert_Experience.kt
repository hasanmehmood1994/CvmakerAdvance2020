package cvmakerr.advance.cvmakepro.Insert_Dialogs

import android.app.DatePickerDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import cvmakerr.advance.cvmakepro.R
import cvmakerr.advance.cvmakepro.Room_Database.DataBase.RoomDataBasecv
import cvmakerr.advance.cvmakepro.Room_Database.Dio.ExperienceDao
import cvmakerr.advance.cvmakepro.Room_Database.Entities.Experience
import kotlinx.android.synthetic.main.dialog_activity_experience.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.*
import kotlin.coroutines.CoroutineContext

class Dialog_Insert_Experience(
    context: Context,
    private var which: String,
    private var experience: Experience?
) : Dialog(context), CoroutineScope {

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main
    private var experienceDao: ExperienceDao? = null

    init {
        val db = RoomDataBasecv.getDatabase(context)
        experienceDao = db?.experienceDao()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_activity_experience)

        if (which.equals("old")) {
            Add.setText("Update")
            ed_cname.setText("" + experience?.companyname)
            ed_cdeg.setText("" + experience?.designation)
            ed_start.setText("" + experience?.start)
            ed_end.setText("" + experience?.end)
            ed_cdes.setText("" + experience?.description)
            var id = experience?.id as Int

            Add.setOnClickListener(View.OnClickListener {


                val exper = Experience(
                    id,
                    "" + ed_cname.text,
                    "" + ed_cdeg.text,
                    "" + ed_start.text + " to " + ed_end.text,
                    "" + ed_cdes.text,
                    ""
                ,""
                )
                // experienceViewModel?.setExperience(exper)
                setExperience(exper)
                Toast.makeText(context, "Update", Toast.LENGTH_SHORT)

            })
        } else {
            Add.setText("Add New")
            Add.setOnClickListener(View.OnClickListener {

                val exper = Experience(
                    0,
                    "" + ed_cname.text,
                    "" + ed_cdeg.text,
                    "" + ed_start.text + "  to  " +  ed_end.text,
                    "" + ed_cdes.text,
                    ""+ ed_start.text
                    ,""+ ed_end.text
                )
                // experienceViewModel?.setExperience(exper)
                setExperience(exper)

                Toast.makeText(context, "Added", Toast.LENGTH_SHORT)
            })
        }
        initilizeCalenderlisters()
        onback.setOnClickListener(View.OnClickListener {
            dismiss()
        })

    }

    fun setExperience(experience: Experience) {
        launch { setExperienceBG(experience) }
    }

    private suspend fun setExperienceBG(experience: Experience) {
        withContext(Dispatchers.IO) {
            experienceDao?.setExperience(experience)
        }
    }

    fun initilizeCalenderlisters() {

        ///start e

        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)
        c_start.setOnClickListener(View.OnClickListener {

            Toast.makeText(context, "asasas", Toast.LENGTH_SHORT)
            val dpd = context?.let {
                DatePickerDialog(
                    it,
                    DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
                        // Display Selected date in TextView
                        ed_start.setText("" + dayOfMonth + "/" + monthOfYear + "/" + year)

                    },
                    year,
                    month,
                    day
                )
            }
            if (dpd != null) {
                dpd.show()
            }

        })

        ////end


        c_end.setOnClickListener(View.OnClickListener {

            Toast.makeText(context, "asasas", Toast.LENGTH_SHORT)
            val dpd = context?.let {
                DatePickerDialog(
                    it,
                    DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
                        // Display Selected date in TextView
                        ed_end.setText("" + dayOfMonth + "/" + monthOfYear + "/" + year)

                    },
                    year,
                    month,
                    day
                )
            }
            if (dpd != null) {
                dpd.show()
            }

        })
    }

}