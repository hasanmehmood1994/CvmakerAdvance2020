package cvmakerr.advance.cvmakepro.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import cvmakerr.advance.cvmakepro.R
import cvmakerr.advance.cvmakepro.Room_Database.Entities.Projects


class Project_Adapter(private val  context: Context, private val project:List<Projects>, val onClicklistene_Recycler:OnClickListener_Recycler, val onClicklistenedelete_Recycler:OnClickListener_RecyclerDelete) :
    RecyclerView.Adapter<Project_Adapter.Project_ViewHolder>() {


    override fun onBindViewHolder(holder: Project_ViewHolder, position: Int) {
        holder.name.text = project?.get(position)?.name
        holder.description.text = project?.get(position)?.description
        holder.duration.text = project?.get(position)?.duration

        holder.deletesingle.setOnClickListener(View.OnClickListener {
            onClicklistenedelete_Recycler.deleteclick_listner(position,project.get(position))
        })
        holder.itemView.setOnClickListener(View.OnClickListener {
            onClicklistene_Recycler.click_listner(position,project.get(position))
        })
    }
    override fun getItemCount(): Int {
        return project?.size!!
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Project_ViewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.item_project,parent,false)
        return Project_ViewHolder(view)
    }

    class Project_ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var name: TextView = itemView.findViewById(R.id.name) as TextView
        var description: TextView = itemView.findViewById(R.id.description) as TextView
        var duration: TextView = itemView.findViewById(R.id.duration) as TextView
        var deletesingle: ImageView =itemView.findViewById(R.id.deletesingle) as ImageView
    }
    interface OnClickListener_Recycler  {
        fun click_listner(position: Int, get:Projects)


    }
    interface OnClickListener_RecyclerDelete  {
        fun deleteclick_listner(position: Int, get:Projects)


    }
}