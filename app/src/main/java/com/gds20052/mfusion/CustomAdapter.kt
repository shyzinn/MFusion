package com.gds20052.mfusion

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter(val img: ArrayList<Int>, text: Array<String>, desc: Array<String>):RecyclerView.Adapter<CustomAdapter.CustomViewerHolder>() {


    class CustomViewerHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindValue(image: Int,){

            itemView.findViewById<ImageView>(R.id.imageView).setImageResource(image)



        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewerHolder {

        val v = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)

        return CustomViewerHolder(v)

    }



    override fun getItemCount(): Int {

        return img.size


    }

    override fun onBindViewHolder(holder: CustomViewerHolder, position: Int) {

        holder.bindValue(img[position])
    }
}