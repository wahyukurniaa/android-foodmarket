package com.wahyukurnia.foodmarketkotlin.ui.auth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.navigation.NavOptions
import androidx.navigation.Navigation
import com.wahyukurnia.foodmarketkotlin.R
import kotlinx.android.synthetic.main.layout_toolbar.*

class AuthActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)

        val pageRequest = intent.getIntExtra("page_request", 0)
        if (pageRequest == 2){
            toolBarSignUp()
            val navOptions = NavOptions.Builder()
                .setPopUpTo(R.id.fragmentSignIn, true)
                .build()

            Navigation.findNavController(findViewById(R.id.navHostFragment))
                .navigate(R.id.action_signup, null,navOptions)
        }
    }
    fun toolBarSignUp(){
        toolbar.title = "Sign Up"
        toolbar.subtitle= "Register and eat"
        toolbar.navigationIcon = resources.getDrawable(R.drawable.ic_arrow_back_000,null)
        toolbar.setNavigationOnClickListener { onBackPressed()  }
    }
    fun toolBarSignUpAddress(){
        toolbar.title = "Address"
        toolbar.subtitle= " Make sure it's valid"
        toolbar.navigationIcon = resources.getDrawable(R.drawable.ic_arrow_back_000,null)
        toolbar.setNavigationOnClickListener { onBackPressed() }
    }
    fun toolBarSignUpSuccess(){
        toolbar.visibility = View.GONE
    }
}