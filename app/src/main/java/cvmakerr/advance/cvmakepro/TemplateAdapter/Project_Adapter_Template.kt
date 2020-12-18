package cvmakerr.advance.cvmakepro.TemplateAdapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import cvmakerr.advance.cvmakepro.R
import cvmakerr.advance.cvmakepro.Room_Database.Entities.Projects


class Project_Adapter_Template(private val  context: Context, private val project:List<Projects>) :
    RecyclerView.Adapter<Project_Adapter_Template.Project_ViewHolder>() {


    override fun onBindViewHolder(holder: Project_ViewHolder, position: Int) {
        holder.name.text = project?.get(position)?.name
        holder.description.text = project?.get(position)?.description
        holder.duration.text = project?.get(position)?.duration


    }
    override fun getItemCount(): Int {
        return project?.size!!
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Project_ViewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.item_project_temp,parent,false)
        return Project_ViewHolder(view)
    }

    class Project_ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var name: TextView = itemView.findViewById(R.id.name) as TextView
        var description: TextView = itemView.findViewById(R.id.description) as TextView
        var duration: TextView = itemView.findViewById(R.id.duration) as TextView

    }

}