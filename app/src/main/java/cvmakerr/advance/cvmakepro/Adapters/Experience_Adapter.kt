package cvmakerr.advance.cvmakepro.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import cvmakerr.advance.cvmakepro.R
import cvmakerr.advance.cvmakepro.Room_Database.Entities.Experience

class Experience_Adapter(private val  context: Context,private val experience:List< Experience>,val onClicklistene_Recycler:OnClickListener_Recycler,val onClicklistenedelete_Recycler:OnClickListener_RecyclerDelete) :RecyclerView.Adapter<Experience_Adapter.ExperienceViewHolder>() {


    override fun onBindViewHolder(holder: ExperienceViewHolder, position: Int) {
        holder.cname.text = experience?.get(position)?.companyname
        holder.cdeg.text = experience?.get(position)?.designation
        holder.cdu.text = experience?.get(position)?.duration
        holder.cdes.text = experience?.get(position)?.description

        holder.deletesingle.setOnClickListener(View.OnClickListener {
            onClicklistenedelete_Recycler.deleteclick_listner(position,experience.get(position))
        })
        holder.itemView.setOnClickListener(View.OnClickListener {
onClicklistene_Recycler.click_listner(position,experience.get(position))
        })
    }
    override fun getItemCount(): Int {
        return experience?.size!!
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExperienceViewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.item_experience,parent,false)
        return ExperienceViewHolder(view)
    }

    class ExperienceViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var cname: TextView = itemView.findViewById(R.id.cname) as TextView
        var cdeg: TextView = itemView.findViewById(R.id.cdeg) as TextView
        var cdu: TextView = itemView.findViewById(R.id.cdu) as TextView
        var cdes: TextView = itemView.findViewById(R.id.cdes) as TextView
        var deletesingle:ImageView =itemView.findViewById(R.id.deletesingle) as ImageView
    }
    interface OnClickListener_Recycler  {
        fun click_listner(position: Int, get: Experience)


    }
    interface OnClickListener_RecyclerDelete  {
        fun deleteclick_listner(position: Int, get: Experience)


    }
}