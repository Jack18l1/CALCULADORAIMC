package com.eliut.navegadordraweliu

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView

class ImageAdapter(
    private val context: Context,
    private val images: List<Image>
) : RecyclerView.Adapter<ImageAdapter.ImageViewHolder>() {

    class ImageViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val img = itemView.findViewById<ImageView>(R.id.image)
        val imgTitle = itemView.findViewById<TextView>(R.id.image_title)

        fun bindView(image: Image) {
            img.setImageResource(image.imageSrc)
            imgTitle.text = image.title
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder =
        ImageViewHolder(
            LayoutInflater.from(context).inflate(R.layout.item_postre, parent, false)
        )

    override fun getItemCount(): Int = images.size

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        val image = images[position]
        holder.bindView(image)

        // Configurar OnClickListener en la vista de elemento
        holder.itemView.setOnClickListener {
            val url = image.url
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(holder.itemView.context, intent, null)
        }
    }
}

