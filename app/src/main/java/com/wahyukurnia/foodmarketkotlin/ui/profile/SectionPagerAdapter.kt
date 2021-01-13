package com.wahyukurnia.foodmarketkotlin.ui.profile

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.wahyukurnia.foodmarketkotlin.ui.home.newtaste.HomeNewTasteFragment
import com.wahyukurnia.foodmarketkotlin.ui.home.popular.HomePopularFragment
import com.wahyukurnia.foodmarketkotlin.ui.home.recomended.HomeRecomendedFragment
import com.wahyukurnia.foodmarketkotlin.ui.profile.account.ProfileAccountFragment
import com.wahyukurnia.foodmarketkotlin.ui.profile.foodmarket.ProfileFoodmarketFragment

class SectionPagerAdapter(fm:FragmentManager) :FragmentPagerAdapter(fm) {

    override fun getPageTitle(position: Int): CharSequence? {
        return when(position){
            0 -> "Account"
            1 -> "Food Market"
            else -> ""
        }
    }

    override fun getCount(): Int {
        return 3
    }

    override fun getItem(position: Int): Fragment {
        val fragment :Fragment
        return when(position){
            0 -> {
                fragment  = ProfileAccountFragment()
                return fragment
            }
            1 ->{
                fragment = ProfileFoodmarketFragment()
                return fragment
            }
            else ->{
                fragment = ProfileAccountFragment()
                return fragment
            }
        }
    }
}