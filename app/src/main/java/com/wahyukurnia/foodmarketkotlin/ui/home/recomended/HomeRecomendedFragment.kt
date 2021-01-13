package com.wahyukurnia.foodmarketkotlin.ui.home.recomended

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.wahyukurnia.foodmarketkotlin.R
import com.wahyukurnia.foodmarketkotlin.model.dummy.HomeVerticalModel
import com.wahyukurnia.foodmarketkotlin.ui.detail.DetailActivity
import com.wahyukurnia.foodmarketkotlin.ui.home.newtaste.HomeNewtasteAdapter
import kotlinx.android.synthetic.main.fragment_home.*

class HomeRecomendedFragment : Fragment(),HomeNewtasteAdapter.ItemAdapterCallback {
    private var foodList: ArrayList<HomeVerticalModel> = ArrayList()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home_new_taste, container, false)
    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        initDataDummy()
        var adapter = HomeNewtasteAdapter(foodList,this)
        var layoutManager : RecyclerView.LayoutManager = LinearLayoutManager(activity)
        rcList.layoutManager = layoutManager
        rcList.adapter = adapter
    }

    private fun initDataDummy() {
        foodList.add(HomeVerticalModel("Cherry Healthy","10000","",5f))
        foodList.add(HomeVerticalModel("Burger Tamayo","20000","",4f))
        foodList.add(HomeVerticalModel("Bakwan Cihuy","30000","",4.5f))
    }

    override fun onClick(v: View, data: HomeVerticalModel) {
        val detail = Intent(activity, DetailActivity::class.java)
        startActivity(detail)
    }
}