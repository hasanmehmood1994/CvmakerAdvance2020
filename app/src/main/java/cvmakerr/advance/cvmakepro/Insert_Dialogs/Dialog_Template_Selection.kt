package cvmakerr.advance.cvmakepro.Insert_Dialogs

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import cvmakerr.advance.cvmakepro.Adapters.DataModel
import cvmakerr.advance.cvmakepro.Adapters.testadap
import cvmakerr.advance.cvmakepro.CvTemplates.Design1.CreateMenu
import cvmakerr.advance.cvmakepro.R

class Dialog_Template_Selection(context: Context) : Dialog(context) ,testadap.OnClickListener_Recycler{
    var dataModels: ArrayList<DataModel>? = null
    var listView: RecyclerView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dailog_layout_select)
        listView = findViewById<View>(R.id.listview) as RecyclerView
        funasa()

    }

    @SuppressLint("WrongConstant")
    fun funasa() {
      listView?.layoutManager = LinearLayoutManager(context, LinearLayout.HORIZONTAL, false)
        dataModels = ArrayList()
        dataModels!!.add(DataModel("1", R.layout.temp1_d1))
        dataModels!!.add(DataModel("1", R.layout.temp1_d2))
        dataModels!!.add(DataModel("1", R.layout.temp1_d3))
        dataModels!!.add(DataModel("1", R.layout.temp1_d4))
        dataModels!!.add(DataModel("1", R.layout.temp1_d5))
        dataModels!!.add(DataModel("1", R.layout.temp1_d6))
        dataModels!!.add(DataModel("1", R.layout.temp1_d7))
        dataModels!!.add(DataModel("3", R.layout.temp3_d2))
        dataModels!!.add(DataModel("2", R.layout.temp2_d1))
        adapter2 = testadap(dataModels!!, context,this)
        listView!!.adapter = adapter2

    }

    companion object {
        private var adapter2: testadap? = null
    }

    override fun click_listner(lytid: Int, number: String) {
        val intent2 = Intent(context, CreateMenu::class.java)
        intent2.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        intent2.putExtra("idd", "" + lytid)
        intent2.putExtra("number", "" +number)
        context.startActivity(intent2)
    }
}