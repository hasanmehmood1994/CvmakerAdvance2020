package cvmakerr.advance.cvmakepro.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import cvmakerr.advance.cvmakepro.R
import cvmakerr.advance.cvmakepro.Room_Database.Entities.Qualification
import cvmakerr.advance.cvmakepro.Room_Database.Entities.Skills


class  Skill_Adapter(private val  context: Context, private val skill:List<Skills>, val onClicklistene_Recycler:OnClickListener_Recycler, val onClicklistenedelete_Recycler:OnClickListener_RecyclerDelete) :
    RecyclerView.Adapter<Skill_Adapter.Skill_ViewHolder>() {


    override fun onBindViewHolder(holder: Skill_ViewHolder, position: Int) {
        holder.skillname.text = skill?.get(position)?.skillname
        holder.skillpercentage.text = skill?.get(position)?.skillpercetage

        holder.deletesingle.setOnClickListener(View.OnClickListener {
            onClicklistenedelete_Recycler.deleteclick_listner(position,skill.get(position))
        })
        holder.itemView.setOnClickListener(View.OnClickListener {
            onClicklistene_Recycler.click_listner(position,skill.get(position))
        })
    }
    override fun getItemCount(): Int {
        return skill?.size!!
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Skill_ViewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.item_skill,parent,false)
        return Skill_ViewHolder(view)
    }

    class Skill_ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var skillname: TextView = itemView.findViewById(R.id.skillname) as TextView
        var skillpercentage: TextView = itemView.findViewById(R.id.skillpercentage) as TextView
        var deletesingle: ImageView =itemView.findViewById(R.id.deletesingle) as ImageView
    }
    interface OnClickListener_Recycler  {
        fun click_listner(position: Int, get: Skills)


    }
    interface OnClickListener_RecyclerDelete  {
        fun deleteclick_listner(position: Int, get:Skills)


    }
}
