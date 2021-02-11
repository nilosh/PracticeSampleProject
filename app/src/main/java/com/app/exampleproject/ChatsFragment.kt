package com.app.exampleproject

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.app.exampleproject.Adapters.ChatsViewAdapter
import de.hdodenhof.circleimageview.CircleImageView
import java.util.*

class ChatsFragment : Fragment() {
    private lateinit var profilePicture: CircleImageView
    private var images = ArrayList<String>()
    private lateinit var names: Array<String>
    private lateinit var chatDescription: Array<String>
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView( inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_chats, container, false)

        // Initialize views.
        recyclerView = view.findViewById(R.id.chatsRecyclerView)

        names = resources.getStringArray(R.array.people)
        chatDescription = resources.getStringArray(R.array.chat_desc)

        // Store the image URLs in an arrayList.
        images = userImages

        // Set adapter to recycler view.
        val chatsViewAdapter = ChatsViewAdapter(names, chatDescription, images)
        recyclerView.setAdapter(chatsViewAdapter)
        recyclerView.setLayoutManager(LinearLayoutManager(view.getContext()))

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
}