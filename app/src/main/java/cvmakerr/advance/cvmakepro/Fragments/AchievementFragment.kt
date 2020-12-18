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
import cvmakerr.advance.cvmakepro.Adapters.Achievements_Adapter
import cvmakerr.advance.cvmakepro.Adapters.Project_Adapter
import cvmakerr.advance.cvmakepro.Insert_Dialogs.Dialog_Insert_Achievement
import cvmakerr.advance.cvmakepro.Insert_Dialogs.Dialog_Insert_Project
import cvmakerr.advance.cvmakepro.R
import cvmakerr.advance.cvmakepro.Room_Database.Entities.Achievements

import cvmakerr.advance.cvmakepro.Room_Database.ViewModel.ViewModel_Class

import kotlinx.android.synthetic.main.fragment_experience.imgempty
import kotlinx.android.synthetic.main.qualification_fragment.*

class AchievementFragment : Fragment(),Achievements_Adapter.OnClickListener_Recycler,Achievements_Adapter.OnClickListener_RecyclerDelete {
    private var viewModelClass: ViewModel_Class?=null
    lateinit var adapter: Achievements_Adapter
    companion object {
        fun newInstance() = AchievementFragment()
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_achievement, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModelClass = ViewModelProviders.of(this).get(ViewModel_Class::class.java)

        viewModelClass?.getAchievements()?.observe(this, Observer<List<Achievements>> {
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

            val _dialogAddtext = activity?.let { it1 -> Dialog_Insert_Achievement(it1,"new",null) }
            _dialogAddtext?.getWindow()?.getAttributes()?.windowAnimations = R.style.DialogAnimation
            _dialogAddtext?.getWindow()?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            _dialogAddtext?.show()
            val window: Window? = _dialogAddtext?.getWindow()
            window?.setLayout(ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.MATCH_PARENT)

        })
    }
    private fun setRecyler(projects: List<Achievements>?){
        adapter = projects?.let { activity?.let { it1 -> Achievements_Adapter(it1, it,this,this) } }!!
        val layoutManager = LinearLayoutManager(activity)
        layoutManager.stackFromEnd = true
        layoutManager.reverseLayout=true

        recyler_view.layoutManager = layoutManager

        recyler_view.adapter = adapter

    }

    override fun click_listner(position: Int, get: Achievements) {

        val _dialogAddtext = activity?.let { it1 -> Dialog_Insert_Achievement(it1,"old",get) }
        _dialogAddtext?.getWindow()?.getAttributes()?.windowAnimations = R.style.DialogAnimation
        _dialogAddtext?.getWindow()?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        _dialogAddtext?.show()
        val window: Window? = _dialogAddtext?.getWindow()
        window?.setLayout(ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.MATCH_PARENT)
    }

    override fun deleteclick_listner(position: Int, get: Achievements) {
        viewModelClass?.deleteSingleAchievements(get.id)
    }


}