package com.wahyukurnia.foodmarketkotlin.ui.auth.signin

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.google.gson.Gson
import com.wahyukurnia.foodmarketkotlin.FoodMarket
import com.wahyukurnia.foodmarketkotlin.R
import com.wahyukurnia.foodmarketkotlin.model.response.login.LoginResponse
import com.wahyukurnia.foodmarketkotlin.ui.MainActivity
import com.wahyukurnia.foodmarketkotlin.ui.auth.AuthActivity
import kotlinx.android.synthetic.main.fragment_signin.*


class SigninFragment : Fragment(),SigninContract.View {

    lateinit var presenter: SigninPresenter
    var progressBarDialog:Dialog? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_signin, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        presenter = SigninPresenter(this)

        if(!FoodMarket.getApp().getToken().isNullOrEmpty()){
            val home = Intent(activity,MainActivity::class.java)
            startActivity(home)
            activity?.finish()
        }

        initDummy()
        initView()

        btnSignup.setOnClickListener{
            val signup = Intent(activity,AuthActivity::class.java)
            signup.putExtra("page_request", 2)
            startActivity(signup)
        }
        btnSignin.setOnClickListener {
            var email = etEmail.text.toString()
            var password = etPassword.text.toString()

            if(email.isNullOrEmpty()){
                etEmail.error = "Silahkan masukan email Anda"
                etEmail.requestFocus()
            }else if (password.isNullOrEmpty()){
                etPassword.error = "Silahkan masukan password Anda"
                etPassword.requestFocus()
            }else{
                presenter.submitLogin(email,password)
            }
        }
    }

    override fun onLoginSuccess(loginResponse: LoginResponse) {
        FoodMarket.getApp().setToken(loginResponse.access_token)

        val gson = Gson()
        val json = gson.toJson(loginResponse.user)
        FoodMarket.getApp().setUser(json)

        val home = Intent(activity,MainActivity::class.java)
        startActivity(home)
        activity?.finish()
    }

    private fun initDummy(){
        etEmail.setText("wahyukurnia321123@gmail.com")
        etPassword.setText("wahyukurnia")
    }

    override fun onLoginFailed(message: String) {
        Toast.makeText(activity,message,Toast.LENGTH_SHORT).show()
    }
    private fun initView(){
        progressBarDialog = Dialog(requireContext())
        val dialogLayout = layoutInflater.inflate(R.layout.dialog_loader, null)

        progressBarDialog?.let {
            it.setContentView(dialogLayout)
            it.setCancelable(false)
            it.window?.setBackgroundDrawableResource(android.R.color.transparent)
        }
    }

    override fun showLoading() {
        progressBarDialog?.show()
    }

    override fun dismissLoading() {
        progressBarDialog?.dismiss()
    }
}