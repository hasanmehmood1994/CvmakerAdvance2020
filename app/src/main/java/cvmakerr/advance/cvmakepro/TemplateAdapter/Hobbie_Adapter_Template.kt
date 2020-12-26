package cvmakerr.advance.cvmakepro.TemplateAdapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import cvmakerr.advance.cvmakepro.R
import cvmakerr.advance.cvmakepro.Room_Database.Entities.Hobbies


class  Hobbie_Adapter_Template(
    private val context: Context,
    private val hobbie: List<Hobbies>,
   private val which: String
) :
    RecyclerView.Adapter<Hobbie_Adapter_Template.Hobbie_ViewHolder>() {


    override fun onBindViewHolder(holder: Hobbie_ViewHolder, position: Int) {

if (which=="1")
{  holder.hobbiename.text = hobbie?.get(position)?.hobbiename

}
        else if (which=="3")
        {  holder.hobbiename.text = hobbie?.get(position)?.hobbiename
            holder.hobbiename.setTextColor(holder.itemView.resources.getColor(R.color.white))
            holder.hobbiename.text = hobbie?.get(position)?.hobbiename
            holder.hobbiename.setTextColor(holder.itemView.resources.getColor(R.color.white))
        }
      else  if (which=="2"){
    holder.hobbiename.setTextColor(holder.itemView.resources.getColor(R.color.black))
    holder.hobbiename.text = hobbie?.get(position)?.hobbiename
    holder.hobbiename.setTextColor(holder.itemView.resources.getColor(R.color.black))
        }

    }
    override fun getItemCount(): Int {
        return hobbie?.size!!
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Hobbie_ViewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.item_hobbie_temp,parent,false)
        return Hobbie_ViewHolder(view)
    }

    class Hobbie_ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var hobbiename: TextView = itemView.findViewById(R.id.hobbiename) as TextView

    }

}
