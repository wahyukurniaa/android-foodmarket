package com.wahyukurnia.foodmarketkotlin.ui.profile.account

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.wahyukurnia.foodmarketkotlin.R
import com.wahyukurnia.foodmarketkotlin.model.dummy.ProfileMenuModel
import com.wahyukurnia.foodmarketkotlin.ui.profile.ProfileMenuAdapter
import kotlinx.android.synthetic.main.fragment_profile_account.*


class ProfileAccountFragment : Fragment(),ProfileMenuAdapter.ItemAdapterCallback {
    private var menuArrayList:ArrayList<ProfileMenuModel> = ArrayList()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile_account, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        initDataDummy()

        var adapter = ProfileMenuAdapter(menuArrayList,this)
        var layaoutManager : RecyclerView.LayoutManager= LinearLayoutManager(activity)
        rcList.adapter = adapter
        rcList.layoutManager = layaoutManager
    }

    fun initDataDummy(){
        menuArrayList = ArrayList()
        menuArrayList.add(ProfileMenuModel("Edit Profile"))
        menuArrayList.add(ProfileMenuModel("Home Address"))
        menuArrayList.add(ProfileMenuModel("Security"))
        menuArrayList.add(ProfileMenuModel("Payments"))
    }

    override fun onClick(v: View, data: ProfileMenuModel) {
        Toast.makeText(context,"ini menu yang kamu klik"+data.title,Toast.LENGTH_SHORT).show()
    }

}