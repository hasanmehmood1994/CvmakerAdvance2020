package cvmakerr.advance.cvmakepro.Fragments

import android.app.ActionBar
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import cvmakerr.advance.cvmakepro.Adapters.Experience_Adapter
import cvmakerr.advance.cvmakepro.Insert_Dialogs.Dialog_Insert_Experience
import cvmakerr.advance.cvmakepro.R
import cvmakerr.advance.cvmakepro.Room_Database.ViewModel.ViewModel_Class
import cvmakerr.advance.cvmakepro.Room_Database.Entities.Experience
import kotlinx.android.synthetic.main.fragment_experience.*

class Experience_Fragment : Fragment() ,Experience_Adapter.OnClickListener_Recycler,Experience_Adapter.OnClickListener_RecyclerDelete{

    private var Viewmodelclass: ViewModel_Class?=null
    lateinit var adapter: Experience_Adapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_experience, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Viewmodelclass = ViewModelProviders.of(this).get(ViewModel_Class::class.java)

        Viewmodelclass?.getExperience()?.observe(this, Observer<List<Experience>> {
          if (it.size==0)
          {
              Log.e("size","zero")
              imgempty.visibility=View.VISIBLE
              this.setRecyler(it)
          }
            else
          {

              Log.e("size",""+it.size)
              this.setRecyler(it)
              imgempty.visibility=View.GONE
          }

        })
        floataddexperience.setOnClickListener(View.OnClickListener {

            val _dialogAddtext = activity?.let { it1 -> Dialog_Insert_Experience(it1,"new",null) }
            _dialogAddtext?.getWindow()?.getAttributes()?.windowAnimations = R.style.DialogAnimation
            _dialogAddtext?.getWindow()?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            _dialogAddtext?.show()
            val window: Window? = _dialogAddtext?.getWindow()
            window?.setLayout(ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.MATCH_PARENT)

        })
    }
    private fun setRecyler(experience: List<Experience>?){
        adapter = experience?.let { activity?.let { it1 -> Experience_Adapter(it1, it,this,this) } }!!
        val layoutManager = LinearLayoutManager(activity)
        layoutManager.stackFromEnd = true
        layoutManager.reverseLayout=true

        experience_recyler.layoutManager = layoutManager

        experience_recyler.adapter = adapter

    }



    override fun deleteclick_listner(position: Int, get: Experience) {
Log.e("aa",""+get.companyname)
        Viewmodelclass?.deleteSingleExperience(get.id)
    }

    override fun click_listner(position: Int, get: Experience) {
        Log.e("aa",""+get.companyname)
        val _dialogAddtext = activity?.let { it1 -> Dialog_Insert_Experience(it1,"old",get) }
        _dialogAddtext?.getWindow()?.getAttributes()?.windowAnimations = R.style.DialogAnimation
        _dialogAddtext?.getWindow()?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        _dialogAddtext?.show()
        val window: Window? = _dialogAddtext?.getWindow()
        window?.setLayout(ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.MATCH_PARENT)
    }
}