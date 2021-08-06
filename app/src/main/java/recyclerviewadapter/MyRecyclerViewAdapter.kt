package recyclerviewadapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.dimitrisligi.mvvmrestapiusingretrofitandrecyclerview.R
import models.Data
import repository.MainRepository

class MyRecyclerViewAdapter : RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder>(){


    private var listOfUsers = MainRepository.getUsers().value?.data
    val sizeList = listOfUsers?.size

    fun setListOfUsers(users: List<Data>){
        this.listOfUsers = users
    }
    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view){


        var email: TextView = view.findViewById(R.id.tv_email)
        var firstname: TextView = view.findViewById(R.id.tv_firstname)
        var lastname: TextView = view.findViewById(R.id.tv_lastname)
        var id: TextView = view.findViewById(R.id.tv_ID)
        var avatar: ImageView = view.findViewById(R.id.iv_avatar)


        fun bind(user: Data){
            this.email.text = user.email
            this.firstname.text = user.firstName
            this.lastname.text = user.lastName
            this.id.text = user.id.toString()
        }
    }



    override fun onBindViewHolder(holder: MyRecyclerViewAdapter.ViewHolder, position: Int) {
        listOfUsers?.get(position)?.let { holder.bind(it) }
    }

    override fun getItemCount(): Int {
        return 2
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.card_details, parent,false)
        return ViewHolder(v)
    }


}