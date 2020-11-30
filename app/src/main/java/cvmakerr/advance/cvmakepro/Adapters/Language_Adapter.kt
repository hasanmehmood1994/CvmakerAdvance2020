package cvmakerr.advance.cvmakepro.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import cvmakerr.advance.cvmakepro.R
import cvmakerr.advance.cvmakepro.Room_Database.Entities.Languages


class  Language_Adapter(private val  context: Context, private val language:List<Languages>, val onClicklistene_Recycler:OnClickListener_Recycler, val onClicklistenedelete_Recycler:OnClickListener_RecyclerDelete) :
    RecyclerView.Adapter<Language_Adapter.Language_ViewHolder>() {


    override fun onBindViewHolder(holder: Language_ViewHolder, position: Int) {
        holder.languagename.text = language?.get(position)?.languagename

        holder.deletesingle.setOnClickListener(View.OnClickListener {
            onClicklistenedelete_Recycler.deleteclick_listner(position,language.get(position))
        })
        holder.itemView.setOnClickListener(View.OnClickListener {
            onClicklistene_Recycler.click_listner(position,language.get(position))
        })
    }
    override fun getItemCount(): Int {
        return language?.size!!
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Language_ViewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.item_language,parent,false)
        return Language_ViewHolder(view)
    }

    class Language_ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var languagename: TextView = itemView.findViewById(R.id.languagename) as TextView
        var deletesingle: ImageView =itemView.findViewById(R.id.deletesingle) as ImageView
    }
    interface OnClickListener_Recycler  {
        fun click_listner(position: Int, get:Languages)


    }
    interface OnClickListener_RecyclerDelete  {
        fun deleteclick_listner(position: Int, get: Languages)


    }
}
