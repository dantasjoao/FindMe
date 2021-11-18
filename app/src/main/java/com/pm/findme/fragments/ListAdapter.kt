package com.pm.findme.fragments

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.ListFragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.pm.findme.ListFragmendDirections
import com.pm.findme.R
import com.pm.findme.model.Company
import kotlinx.android.synthetic.main.custom_row.view.*
import java.util.Collections.emptyList

class ListAdapter: RecyclerView.Adapter<ListAdapter.MyViewHolder>(){

    private var companyList = emptyList<Company>()
    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.custom_row, parent,false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = companyList[position]
        holder.itemView.id_txt.text = currentItem.id.toString()
        holder.itemView.companyName_txt.text = currentItem.companyName
        holder.itemView.companyEmail_txt.text = currentItem.companyEmail
        holder.itemView.companyPhone_txt.text = currentItem.companyPhone.toString()
        holder.itemView.companyAddress_txt.text = currentItem.companyAddress
        holder.itemView.companyCategory_txt.text = currentItem.companyCategory

        holder.itemView.rowLayout.setOnClickListener{
            val action = ListFragmendDirections.actionListFragmendToUpdateFragment2(currentItem)
            holder.itemView.findNavController().navigate(action)
        }


    }

    override fun getItemCount(): Int {
        return companyList.size
    }

    fun setData(company: List<Company>){
        this.companyList = company
        notifyDataSetChanged()
    }
}