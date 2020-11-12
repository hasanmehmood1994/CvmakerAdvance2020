package cvmakerr.advance.cvmakepro.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import cvmakerr.advance.cvmakepro.Model_Classes.Typemodel
import cvmakerr.advance.cvmakepro.R

class MainLoaderAdapter (val typemodels: ArrayList<Typemodel>,val context: Context,val cellClickListener: CellClickListener): RecyclerView.Adapter<MainLoaderAdapter.LoaderViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LoaderViewHolder {
       val view=LayoutInflater.from(parent.context).inflate(R.layout.item_type,parent,false)


        return LoaderViewHolder(view)
    }
    override fun onBindViewHolder(holder: LoaderViewHolder, position: Int) {
        val data =typemodels[position]
        holder. txt.text=data.name
        holder. floatingActionButton.setImageResource(data.img)
        holder.  bgtype.setBackgroundColor(context.resources.getColor(R.color.white))


        holder.floatingActionButton.setOnClickListener {
            cellClickListener.onCellClickListener(position,data)
        }


    }

    override fun getItemCount(): Int {
      return typemodels.size;
    }

class LoaderViewHolder (itemview: View):RecyclerView.ViewHolder (itemview) {

        val txt = itemView.findViewById(R.id.txttypename) as TextView
        val floatingActionButton = itemView.findViewById(R.id.floatingActionButton) as FloatingActionButton
        val bgtype = itemView.findViewById(R.id.bgtype) as ConstraintLayout






}




    interface CellClickListener {
        fun onCellClickListener(position: Int, data: Typemodel)
    }
}