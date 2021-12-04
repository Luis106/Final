package com.example.main

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

class ProductosAdapter (private val mContext: Context, private val listProductos: MutableList<ProductosModel>):
    ArrayAdapter<ProductosModel>(mContext, 0, listProductos) {

    private lateinit var itemName: TextView
    private lateinit var itemPrice: TextView
    private lateinit var itemStorage: TextView
    //private lateinit var imageView: ImageView

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        // Se manda llamar el layout para cada uno de los items
        val layout = LayoutInflater.from(mContext).inflate(R.layout.producto_item, parent, false)
        val producto = listProductos[position]
        /*val profilePicture = producto.image
        val base64Image: String = profilePicture.split(",").get(1)
        val decodedString = Base64.decode(base64Image, Base64.DEFAULT)
        val decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.size)*/

        itemName = layout.findViewById(R.id.itemName)
        itemPrice = layout.findViewById(R.id.itemPrice)
        itemStorage = layout.findViewById(R.id.itemStorage)
        //imageView = layout.findViewById(R.id.imageViewPeople)
        itemName.text = producto.name
        itemPrice.text = "$${producto.price}"
        itemStorage.text = "${producto.storage} "


        //imageView.setImageBitmap(decodedByte)
        return layout
    }
}