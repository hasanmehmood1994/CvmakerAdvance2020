package cvmakerr.advance.cvmakepro.Adapters

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import cvmakerr.advance.cvmakepro.Model_Classes.Typemodel
import cvmakerr.advance.cvmakepro.R

class MainLoaderAdapter (val typemodels: ArrayList<Typemodel>,val context: Context,val cellClickListener: CellClickListener): RecyclerView.Adapter<MainLoaderAdapter.LoaderViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LoaderViewHolder {
       val view=LayoutInflater.from(parent.context).inflate(R.layout.item_type,parent,false)


        return LoaderViewHolder(view)
    }
    var row_index=0;
    override fun onBindViewHolder(holder: LoaderViewHolder, position: Int) {
        val data =typemodels[position]
        holder. txt.text=data.name
       // holder. floatingActionButton.setImageResource(data.img)
       // holder. floatingActionButton .setImageDrawable(context.getDrawable(data.img))
        holder. img_icon.setImageDrawable(context.getDrawable(data.img));
        holder. Cardvieww.setBackgroundTintList(ColorStateList.valueOf(context.getResources().getColor(data.tintcolor)));
        if(row_index==position){
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
                holder.  bgtype.setBackgroundColor(context.getColor(R.color.selected))
            };

        }
        else
        {
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
                holder.  bgtype.setBackgroundColor(context.getColor(R.color.main))
            };

        }

        holder.Cardvieww.setOnClickListener {
            cellClickListener.onCellClickListener(position,data)

            row_index=position;
          notifyDataSetChanged()
        }


    }

    override fun getItemCount(): Int {
      return typemodels.size;
    }

class LoaderViewHolder (itemview: View):RecyclerView.ViewHolder (itemview) {

        val txt = itemView.findViewById(R.id.txttypename) as TextView
        val Cardvieww = itemView.findViewById(R.id.cardview) as CardView
        val bgtype = itemView.findViewById(R.id.bgtype) as ConstraintLayout
    val img_icon = itemView.findViewById(R.id.img_icon) as ImageView





}




    interface CellClickListener {
        fun onCellClickListener(position: Int, data: Typemodel)


    }
}