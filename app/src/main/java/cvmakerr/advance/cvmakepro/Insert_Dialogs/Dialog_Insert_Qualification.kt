package cvmakerr.advance.cvmakepro.Insert_Dialogs

import android.app.DatePickerDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Toast
import cvmakerr.advance.cvmakepro.R
import cvmakerr.advance.cvmakepro.Room_Database.DataBase.RoomDataBasecv
import cvmakerr.advance.cvmakepro.Room_Database.Dio.QualificationDao
import cvmakerr.advance.cvmakepro.Room_Database.Entities.Qualification
import kotlinx.android.synthetic.main.dialog_activity_experience.*
import kotlinx.android.synthetic.main.dialog_activity_qualification.*
import kotlinx.android.synthetic.main.dialog_activity_qualification.Add
import kotlinx.android.synthetic.main.dialog_activity_qualification.c_end
import kotlinx.android.synthetic.main.dialog_activity_qualification.c_start
import kotlinx.android.synthetic.main.dialog_activity_qualification.ed_end
import kotlinx.android.synthetic.main.dialog_activity_qualification.ed_start
import kotlinx.android.synthetic.main.dialog_activity_qualification.onback
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.*
import kotlin.coroutines.CoroutineContext


class Dialog_Insert_Qualification(
    context: Context,
    private var which: String,
    private var qualification: Qualification?
) : Dialog(context),
    CoroutineScope {

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main
    private var qualificationDao: QualificationDao? = null

    init {
        val db = RoomDataBasecv.getDatabase(context)
        qualificationDao = db?.qualificationDao()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_activity_qualification)

        if (which.equals("old")) {
            Add.setText("Update")
            ed_title.setText("" + qualification?.degreename)
            ed_institute.setText("" + qualification?.institute)
            ed_start.setText("" + qualification?.startdate)
            ed_end.setText("" + qualification?.endtdate)
            var id = qualification?.id as Int
            Add.setOnClickListener(View.OnClickListener {


                val qua = Qualification(
                    id,
                    "" + ed_title.text,
                    "" + ed_institute.text,
                    "" + ed_start.text ,
                    "" + ed_end.text,
                    ""+ ed_start.text + "  to  " + ed_end.text,
                )

                setQualification(qua)


            })
        } else {
            Add.setText("Add New")
            Add.setOnClickListener(View.OnClickListener {

                val qua = Qualification(
                    0,
                    "" + ed_title.text,
                    "" + ed_institute.text,
                    "" + ed_start.text ,
                    "" + ed_end.text,
                    ""+ ed_start.text + "  to  " + ed_end.text,
                )
                setQualification(qua)


            })
        }

        onback.setOnClickListener(View.OnClickListener {
            dismiss()
        })
        initilizeCalenderlisters()
    }

    fun setQualification(qualification: Qualification) {
        launch { setQualificationBG(qualification) }
    }

    private suspend fun setQualificationBG(qualification: Qualification) {
        withContext(Dispatchers.IO) {
            qualificationDao?.setQualification(qualification)
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