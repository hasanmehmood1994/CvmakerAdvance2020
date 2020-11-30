package cvmakerr.advance.cvmakepro.Insert_Dialogs

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.View
import cvmakerr.advance.cvmakepro.R
import cvmakerr.advance.cvmakepro.Room_Database.DataBase.RoomDataBasecv
import cvmakerr.advance.cvmakepro.Room_Database.Dio.HobbiesDao
import cvmakerr.advance.cvmakepro.Room_Database.Entities.Hobbies
import kotlinx.android.synthetic.main.dialog_activity_hobbie.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.coroutines.CoroutineContext


class Dialog_Insert_Hobbie(context: Context, private var which: String, private var hobbie: Hobbies?) : Dialog(context),
    CoroutineScope {

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main
    private var hobbiedao : HobbiesDao? = null
    init {
        val db= RoomDataBasecv.getDatabase(context)
        hobbiedao=db?.hobbiesDao()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_activity_hobbie)

        if (which.equals("old"))
        {
            hobbie_name.setText(""+hobbie?.hobbiename)


            var id=hobbie?.id as Int

            Add.setOnClickListener(View.OnClickListener {


                val hob = Hobbies(id,""+hobbie_name.text.toString())

                setHobbie(hob)


            })
        }
        else{

            Add.setOnClickListener(View.OnClickListener {

                val hob = Hobbies(0,""+hobbie_name.text.toString())

                setHobbie(hob)


            })
        }

        onback.setOnClickListener(View.OnClickListener {
            dismiss()
        })

    }
    fun setHobbie(skills: Hobbies) {
        launch  { setHobbieBG(skills) }
    }

    private suspend fun setHobbieBG(skills: Hobbies) {
        withContext(Dispatchers.IO){
            hobbiedao?.setHobbies(skills)
        }
    }
}