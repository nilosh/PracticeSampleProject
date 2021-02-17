package com.app.exampleproject.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.app.exampleproject.ChatDialogBox
import com.app.exampleproject.R
import com.app.exampleproject.UserChats
import com.app.exampleproject.adapters.ChatsViewAdapter

class ChatsFragment : Fragment(), ChatDialogBox.OnOkButtonCallback {
    private var images = ArrayList<String>()
    private lateinit var recyclerView: RecyclerView
    private val list = ArrayList<UserChats>()
    private var chatsViewAdapter: ChatsViewAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_chats, container, false)

        // Initialize views.
        recyclerView = view.findViewById(R.id.chatsRecyclerView)

        // Store the image URLs in an arrayList.
        images = userImages

        for (i in 0..4) {
            val userItem = UserChats(
                resources.getStringArray(R.array.people)[i],
                resources.getStringArray(R.array.chat_desc)[i], images[i]
            )

            list.add(userItem)
        }

        // Set adapter to recycler view.
        chatsViewAdapter = ChatsViewAdapter(list, this)
        recyclerView.adapter = chatsViewAdapter
        recyclerView.layoutManager = LinearLayoutManager(view.context)

        return view
    }

    private val userImages: ArrayList<String>
        private get() {
            val userImages = ArrayList<String>()
            val url1 =
                "https://images.unsplash.com/photo-1510227272981-87123e259b17?ixlib=rb-0.3.5&q=80&fm=" +
                        "jpg&crop=faces&fit=crop&h=200&w=200&s=3759e09a5b9fbe53088b23c615b6312e"
            val url2 =
                "https://images-na.ssl-images-amazon.com/images/M/MV5BMTkzNjE5MzY5M15BMl5BanBnXkFtZTgwMDI5ODMxODE@." +
                        "_V1_UY256_CR98,0,172,256_AL_.jpg"
            val url3 = "https://uifaces.co/our-content/donated/6h0HeYG_.jpg"
            val url4 = "https://randomuser.me/api/portraits/men/1.jpg"
            val url5 = "https://uifaces.co/our-content/donated/gPZwCbdS.jpg"
            userImages.add(url1)
            userImages.add(url2)
            userImages.add(url3)
            userImages.add(url4)
            userImages.add(url5)
            return userImages
        }

    override fun onOkButtonPressed(reply: String?, position: Int) {
        val userChat: UserChats = list[position]
        userChat.chatPreview = reply.toString()

        chatsViewAdapter = ChatsViewAdapter(list, this)
        recyclerView.adapter = chatsViewAdapter
        recyclerView.layoutManager = LinearLayoutManager(this.context)
    }

}