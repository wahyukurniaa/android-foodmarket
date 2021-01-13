package com.wahyukurnia.foodmarketkotlin.ui.auth.signin

import com.wahyukurnia.foodmarketkotlin.base.BasePresenter
import com.wahyukurnia.foodmarketkotlin.base.BaseView
import com.wahyukurnia.foodmarketkotlin.model.response.login.LoginResponse

interface SigninContract {
    interface View: BaseView {
        fun onLoginSuccess(loginResponse: LoginResponse)
        fun onLoginFailed(message:String)
    }
    interface Presenter :SigninContract , BasePresenter {
        fun submitLogin(email:String, password:String)
    }
}