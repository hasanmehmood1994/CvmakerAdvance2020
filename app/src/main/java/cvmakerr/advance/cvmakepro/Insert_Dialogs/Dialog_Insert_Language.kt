package cvmakerr.advance.cvmakepro.Insert_Dialogs

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.View
import cvmakerr.advance.cvmakepro.R
import cvmakerr.advance.cvmakepro.Room_Database.DataBase.RoomDataBasecv

import cvmakerr.advance.cvmakepro.Room_Database.Dio.LanguagesDao

import cvmakerr.advance.cvmakepro.Room_Database.Entities.Languages


import kotlinx.android.synthetic.main.dialog_activity_language.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.intellij.lang.annotations.Language
import kotlin.coroutines.CoroutineContext



class Dialog_Insert_Language(context: Context, private var which: String, private var language: Languages?) : Dialog(context),
    CoroutineScope {

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main
    private var languagesDao: LanguagesDao? = null
    init {
        val db= RoomDataBasecv.getDatabase(context)
        languagesDao=db?.languagesDao()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_activity_language)

        if (which.equals("old"))
        {
           lang_name.setText(""+language?.languagename)


            var id=language?.id as Int

            Add.setOnClickListener(View.OnClickListener {


                val hob =Languages(id,""+lang_name.text.toString())

                setLanguage(hob)


            })
        }
        else{

            Add.setOnClickListener(View.OnClickListener {

                val hob = Languages(0,""+lang_name.text.toString())

                setLanguage(hob)


            })
        }

        onback.setOnClickListener(View.OnClickListener {
            dismiss()
        })

    }
    fun setLanguage(language: Languages) {
        launch  { setLanguageBG(language) }
    }

    private suspend fun setLanguageBG(language:Languages) {
        withContext(Dispatchers.IO){
            languagesDao?.setLanguages(language)
        }
    }
}