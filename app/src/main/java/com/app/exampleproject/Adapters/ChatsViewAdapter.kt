package com.app.exampleproject.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.app.exampleproject.R
import com.squareup.picasso.Picasso
import de.hdodenhof.circleimageview.CircleImageView
import java.util.*

class ChatsViewAdapter(

    private val usernames: Array<String>,
    private val descriptions: Array<String>,
    private val profilePhotos: ArrayList<String>

) : RecyclerView.Adapter<ChatsViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.chat_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.name.text = usernames[position]
        holder.chatPreview.text = descriptions[position]
        holder.setImage(profilePhotos[position])
    }

    override fun getItemCount(): Int {
        return usernames.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var name: TextView
        var chatPreview: TextView
        var photo: CircleImageView

        fun setImage(url: String?) {
            Picasso.get()
                .load(url)
                .into(photo)
        }

        init {
            name = itemView.findViewById(R.id.chatUsername)
            chatPreview = itemView.findViewById(R.id.chatPreview)
            photo = itemView.findViewById(R.id.chatProfilePhoto)
        }
    }
}

