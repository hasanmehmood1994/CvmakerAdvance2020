package cvmakerr.advance.cvmakepro.Adapters

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import cvmakerr.advance.cvmakepro.R
import cvmakerr.advance.cvmakepro.Room_Database.Entities.History


class  History_Adapter(
    private val context: Context,
    private val skill: List<History>,
    val onClicklistene_Recycler: OnClickListener_Recycler,
    val onClicklistenedelete_Recycler: OnClickListener_RecyclerDelete
) :
    RecyclerView.Adapter<History_Adapter.History_ViewHolder>() {


    override fun onBindViewHolder(holder: History_ViewHolder, position: Int) {

        val iimg: ByteArray? = skill?.get(position)?.imagery
        holder.cardd.setImageBitmap(convertToBitmap(iimg!!))
        holder.imgdel.setOnClickListener(View.OnClickListener {
            onClicklistenedelete_Recycler.deleteclick_listner(position, skill.get(position),"del")
        })
        holder.imgsave.setOnClickListener(View.OnClickListener {
            onClicklistenedelete_Recycler.deleteclick_listner(position, skill.get(position),"save")
        })
        holder.itemView.setOnClickListener(View.OnClickListener {
            onClicklistene_Recycler.click_listner(position, skill.get(position))
        })
    }
    override fun getItemCount(): Int {
        return skill?.size!!
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): History_ViewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.history_item, parent, false)
        return History_ViewHolder(view)
    }

    class History_ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var imgdel: ImageView= itemView.findViewById(R.id.imgdel) as ImageView
        var imgsave: ImageView= itemView.findViewById(R.id.imgsave) as ImageView
        var cardd: ImageView =itemView.findViewById(R.id.cardd) as ImageView
    }
    interface OnClickListener_Recycler  {
        fun click_listner(position: Int, get: History)


    }
    interface OnClickListener_RecyclerDelete  {
        fun deleteclick_listner(position: Int, get: History, s: String)


    }

    private fun convertToBitmap(b: ByteArray): Bitmap? {
        return BitmapFactory.decodeByteArray(b, 0, b.size)
    }
}
