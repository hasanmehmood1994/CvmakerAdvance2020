package cvmakerr.advance.cvmakepro.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import cvmakerr.advance.cvmakepro.R
import cvmakerr.advance.cvmakepro.Room_Database.Entities.Achievements
import cvmakerr.advance.cvmakepro.Room_Database.Entities.Projects



class Achievements_Adapter(private val  context: Context, private val achievement:List<Achievements>, val onClicklistene_Recycler:OnClickListener_Recycler, val onClicklistenedelete_Recycler:OnClickListener_RecyclerDelete) :
    RecyclerView.Adapter<Achievements_Adapter.Achievement_ViewHolder>() {


    override fun onBindViewHolder(holder: Achievement_ViewHolder, position: Int) {
        holder.name.text = achievement?.get(position)?.name
        holder.description.text = achievement?.get(position)?.description
        holder.duration.text = achievement?.get(position)?.date
        holder.organization.text = achievement?.get(position)?.organization
        holder.deletesingle.setOnClickListener(View.OnClickListener {
            onClicklistenedelete_Recycler.deleteclick_listner(position,achievement.get(position))
        })
        holder.itemView.setOnClickListener(View.OnClickListener {
            onClicklistene_Recycler.click_listner(position,achievement.get(position))
        })
    }
    override fun getItemCount(): Int {
        return achievement?.size!!
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Achievement_ViewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.item_achievements,parent,false)
        return Achievement_ViewHolder(view)
    }

    class Achievement_ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var name: TextView = itemView.findViewById(R.id.name) as TextView
        var description: TextView = itemView.findViewById(R.id.description) as TextView
        var organization: TextView = itemView.findViewById(R.id.organization) as TextView
        var duration: TextView = itemView.findViewById(R.id.duration) as TextView

        var deletesingle: ImageView =itemView.findViewById(R.id.deletesingle) as ImageView
    }
    interface OnClickListener_Recycler  {
        fun click_listner(position: Int, get: Achievements)


    }
    interface OnClickListener_RecyclerDelete  {
        fun deleteclick_listner(position: Int, get: Achievements)


    }
}