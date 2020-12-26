package cvmakerr.advance.cvmakepro.Insert_Dialogs

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.SeekBar
import android.widget.SeekBar.OnSeekBarChangeListener
import cvmakerr.advance.cvmakepro.R
import cvmakerr.advance.cvmakepro.Room_Database.DataBase.RoomDataBasecv
import cvmakerr.advance.cvmakepro.Room_Database.Dio.SkillsDao
import cvmakerr.advance.cvmakepro.Room_Database.Entities.Skills
import kotlinx.android.synthetic.main.dialog_activity_experience.Add
import kotlinx.android.synthetic.main.dialog_activity_experience.onback
import kotlinx.android.synthetic.main.dialog_activity_skill.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.coroutines.CoroutineContext


class Dialog_Insert_Skill(
    context: Context,
    private var which: String,
    private var skills: Skills?
) : Dialog(
    context
),
    CoroutineScope {
    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main
    private var skillsDao: SkillsDao? = null

    init {
        val db = RoomDataBasecv.getDatabase(context)
        skillsDao = db?.skillsDao()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_activity_skill)

        if (which.equals("old")) {
            skill_name.setText("" + skills?.skillname)
            intprogress.setText("" + skills?.skillpercetage)
            skills?.intpercetage?.let { seekBar.setProgress(it) }
            var id = skills?.id as Int
            Add.setText("Update")
            Add.setOnClickListener(View.OnClickListener {


                val ski = Skills(
                    id,
                    "" + skill_name.text.toString(),
                    "" + seekBar.progress ,
                    seekBar.progress
                )
                // experienceViewModel?.setExperience(exper)
                setSkills(ski)


            })
        } else {
            Add.setText("Add New")
            Add.setOnClickListener(View.OnClickListener {

                val ski = Skills(
                    0,
                    "" + skill_name.text.toString(),
                    "" + seekBar.progress ,
                    seekBar.progress
                )

                setSkills(ski)


            })
        }

        onback.setOnClickListener(View.OnClickListener {
            dismiss()
        })
        seekBar.setOnSeekBarChangeListener(object : OnSeekBarChangeListener {
            var progressChangedValue = 0
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                progressChangedValue = progress
                intprogress.setText("" + progress + " %")
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {
                // TODO Auto-generated method stub
            }

            override fun onStopTrackingTouch(seekBar: SeekBar) {

            }
        })

    }

    fun setSkills(skills: Skills) {
        launch { setSkillsBG(skills) }
    }

    private suspend fun setSkillsBG(skills: Skills) {
        withContext(Dispatchers.IO) {
            skillsDao?.setSkills(skills)
        }
    }
}