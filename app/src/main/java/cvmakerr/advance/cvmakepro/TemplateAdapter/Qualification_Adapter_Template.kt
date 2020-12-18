package cvmakerr.advance.cvmakepro.TemplateAdapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import cvmakerr.advance.cvmakepro.R

import cvmakerr.advance.cvmakepro.Room_Database.Entities.Qualification


class Qualification_Adapter_Template(private val  context: Context, private val qualification:List<Qualification>) :
    RecyclerView.Adapter<Qualification_Adapter_Template.Qualification_ViewHolder>() {



    override fun onBindViewHolder(holder: Qualification_ViewHolder, position: Int) {
        holder.title.text = qualification?.get(position)?.degreename
        holder.name.text = qualification?.get(position)?.institute
        holder.duration.text = qualification?.get(position)?.date



    }
    override fun getItemCount(): Int {
        return qualification?.size!!
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Qualification_ViewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.item_qualification_temp,parent,false)
        return Qualification_ViewHolder(view)
    }

    class Qualification_ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var title: TextView = itemView.findViewById(R.id.title) as TextView
        var name: TextView = itemView.findViewById(R.id.name) as TextView
        var duration: TextView = itemView.findViewById(R.id.duration) as TextView

    }

}