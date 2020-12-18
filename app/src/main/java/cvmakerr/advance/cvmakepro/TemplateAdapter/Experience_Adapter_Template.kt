package cvmakerr.advance.cvmakepro.TemplateAdapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import cvmakerr.advance.cvmakepro.R
import cvmakerr.advance.cvmakepro.Room_Database.Entities.Experience

class Experience_Adapter_Template(private val  context: Context, private val experience:List< Experience>) :RecyclerView.Adapter<Experience_Adapter_Template.ExperienceViewHolder>() {


    override fun onBindViewHolder(holder: ExperienceViewHolder, position: Int) {
        holder.cname.text = experience?.get(position)?.companyname
        holder.cdeg.text = experience?.get(position)?.designation
        holder.cdu.text = experience?.get(position)?.duration
        holder.cdes.text = experience?.get(position)?.description


    }
    override fun getItemCount(): Int {
        return experience?.size!!
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExperienceViewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.item_experience_temp,parent,false)
        return ExperienceViewHolder(view)
    }

    class ExperienceViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var cname: TextView = itemView.findViewById(R.id.cname) as TextView
        var cdeg: TextView = itemView.findViewById(R.id.cdeg) as TextView
        var cdu: TextView = itemView.findViewById(R.id.cdu) as TextView
        var cdes: TextView = itemView.findViewById(R.id.cdes) as TextView

    }

}