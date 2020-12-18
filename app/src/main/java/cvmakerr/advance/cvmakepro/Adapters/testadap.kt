package cvmakerr.advance.cvmakepro.Adapters

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import cvmakerr.advance.cvmakepro.R
import java.util.ArrayList


class  testadap(private val dataSet: ArrayList<DataModel, >, var mContext: Context, val onClicklistene_Recycler:OnClickListener_Recycler) :
    RecyclerView.Adapter<testadap.testviewhol>() {

    var linearLayout: ImageView? = null
    override fun onBindViewHolder(holder: testviewhol, position: Int) {
//        holder.skillname.text = skill?.get(position)?.skillname
//        holder.skillpercentage.text = skill?.get(position)?.skillpercetage
        val inflater = mContext.applicationContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view1 = inflater.inflate(dataSet[position]!!.id_number, null)
        val drawable: Drawable = BitmapDrawable(mContext.resources, Template_Selector_Adapter.getBitmapFromView1(view1))
        holder.cardd!!.background = drawable

        holder.itemView.setOnClickListener(View.OnClickListener {
            onClicklistene_Recycler.click_listner(dataSet[position]!!.id_number,dataSet[position].number!!)
        })
    }
    override fun getItemCount(): Int {
        return dataSet?.size!!
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): testviewhol {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.listview_layout,parent,false)
        return testviewhol(view)
    }

    class testviewhol(itemView: View): RecyclerView.ViewHolder(itemView) {

        var cardd: ImageView = itemView.findViewById(R.id.cardd) as ImageView

    }
    interface OnClickListener_Recycler  {
        fun click_listner(position: Int, number: String)


    }
    companion object {

        fun getBitmapFromView1(view: View): Bitmap {
            view.measure(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED)
            val bitmap = Bitmap.createBitmap(
                view.measuredWidth, view.measuredHeight,
                Bitmap.Config.ARGB_8888
            )
            val canvas = Canvas(bitmap)
            view.layout(0, 0, view.measuredWidth, view.measuredHeight)
            view.draw(canvas)
            return bitmap
        }
    }
}
