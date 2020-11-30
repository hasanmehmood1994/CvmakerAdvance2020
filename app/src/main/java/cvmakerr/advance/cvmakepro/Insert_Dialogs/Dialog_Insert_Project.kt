package cvmakerr.advance.cvmakepro.Insert_Dialogs

import android.app.DatePickerDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Toast
import cvmakerr.advance.cvmakepro.R
import cvmakerr.advance.cvmakepro.Room_Database.DataBase.RoomDataBasecv
import cvmakerr.advance.cvmakepro.Room_Database.Dio.ProjectsDao
import cvmakerr.advance.cvmakepro.Room_Database.Entities.Projects
import kotlinx.android.synthetic.main.dialog_activity_experience.*
import kotlinx.android.synthetic.main.dialog_activity_project.*
import kotlinx.android.synthetic.main.dialog_activity_project.Add
import kotlinx.android.synthetic.main.dialog_activity_project.c_end
import kotlinx.android.synthetic.main.dialog_activity_project.c_start
import kotlinx.android.synthetic.main.dialog_activity_project.ed_end
import kotlinx.android.synthetic.main.dialog_activity_project.ed_start
import kotlinx.android.synthetic.main.dialog_activity_project.onback

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.*
import kotlin.coroutines.CoroutineContext


class Dialog_Insert_Project(
    context: Context,
    private var which: String,
    private var project: Projects?
) : Dialog(context),
    CoroutineScope {

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main
    private var projectsDao: ProjectsDao? = null

    init {
        val db = RoomDataBasecv.getDatabase(context)
        projectsDao = db?.projectsDao()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_activity_project)

        if (which.equals("old")) {
            name.setText("" + project?.name)
            description.setText("" + project?.description)
            ed_start.setText("" + project?.start)
            ed_end.setText("" + project?.end)
            var id = project?.id as Int

            Add.setText("Update")
            Add.setOnClickListener(View.OnClickListener {
                Toast.makeText(context, "Updated", Toast.LENGTH_SHORT)

                val pro = Projects(
                    id,
                    "" + name.text,
                    "url",
                    "" + ed_start.text + " to " + ed_end.text,
                    "" + description.text,
                    ""+ ed_start.text ,
                    ""+ ed_end.text,
                )

                setProject(pro)


            })
        } else {
            Add.setText("Add New")
            Add.setOnClickListener(View.OnClickListener {
                Toast.makeText(context, "Added", Toast.LENGTH_SHORT)
                val pro = Projects(
                    0,
                    "" + name.text,
                    "url",
                    "" + ed_start.text + " to " + ed_end.text,
                    "" + description.text,
                    ""+ ed_start.text ,
                    ""+ ed_end.text,
                )
                setProject(pro)


            })
        }

        onback.setOnClickListener(View.OnClickListener {
            dismiss()
        })
        initilizeCalenderlisters()
    }

    fun setProject(project: Projects) {
        launch { setProjectBG(project) }
    }

    private suspend fun setProjectBG(project: Projects) {
        withContext(Dispatchers.IO) {
            projectsDao?.setProjects(project)
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