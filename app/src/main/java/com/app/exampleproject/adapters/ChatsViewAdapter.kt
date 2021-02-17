package com.app.exampleproject.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.app.exampleproject.ChatDialogBox
import com.app.exampleproject.R
import com.app.exampleproject.UserChats
import com.app.exampleproject.fragments.ChatsFragment
import com.squareup.picasso.Picasso
import de.hdodenhof.circleimageview.CircleImageView

class ChatsViewAdapter(

    private val list: ArrayList<UserChats>,
    private val fragment: ChatsFragment

) : RecyclerView.Adapter<ChatsViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.chat_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.name.text = list[position].userName
        holder.chatPreview.text = list[position].chatPreview
        holder.setImage(list[position].userPhoto)

    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var name: TextView = itemView.findViewById(R.id.chatUsername)
        var chatPreview: TextView = itemView.findViewById(R.id.chatPreview)
        var photo: CircleImageView = itemView.findViewById(R.id.chatProfilePhoto)

        init {
            itemView.setOnClickListener {
                val userChat = UserChats(
                    list[adapterPosition].userName, list[adapterPosition].chatPreview,
                    list[adapterPosition].userPhoto
                )

                val chatDialog = ChatDialogBox(userChat, adapterPosition)
                chatDialog.setTargetFragment(fragment, 1)
                fragment.fragmentManager?.let { it -> chatDialog.show(it, "Chat Dialog Box") }
            }
        }

        fun setImage(url: String?) {
            Picasso.get()
                .load(url)
                .into(photo)
        }

    }
}

