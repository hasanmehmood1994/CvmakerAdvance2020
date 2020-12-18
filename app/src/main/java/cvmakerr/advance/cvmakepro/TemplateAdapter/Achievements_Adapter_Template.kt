package cvmakerr.advance.cvmakepro.TemplateAdapter

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



class Achievements_Adapter_Template(private val  context: Context, private val achievement:List<Achievements>) :
    RecyclerView.Adapter<Achievements_Adapter_Template.Achievement_ViewHolder>() {


    override fun onBindViewHolder(holder: Achievement_ViewHolder, position: Int) {
        holder.name.text = achievement?.get(position)?.name
        holder.description.text = achievement?.get(position)?.description
        holder.duration.text = achievement?.get(position)?.date
        holder.organization.text = achievement?.get(position)?.organization

    }
    override fun getItemCount(): Int {
        return achievement?.size!!
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Achievement_ViewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.item_achievements_temp,parent,false)
        return Achievement_ViewHolder(view)
    }

    class Achievement_ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var name: TextView = itemView.findViewById(R.id.name) as TextView
        var description: TextView = itemView.findViewById(R.id.description) as TextView
        var organization: TextView = itemView.findViewById(R.id.organization) as TextView
        var duration: TextView = itemView.findViewById(R.id.duration) as TextView


    }

}