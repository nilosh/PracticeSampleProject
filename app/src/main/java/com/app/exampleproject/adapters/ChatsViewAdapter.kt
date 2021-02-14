package com.app.exampleproject.adapters

import android.app.AlertDialog
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.PopupMenu
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView
import com.app.exampleproject.R
import com.app.exampleproject.user.UserChats
import com.squareup.picasso.Picasso
import de.hdodenhof.circleimageview.CircleImageView
import kotlinx.android.synthetic.main.chat_popup.view.*

class ChatsViewAdapter(

    private val list: ArrayList<UserChats>

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
            itemView.setOnClickListener{
                val dialogPopUp = LayoutInflater.from(itemView.context).inflate(R.layout.chat_popup, null)

                val builder = AlertDialog.Builder(itemView.context)
                    .setView(dialogPopUp)

                dialogPopUp.chatPopUpName.text = list[adapterPosition].userName
                dialogPopUp.chatPopUpDesc.text = list[adapterPosition].chatPreview
                Picasso.get()
                    .load(list[adapterPosition].userPhoto)
                    .into(dialogPopUp.chatPopUpPhoto)

                val alertDialog = builder.show()
                alertDialog.window?.setBackgroundDrawable(null)

                // Set dialog dismiss.
                dialogPopUp.chatPopUpOkButton.setOnClickListener{
                    alertDialog.dismiss()
                }
            }
        }

        fun setImage(url: String?) {
            Picasso.get()
                .load(url)
                .into(photo)
        }
    }
}

