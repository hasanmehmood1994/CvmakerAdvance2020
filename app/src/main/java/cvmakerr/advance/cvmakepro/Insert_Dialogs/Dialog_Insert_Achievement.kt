package cvmakerr.advance.cvmakepro.Insert_Dialogs

import android.app.DatePickerDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Toast
import cvmakerr.advance.cvmakepro.R
import cvmakerr.advance.cvmakepro.Room_Database.DataBase.RoomDataBasecv
import cvmakerr.advance.cvmakepro.Room_Database.Dio.AchievementsDao
import cvmakerr.advance.cvmakepro.Room_Database.Entities.Achievements
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


class Dialog_Insert_Achievement(
    context: Context,
    private var which: String,
    private var achievements: Achievements?
) : Dialog(context),
    CoroutineScope {

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main
    private var achievementsDao: AchievementsDao? = null

    init {
        val db = RoomDataBasecv.getDatabase(context)
        achievementsDao = db?.achievementsDao()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_activity_achievements)

        if (which.equals("old")) {
            name.setText("" + achievements?.name)
            description.setText("" + achievements?.description)
            ed_start.setText("" + achievements?.start)
            ed_end.setText("" + achievements?.end)
            var id = achievements?.id as Int
            Add.setText("Update")
            Add.setOnClickListener(View.OnClickListener {


                val achi = Achievements(
                    id,
                    "" + name.text,
                    "url",
                    "" + ed_start.text + " to " + ed_end.text,
                    "" + description.text,
                    "" + ed_start.text,
                    "" + ed_end.text
                )

                setAchievement(achi)


            })
        } else {
            Add.setText("Add New")
            Add.setOnClickListener(View.OnClickListener {

                val achi = Achievements(
                    0,
                    "" + name.text,
                    "url",
                    "" + ed_start.text + " to " + ed_end.text,
                    "" + description.text,
                    "" + ed_start.text,
                    "" + ed_end.text
                )
                setAchievement(achi)


            })
        }

        onback.setOnClickListener(View.OnClickListener {
            dismiss()
        })
        initilizeCalenderlisters()
    }

    fun setAchievement(achievements1: Achievements) {
        launch { setAchievementBG(achievements1) }
    }

    private suspend fun setAchievementBG(achievements1: Achievements) {
        withContext(Dispatchers.IO) {
            achievementsDao?.setAchivements(achievements1)
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