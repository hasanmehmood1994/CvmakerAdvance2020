package cvmakerr.advance.cvmakepro.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import cvmakerr.advance.cvmakepro.R
import cvmakerr.advance.cvmakepro.Room_Database.Entities.Hobbies


class  Hobbie_Adapter(private val  context: Context, private val hobbie:List<Hobbies>, val onClicklistene_Recycler:OnClickListener_Recycler, val onClicklistenedelete_Recycler:OnClickListener_RecyclerDelete) :
    RecyclerView.Adapter<Hobbie_Adapter.Hobbie_ViewHolder>() {


    override fun onBindViewHolder(holder: Hobbie_ViewHolder, position: Int) {
        holder.hobbiename.text = hobbie?.get(position)?.hobbiename

        holder.deletesingle.setOnClickListener(View.OnClickListener {
            onClicklistenedelete_Recycler.deleteclick_listner(position,hobbie.get(position))
        })
        holder.itemView.setOnClickListener(View.OnClickListener {
            onClicklistene_Recycler.click_listner(position,hobbie.get(position))
        })
    }
    override fun getItemCount(): Int {
        return hobbie?.size!!
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Hobbie_ViewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.item_hobbie,parent,false)
        return Hobbie_ViewHolder(view)
    }

    class Hobbie_ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var hobbiename: TextView = itemView.findViewById(R.id.hobbiename) as TextView

        var deletesingle: ImageView =itemView.findViewById(R.id.deletesingle) as ImageView
    }
    interface OnClickListener_Recycler  {
        fun click_listner(position: Int, get:Hobbies)


    }
    interface OnClickListener_RecyclerDelete  {
        fun deleteclick_listner(position: Int, get: Hobbies)


    }
}
