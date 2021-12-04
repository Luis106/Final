package com.example.main

import android.content.Context
import android.graphics.BitmapFactory
import android.util.Base64
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class CortesAdapter (private val mContext: Context, private val listCortes: List<CortesModel>):
    ArrayAdapter<CortesModel>(mContext, 0, listCortes) {

    private lateinit var itemFecha: TextView
    private lateinit var itemMonto: TextView
    //private lateinit var imageView: ImageView

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        // Se manda llamar el layout para cada uno de los items
        val layout = LayoutInflater.from(mContext).inflate(R.layout.corte_item, parent, false)
        val corte = listCortes[position]
        /*val profilePicture = corte.image
        val base64Image: String = profilePicture.split(",").get(1)
        val decodedString = Base64.decode(base64Image, Base64.DEFAULT)
        val decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.size)*/

        itemFecha = layout.findViewById(R.id.itemFecha)
        itemMonto = layout.findViewById(R.id.itemMonto)
        //imageView = layout.findViewById(R.id.imageViewPeople)
        itemFecha.text = corte.fecha
        itemMonto.text = "$${corte.monto}"
        //imageView.setImageBitmap(decodedByte)
        return layout
    }
}