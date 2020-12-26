package cvmakerr.advance.cvmakepro.TemplateAdapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import cvmakerr.advance.cvmakepro.R
import cvmakerr.advance.cvmakepro.Room_Database.Entities.Languages


class  Language_Adapter_Template(
    private val context: Context,
    private val language: List<Languages>,
   private val which: String
) :
    RecyclerView.Adapter<Language_Adapter_Template.Language_ViewHolder>() {


    override fun onBindViewHolder(holder: Language_ViewHolder, position: Int) {
        holder.languagename.text = language?.get(position)?.languagename
        if (which=="1")
        {  holder.languagename.text =language?.get(position)?.languagename

        }
        else if(which=="2"){
            holder.languagename.setTextColor(holder.itemView.resources.getColor(R.color.black))
            holder.languagename.text = language?.get(position)?.languagename
            holder.languagename.setTextColor(holder.itemView.resources.getColor(R.color.black))
        }
        else if(which=="3"){
            holder.languagename.setTextColor(holder.itemView.resources.getColor(R.color.white))
            holder.languagename.text = language?.get(position)?.languagename
            holder.languagename.setTextColor(holder.itemView.resources.getColor(R.color.white))
        }
    }
    override fun getItemCount(): Int {
        return language?.size!!
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Language_ViewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.item_language_temp,parent,false)
        return Language_ViewHolder(view)
    }

    class Language_ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var languagename: TextView = itemView.findViewById(R.id.languagename) as TextView

    }

}
