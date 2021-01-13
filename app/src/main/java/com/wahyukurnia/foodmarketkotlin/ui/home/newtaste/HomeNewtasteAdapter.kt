package com.wahyukurnia.foodmarketkotlin.ui.home.newtaste

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.wahyukurnia.foodmarketkotlin.R
import com.wahyukurnia.foodmarketkotlin.model.dummy.HomeVerticalModel
import com.wahyukurnia.foodmarketkotlin.utils.Helpers.formatPrice
import kotlinx.android.synthetic.main.item_home_vertical.view.*

class HomeNewtasteAdapter(
        private val listData : List<HomeVerticalModel>,
        private val itemAdapterCallback: ItemAdapterCallback
) :RecyclerView.Adapter<HomeNewtasteAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeNewtasteAdapter.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.item_home_vertical,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: HomeNewtasteAdapter.ViewHolder, position: Int) {
        holder.bind(listData[position],itemAdapterCallback)
    }

    override fun getItemCount(): Int {
        return listData.size
    }

    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        fun bind(data: HomeVerticalModel,itemAdapterCallback: ItemAdapterCallback){
            itemView.apply {
                tvTitle.text = data.title
                tvPrice.formatPrice(data.price)
                rbFood.rating = data.rating

//                Glide.with(context)
//                        .load(data.src)
//                        .into(ivPoster)
                itemView.setOnClickListener { itemAdapterCallback.onClick(it,data) }
            }
        }
    }
    interface ItemAdapterCallback{
        fun onClick(v: View,data:HomeVerticalModel)
    }
}