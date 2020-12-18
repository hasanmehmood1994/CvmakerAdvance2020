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
import cvmakerr.advance.cvmakepro.Adapters.Hobbie_Adapter
import cvmakerr.advance.cvmakepro.Adapters.Skill_Adapter
import cvmakerr.advance.cvmakepro.Insert_Dialogs.Dialog_Insert_Hobbie
import cvmakerr.advance.cvmakepro.Insert_Dialogs.Dialog_Insert_Skill

import cvmakerr.advance.cvmakepro.R
import cvmakerr.advance.cvmakepro.Room_Database.Entities.Hobbies
import cvmakerr.advance.cvmakepro.Room_Database.Entities.Skills
import cvmakerr.advance.cvmakepro.Room_Database.ViewModel.ViewModel_Class
import kotlinx.android.synthetic.main.fragment_experience.*
import kotlinx.android.synthetic.main.fragment_experience.imgempty
import kotlinx.android.synthetic.main.qualification_fragment.*

class Hobbie_Fragment : Fragment(),Hobbie_Adapter.OnClickListener_Recycler,Hobbie_Adapter.OnClickListener_RecyclerDelete {
    private var viewModelClass: ViewModel_Class?=null
    lateinit var adapter: Hobbie_Adapter
    companion object {
        fun newInstance() =Hobbie_Fragment()
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_hobbie, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModelClass = ViewModelProviders.of(this).get(ViewModel_Class::class.java)

        viewModelClass?.getHobbies()?.observe(this, Observer<List<Hobbies>> {
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

            val _dialogAddtext = activity?.let { it1 -> Dialog_Insert_Hobbie(it1,"new",null) }
            _dialogAddtext?.getWindow()?.getAttributes()?.windowAnimations = R.style.DialogAnimation
            _dialogAddtext?.getWindow()?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            _dialogAddtext?.show()
            val window: Window? = _dialogAddtext?.getWindow()
            window?.setLayout(ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.MATCH_PARENT)

        })
    }
    private fun setRecyler(skills: List<Hobbies>?){
        adapter = skills?.let { activity?.let { it1 -> Hobbie_Adapter(it1, it,this,this) } }!!
        val layoutManager = LinearLayoutManager(activity)
        layoutManager.stackFromEnd = true
        layoutManager.reverseLayout=true

        recyler_view.layoutManager = layoutManager

        recyler_view.adapter = adapter

    }


    override fun click_listner(position: Int, get: Hobbies) {

        val _dialogAddtext = activity?.let { it1 -> Dialog_Insert_Hobbie(it1,"old",get) }
        _dialogAddtext?.getWindow()?.getAttributes()?.windowAnimations = R.style.DialogAnimation
        _dialogAddtext?.getWindow()?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        _dialogAddtext?.show()
        val window: Window? = _dialogAddtext?.getWindow()
        window?.setLayout(ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.MATCH_PARENT)
    }

    override fun deleteclick_listner(position: Int, get: Hobbies) {
        viewModelClass?.deleteSingleHobbies(get.id)
    }


}