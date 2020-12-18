package cvmakerr.advance.cvmakepro.Adapters

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import cvmakerr.advance.cvmakepro.CvTemplates.Design1.CreateMenu
import cvmakerr.advance.cvmakepro.R
import cvmakerr.advance.cvmakepro.Room_Database.Entities.Skills
import java.util.*

/**
 * Created by anupamchugh on 09/02/16.
 */
class Template_Selector_Adapter(private val dataSet: ArrayList<DataModel,>, var mContext: Context) :


    ArrayAdapter<DataModel?>(mContext, R.layout.listview_layout, dataSet as List<DataModel?>), View.OnClickListener {
    // View lookup cache
    private class ViewHolder {

        var linearLayout: ImageView? = null
    }

    override fun onClick(v: View) {
        val position = v.tag as Int
        val `object`: Any? = getItem(position)
        val dataModel = `object` as DataModel?
        when (v.id) {

            R.id.cardd -> {


//
                try {
                    (mContext as Activity).finish()
                } catch (e: Exception) {

                }
                val intent2 = Intent(mContext, CreateMenu::class.java)
                intent2.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                intent2.putExtra("idd", "" + dataModel!!.id_number)
                mContext.startActivity(intent2)
            }
        }
    }

    private var lastPosition = -1
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        // Get the data item for this position
        var convertView = convertView
        val dataModel = getItem(position)
        // Check if an existing view is being reused, otherwise inflate the view
        val viewHolder: ViewHolder // view lookup cache stored in tag
        val result: View?
        if (convertView == null) {
            viewHolder = ViewHolder()
            val inflater = LayoutInflater.from(context)
            convertView = inflater.inflate(R.layout.listview_layout, parent, false)
            viewHolder.linearLayout = convertView.findViewById<View>(R.id.cardd) as ImageView
            result = convertView
            convertView.tag = viewHolder
        } else {
            viewHolder = convertView.tag as ViewHolder
            result = convertView
        }


        lastPosition = position
        val name2: TextView
        val address: TextView
        val phone: TextView
        val mail: TextView


        val inflater = mContext.applicationContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view1 = inflater.inflate(dataModel!!.id_number, null)
        address = view1.findViewById(R.id.address)
        name2 = view1.findViewById(R.id.name)
        phone = view1.findViewById(R.id.phone)
        mail = view1.findViewById(R.id.email)
        name2.text = "your name"
        address.text = "your address"
        phone.text = "your phone"
        mail.text = "your email"
        val drawable: Drawable = BitmapDrawable(mContext.resources, getBitmapFromView1(view1))
        viewHolder.linearLayout!!.background = drawable
        viewHolder.linearLayout!!.setOnClickListener(this)
        viewHolder.linearLayout!!.tag = position
        return convertView!!
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