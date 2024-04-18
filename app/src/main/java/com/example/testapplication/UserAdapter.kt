package com.example.testapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.testapplication.databinding.ActivityMainBinding
import com.example.testapplication.databinding.ListItemBinding
import java.text.DecimalFormat
import kotlin.io.path.fileVisitor

class UserAdapter(val userList: List<User>) : RecyclerView.Adapter<UserAdapter.MyViewHolder>(){

    interface ItemClick{
        fun onClick(view: View, position: Int)
    }

    var itemClick : ItemClick? = null

    class MyViewHolder(private var binding : ListItemBinding):RecyclerView.ViewHolder(binding.root) {
        val profile = binding.ivProfile
        val title = binding.tvTitle
        val address = binding.tvAddress
        val price = binding.tvPrice
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserAdapter.MyViewHolder {
        val binding = ListItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UserAdapter.MyViewHolder, position: Int) {
        holder.itemView.setOnClickListener {
            itemClick?.onClick(it, position)
        }
        holder.profile.setImageResource(userList.get(position).profile)
        holder.title.text = userList.get(position).title
        holder.address.text = userList.get(position).address
        holder.price.text = DecimalFormat("#,###").format(userList.get(position).price).toString() + "원"
    }

    override fun getItemCount(): Int {
        return userList.size
    }
}
