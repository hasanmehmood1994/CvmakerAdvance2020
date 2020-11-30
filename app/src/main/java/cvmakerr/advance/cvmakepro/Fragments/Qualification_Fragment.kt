package cvmakerr.advance.cvmakepro.Fragments

import android.app.ActionBar
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import cvmakerr.advance.cvmakepro.Adapters.Experience_Adapter
import cvmakerr.advance.cvmakepro.Adapters.Qualification_Adapter
import cvmakerr.advance.cvmakepro.Insert_Dialogs.Dialog_Insert_Experience
import cvmakerr.advance.cvmakepro.Insert_Dialogs.Dialog_Insert_Qualification
import cvmakerr.advance.cvmakepro.R
import cvmakerr.advance.cvmakepro.Room_Database.Entities.Experience
import cvmakerr.advance.cvmakepro.Room_Database.Entities.Qualification
import cvmakerr.advance.cvmakepro.Room_Database.ViewModel.ViewModel_Class
import kotlinx.android.synthetic.main.fragment_experience.*
import kotlinx.android.synthetic.main.fragment_experience.imgempty
import kotlinx.android.synthetic.main.qualification_fragment.*

class Qualification_Fragment : Fragment() ,Qualification_Adapter.OnClickListener_Recycler,Qualification_Adapter.OnClickListener_RecyclerDelete{

    private var viewModelClass: ViewModel_Class?=null
    lateinit var adapter: Qualification_Adapter
    companion object {
        fun newInstance() = Qualification_Fragment()
    }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.qualification_fragment, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
       viewModelClass = ViewModelProviders.of(this).get(ViewModel_Class::class.java)

        viewModelClass?.getQualification()?.observe(this, Observer<List<Qualification>> {
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
        floataddbutton.setOnClickListener(View.OnClickListener {

            val _dialogAddtext = activity?.let { it1 -> Dialog_Insert_Qualification(it1,"new",null) }
            _dialogAddtext?.getWindow()?.getAttributes()?.windowAnimations = R.style.DialogAnimation
            _dialogAddtext?.getWindow()?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            _dialogAddtext?.show()
            val window: Window? = _dialogAddtext?.getWindow()
            window?.setLayout(ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.MATCH_PARENT)

        })
    }
    private fun setRecyler(qualification: List<Qualification>?){
        adapter = qualification?.let { activity?.let { it1 -> Qualification_Adapter(it1, it,this,this) } }!!
        val layoutManager = LinearLayoutManager(activity)
        layoutManager.stackFromEnd = true
        layoutManager.reverseLayout=true

        recyler_view.layoutManager = layoutManager

        recyler_view.adapter = adapter

    }

    override fun click_listner(position: Int, get: Qualification) {

            val _dialogAddtext = activity?.let { it1 -> Dialog_Insert_Qualification(it1,"old",get) }
        _dialogAddtext?.getWindow()?.getAttributes()?.windowAnimations = R.style.DialogAnimation
        _dialogAddtext?.getWindow()?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        _dialogAddtext?.show()
        val window: Window? = _dialogAddtext?.getWindow()
        window?.setLayout(ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.MATCH_PARENT)
    }

    override fun deleteclick_listner(position: Int, get: Qualification) {
        viewModelClass?.deleteSingleQualification(get.id)
    }


}