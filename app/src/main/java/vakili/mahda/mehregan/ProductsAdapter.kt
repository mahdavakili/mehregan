package vakili.mahda.mehregan

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ProductsAdapter (val list:List<Notes>, val itemClickListener: ItemClickListener) :
    RecyclerView.Adapter<ProductsAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductsAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.notes_adapter_layout,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ProductsAdapter.ViewHolder, position: Int) {
        val notes = list[position]
        val name = notes.name
        val numberInTheBox = notes.numberInTheBox
        val price = notes.price
        holder.textViewName.text = name
        holder.textViewNumberinthebox.text = numberInTheBox.toString()
        holder.textViewPrice.text = price.toString()
        holder.itemView.setOnClickListener(object  : View.OnClickListener
        {
            override fun onClick(p0: View?) {
                itemClickListener.onClick(notes)
            }
        })
    }


    inner class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        val textViewName: TextView =itemView.findViewById(R.id.textViewName)
        val textViewNumberinthebox: TextView = itemView.findViewById(R.id.textViewNumberinthebox)
        val textViewPrice: TextView = itemView.findViewById(R.id.textViewPrice)
    }
}