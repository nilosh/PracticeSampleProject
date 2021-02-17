package com.app.exampleproject

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.chat_popup.view.*

class ChatDialogBox(private val userChat: UserChats, private val position: Int) : DialogFragment() {

    interface OnOkButtonCallback {
        fun onOkButtonPressed(reply: String?, position: Int)
    }

    var onOkButtonCallback: OnOkButtonCallback? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.chat_popup, container, false)

        Picasso.get()
            .load(userChat.userPhoto)
            .into(view.chatPopUpPhoto)
        view.chatPopUpName.text = userChat.userName
        view.chatPopUpDesc.text = userChat.chatPreview
        view.chatPopUpOkButton.setOnClickListener {
            val reply = view.chatPopupReplyText.text.toString()
            if (reply != "") {
                onOkButtonCallback!!.onOkButtonPressed(reply, position)
            }

            dialog!!.dismiss()
        }

        return view
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            onOkButtonCallback = targetFragment as OnOkButtonCallback?
        } catch (e: ClassCastException) {
            Log.e("TAG", "onAttach(): ClassCastException : " + e.message)
        }
    }
}