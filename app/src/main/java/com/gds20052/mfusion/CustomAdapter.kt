package com.gds20052.mfusion

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter(val img: ArrayList<Int>,val text: Array<String>,val desc: Array<String>,private val listener: OnItemClickListener)
    :RecyclerView.Adapter<CustomAdapter.CustomViewerHolder>() {


    //CONTROLLER FOR RECYCLER VIEWER
    inner class CustomViewerHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        fun bindValue(image: Int,txt:String,desc: String){
            itemView.findViewById<ImageView>(R.id.imageView).setImageResource(image)
            itemView.findViewById<TextView>(R.id.text1).text = txt
            itemView.findViewById<TextView>(R.id.text2).text = desc
        }
        /**Initialize clickListener*/
        init {
            itemView.setOnClickListener(this)
        }

        /**Action to take when item is clicked*/
        override fun onClick(v: View?) {
            val position = adapterPosition
            /**Confirm position is valid then call onItemClick*/
            if (position != RecyclerView.NO_POSITION) {
                listener.onItemClick(position)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewerHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return CustomViewerHolder(v)
    }

    override fun getItemCount() = img.size


    // METHOD FOR THE MENU OF FOOD
    override fun onBindViewHolder(holder: CustomViewerHolder, position: Int) {

        holder.bindValue(img[position],text[position],desc[position])
    }


    interface OnItemClickListener{
        fun onItemClick(position: Int)
    }

}