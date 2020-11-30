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


class Qualification_Adapter(private val  context: Context, private val qualification:List<Qualification>, val onClicklistene_Recycler:OnClickListener_Recycler, val onClicklistenedelete_Recycler:OnClickListener_RecyclerDelete) :
    RecyclerView.Adapter<Qualification_Adapter.Qualification_ViewHolder>() {


    override fun onBindViewHolder(holder: Qualification_ViewHolder, position: Int) {
        holder.title.text = qualification?.get(position)?.degreename
        holder.name.text = qualification?.get(position)?.institute
        holder.duration.text = qualification?.get(position)?.date

        holder.deletesingle.setOnClickListener(View.OnClickListener {
            onClicklistenedelete_Recycler.deleteclick_listner(position,qualification.get(position))
        })
        holder.itemView.setOnClickListener(View.OnClickListener {
            onClicklistene_Recycler.click_listner(position,qualification.get(position))
        })
    }
    override fun getItemCount(): Int {
        return qualification?.size!!
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Qualification_ViewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.item_qualification,parent,false)
        return Qualification_ViewHolder(view)
    }

    class Qualification_ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var title: TextView = itemView.findViewById(R.id.title) as TextView
        var name: TextView = itemView.findViewById(R.id.name) as TextView
        var duration: TextView = itemView.findViewById(R.id.duration) as TextView
        var deletesingle: ImageView =itemView.findViewById(R.id.deletesingle) as ImageView
    }
    interface OnClickListener_Recycler  {
        fun click_listner(position: Int, get: Qualification)


    }
    interface OnClickListener_RecyclerDelete  {
        fun deleteclick_listner(position: Int, get: Qualification)


    }
}