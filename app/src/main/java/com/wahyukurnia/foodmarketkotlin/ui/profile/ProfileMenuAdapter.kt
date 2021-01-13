package com.wahyukurnia.foodmarketkotlin.ui.profile

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.wahyukurnia.foodmarketkotlin.R
import com.wahyukurnia.foodmarketkotlin.model.dummy.ProfileMenuModel
import kotlinx.android.synthetic.main.item_menu_profile.view.*

class ProfileMenuAdapter(
        private val listData : List<ProfileMenuModel>,
        private val itemAdapterCallback: ItemAdapterCallback
) :RecyclerView.Adapter<ProfileMenuAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfileMenuAdapter.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.item_menu_profile,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProfileMenuAdapter.ViewHolder, position: Int) {
        holder.bind(listData[position],itemAdapterCallback)
    }

    override fun getItemCount(): Int {
        return listData.size
    }

    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        fun bind(data: ProfileMenuModel,itemAdapterCallback: ItemAdapterCallback){
            itemView.apply {
                tvTitle.text = data.title
                itemView.setOnClickListener { itemAdapterCallback.onClick(it,data) }
            }
        }
    }
    interface ItemAdapterCallback{
        fun onClick(v: View,data:ProfileMenuModel)
    }
}