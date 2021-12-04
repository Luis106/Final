package com.example.main

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

class EmpleadosAdapter (private val mContext: Context, private val listEmpleados: List<EmpleadosModel>):
    ArrayAdapter<EmpleadosModel>(mContext, 0, listEmpleados) {

    private lateinit var itemName: TextView
    private lateinit var itemRange: TextView
    private lateinit var itemUlt: TextView
    private lateinit var itemCre: TextView
    //private lateinit var imageView: ImageView

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        // Se manda llamar el layout para cada uno de los items
        val layout = LayoutInflater.from(mContext).inflate(R.layout.empleado_item, parent, false)
        val empleado = listEmpleados[position]
        /*val profilePicture = empleado.image
        val base64Image: String = profilePicture.split(",").get(1)
        val decodedString = Base64.decode(base64Image, Base64.DEFAULT)
        val decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.size)*/

        itemName = layout.findViewById(R.id.itemName)
        itemRange = layout.findViewById(R.id.itemRange)
        itemUlt = layout.findViewById(R.id.itemUlt)
        itemCre = layout.findViewById(R.id.itemCre)
        //imageView = layout.findViewById(R.id.imageViewPeople)
        itemName.text = empleado.name
        itemRange.text = empleado.range
        itemUlt.text = empleado.ultimaEn
        itemCre.text = empleado.creacion
        //imageView.setImageBitmap(decodedByte)
        return layout
    }
}